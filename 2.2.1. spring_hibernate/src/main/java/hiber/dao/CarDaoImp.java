package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class CarDaoImp implements CarDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getUser(String model, int series){

        TypedQuery<User> query = sessionFactory.getCurrentSession()
                .createQuery("FROM User u where u.car.model = :model and u.car.series = :series", User.class);
        query.setParameter("model", model);
        query.setParameter("series", series);

        return query.getResultList();
    }
}
