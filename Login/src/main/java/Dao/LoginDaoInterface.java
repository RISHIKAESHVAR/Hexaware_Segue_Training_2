package Dao;

import model.Login;

public interface LoginDaoInterface {

    boolean registerUser(Login login);

    boolean removeUser(String userId);

    boolean validateUser(String userId, String password);

    boolean verifyUserForPasswordChange(String userId, String email);

    boolean changePassword(String userId, String newPassword);
}
