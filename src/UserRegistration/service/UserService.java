package UserRegistration.service;

import UserRegistration.UserMain;
import UserRegistration.model.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class UserService {

    public static boolean isValidEmailAddress (String email) {
        final Pattern ptr = Pattern.compile("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$", Pattern.CASE_INSENSITIVE);
        return email.matches(String.valueOf(ptr));
    }

    public static boolean isValidPwd(String pwd) {
        if (pwd.length() < 9) return false;

        Pattern onlyUpperCaseLetters = Pattern.compile("[A-Z]");
        Pattern onlyNumbers = Pattern.compile("[0-9]");
        long numbersCount = onlyNumbers.matcher(pwd).results().count();
        long upperCaseLettersCount = onlyUpperCaseLetters.matcher(pwd).results().count();

        return numbersCount == 3 && upperCaseLettersCount == 2;
    }

    public static boolean isValidUserName(String username) {
        return username.length() > 10 && !isUserDuplicate(username);
    }

    public static boolean isUserDuplicate(String username) {
        
        List<User> users = new ArrayList<>(Collections.emptyList());
        try {
            users = getAllUsers();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Iterator<User> it = users.iterator();

        while (it.hasNext()) {
            if (it.next().getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isUserRegistered(String username, String pwd) {
        List<User> users = new ArrayList<>(Collections.emptyList());

        try {
            users = getAllUsers();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Iterator<User> it = users.iterator();

        while (it.hasNext()) {
            User user = it.next();
            if (user.getUsername().equals(username) && user.getPwd().equals(pwd)) {
                return true;
            }
        }
        return false;
    }

    public static User convert(String line) {
        String[] l = line.split(",");
        final String fn = l[0];
        final String ln = l[1];
        final String uName = l[2];
        final String email = l[3];
        final String pwd = l[4];

        return new User(fn, ln, email, uName, pwd);
    }

    public static List<User> convertLinesToUsers(List<String> list) {
        List<User> u = new ArrayList<>(Collections.emptyList());

        for (String line : list) {
            // prevent line breaks & whitespace
            if (line.length() <= 2) continue;
            u.add(convert(line));
        }

        return u;
    }

    public static List<User> getAllUsers() throws IOException {

       return convertLinesToUsers(FileService.read(UserMain.PATH));
    }

}