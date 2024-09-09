package service;

import Dao.LoginDaoInterface;
import model.Login;

import java.util.Scanner;

public class Service {

    private final LoginDaoInterface loginDao;
    private final Scanner scanner = new Scanner(System.in);

    public Service(LoginDaoInterface loginDao) {
        this.loginDao = loginDao;
    }

    public void registerUser() {
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        Login login = new Login(userId, password, email);
        if (loginDao.registerUser(login)) {
            System.out.println("User registered successfully.");
        } else {
            System.out.println("Failed to register user. User ID may already be taken.");
        }
    }

    public void removeUser() {
        System.out.print("Enter User ID to remove: ");
        String userId = scanner.nextLine();

        if (loginDao.removeUser(userId)) {
            System.out.println("User removed successfully.");
        } else {
            System.out.println("Failed to remove user. User ID may not exist.");
        }
    }

    public void validateUser() {
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        if (loginDao.validateUser(userId, password)) {
            System.out.println("Welcome to my Login app.");
        } else {
            System.out.println("Incorrect User ID or Password.");
        }
    }

    // Change user password
    public void changePassword() {
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter New Password: ");
        String newPassword = scanner.nextLine();

        // Verify if User ID and Email match
        if (loginDao.verifyUserForPasswordChange(userId, email)) {
            if (loginDao.changePassword(userId, newPassword)) {
                System.out.println("Password changed successfully.");
            } else {
                System.out.println("Failed to change password.");
            }
        } else {
            System.out.println("User ID and Email do not match.");
        }
    }
}
