package UserRegistration;

import UserRegistration.model.User;
import UserRegistration.service.FileService;
import UserRegistration.service.LoginService;
import UserRegistration.service.UserService;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class UserMain {
    public final static String PATH = new File("").getAbsolutePath() + File.separator + "database.txt";

    public static void main(String[] args) {

        List<User> users = Collections.emptyList();

        try {
            users = UserService.convertLinesToUsers(FileService.read(PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scanner s = new Scanner(System.in);
        boolean isActive = true;
        while (isActive) {
            System.out.println("1. Register new user account");
            System.out.println("2. Login with username/password: ");
            System.out.println("3. Exit");
            int ch = s.nextInt();

            switch (ch) {
                case 1:
                    User newUser = LoginService.register();
                    users.add(newUser);
                    try {
                        FileService.append(PATH, newUser.toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    System.out.println("Your Username: ");
                    String u = s.next();
                    System.out.println("Password: ");
                    String p = s.next();
                    if (LoginService.login(u, p)) {
                        System.out.println("User " + u + " successfully logged in!");
                    } else {
                        System.out.println("Invalid input data. Invalid login or password");
                    }
                    break;
                case 3:
                    isActive = false;
                    break;
                default:
                    System.out.println("Please choose valid option");
            }
        }


    }

}
