package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.sql.SQLException;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      Car car1 = new Car("model3", 12);
      Car car2 = new Car("model5", 25);
      Car car3 = new Car("model7", 4);
      Car car4 = new Car("model9", 78);

      User user1 = new User("User1", "LastName1", "user1@mail.io", car1);
      User user2 = new User("User2", "LastName2", "user2@mail.io", car2);
      User user3 = new User("User3", "LastName3", "user2@mail.io", car3);
      User user4 = new User("User4", "LastName4", "user3@mail.io", car4);

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);

      for (User user : userService.listUsers()) {
         System.out.println(user);
      }
      System.out.println("");

      System.out.println(userService.UserByCar("model3", 12));

      context.close();
   }
}