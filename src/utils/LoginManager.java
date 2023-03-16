package utils;

import java.io.*;
import java.util.*;

public class LoginManager {
    private static final String LOGIN_FILE = "login.dat";
    private static final long EXPIRATION_TIME = 60 * 60 * 1000; // 1 hour in milliseconds

    public static boolean isLoggedIn() {
        File file = new File(LOGIN_FILE);
        if (file.exists()) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
                LoginInfo loginInfo = (LoginInfo) in.readObject();
                long elapsedTime = System.currentTimeMillis() - loginInfo.getLoginTime();
                if (elapsedTime <= EXPIRATION_TIME) {
                    return true;
                }
            } catch (Exception e) {
                // ignore
            }
        }
        return false;
    }

    public static void login(String username, String password) {
        LoginInfo loginInfo = new LoginInfo(username, System.currentTimeMillis());
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(LOGIN_FILE))) {
            out.writeObject(loginInfo);
        } catch (IOException e) {
            System.out.println("loginmanager"+e);
        }
    }

    public static void logout() {
        File file = new File(LOGIN_FILE);
        if (file.exists()) {
            file.delete();
        }
    }

    private static class LoginInfo implements Serializable {
        private String username;
        private long loginTime;

        public LoginInfo(String username, long loginTime) {
            this.username = username;
            this.loginTime = loginTime;
        }



        public long getLoginTime() {
            return loginTime;
        }
        public String getUsername() {
            return username;
        }
    }
}
