package UserRegistration.service;

import UserRegistration.model.User;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class LoginService {

    public static User register() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Your First Name: ");
        String fn = s.next();
        System.out.println("Enter Your Last Name: ");
        String ln = s.next();
        String email;
        while (true) {
            System.out.println("Enter email address (ex. john@gmail.com): ");
            email = s.next();
            if (UserService.isValidEmailAddress(email))
                break;
            System.out.println("Invalid email address. Please enter your email in 'john@gmail.com' format");
        }

        String username;

        while (true) {
            System.out.println("Enter username (min. 11 characters): ");
            username = s.next();

            if (username.length() > 10) {

                if (UserService.isValidUserName(username)) {
                    break;
                }
                System.out.println("Username " + username + " already taken. Try again!");
                continue;
            }
            System.out.println("Make sure your username has at least 11 characters");
        }

        String pwd;

        while (true) {
            System.out.println(" Set a password (min 9 characters, 2 uppercase letters, 3 numbers): ");
            pwd = s.next();
            if (UserService.isValidPwd(pwd)) break;

            System.out.println("Weak password. Try again!");
        }

        return new User(fn, ln, email, username, hashMD5(pwd));
    }


    public static boolean login(String username, String pwd) {
        return UserService.isUserRegistered(username, hashMD5(pwd));
    }

    public static String hashMD5(String pwd) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");

            md.update(pwd.getBytes(StandardCharsets.UTF_8));

            byte[] hashBytes = md.digest();

            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}
