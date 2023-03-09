package controllers.auth;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class Encryption {
    public static void main(String[] args) {}

    public static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        for (byte b : hash) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
    public static boolean compare_hash(String hash, String plaintext) throws NoSuchAlgorithmException {
        String storedHashedPassword = hash;
        String enteredPassword = plaintext;
        String enteredHashedPassword = hashPassword(enteredPassword);
        if (enteredHashedPassword.equals(storedHashedPassword)) {
            return true;
        } else {
            return false;
        }
    }
}
