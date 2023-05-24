package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
   public static void main(String[] args){
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user.toString());
      }


      List<User> userWithCar = userService.getUserWithCar("model3", 3);

      System.out.println("Пользователь с машиной");
      for (User user : userWithCar) {
         System.out.println(user.toString());
      }

      context.close();
   }
}
