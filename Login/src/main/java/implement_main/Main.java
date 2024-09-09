package implement_main;

import service.Service;
import Dao.LoginDao;
import Dao.LoginDaoInterface;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LoginDaoInterface loginDao = new LoginDao();
        Service service = new Service(loginDao);

        while (true) {
            System.out.println("1. Register User");
            System.out.println("2. Remove User");
            System.out.println("3. Validate User");
            System.out.println("4. Change Password");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    service.registerUser();
                    break;

                case 2:
                    service.removeUser();
                    break;

                case 3:
                    System.out.print("Enter User ID: ");
                    String userId = scanner.nextLine();
                    System.out.print("Enter Password: ");
                    String password = scanner.nextLine();
                    if (loginDao.validateUser(userId, password)) {
                        System.out.println("User validated successfully.");
                    } else {
                        System.out.println("Invalid User ID or Password.");
                    }
                    break;

                case 4:
                    System.out.print("Enter User ID: ");
                    userId = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();
                    if (loginDao.verifyUserForPasswordChange(userId, email)) {
                        System.out.print("Enter New Password: ");
                        String newPassword = scanner.nextLine();
                        if (loginDao.changePassword(userId, newPassword)) {
                            System.out.println("Password changed successfully.");
                        } else {
                            System.out.println("Failed to change password.");
                        }
                    } else {
                        System.out.println("Invalid User ID or Email.");
                    }
                    break;

                case 0:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        }
    }
}
