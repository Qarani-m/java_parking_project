package controllers.auth;
import utils.DbConfig;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.security.NoSuchAlgorithmException;

public class Signup {
    @FXML
    private TextField email;
    @FXML
    private TextField username;
    @FXML
    private TextField phone;
    @FXML
    private TextField password;
    @FXML
    private TextField confirm_password;
    @FXML
    private Button error_msg;
    public void initialize() {
        email.setOnKeyPressed(event -> {
            try {
                sanitize_email();
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        });
        phone.setOnKeyPressed(event -> {sanitize_phone();});
        password.setOnKeyPressed(event -> {sanitize_password();});
    }
    public void Signup(ActionEvent actionEvent) throws NoSuchAlgorithmException {
        String email_= email.getText();
        String username_ = username.getText();
        String phone_ = phone.getText();
        String password_ = password.getText();
        String confirm_password_ = confirm_password.getText();
        boolean valid_email = sanitize_email();
        boolean valid_phone = sanitize_phone();
        boolean valid_password = sanitize_password();
        boolean valid_cpassword = sanitize_cpassword();
        if(valid_email==true&&valid_phone==true&&valid_password==true&&valid_cpassword==true){
            save_to_database(email_, username_,phone_, new Encryption().hashPassword(password_));
        }else{
            error_msg.setText("An error occured, try again latter");
        }
    }
    private boolean sanitize_cpassword() {
        System.out.println(password.getText());
        System.out.println(confirm_password.getText());
        if(password.getText().equals(confirm_password.getText())){
            password.setStyle("-fx-border-color: #2e3333;");
            error_msg.setText("");
            return true;
        }else{
            password.setStyle("-fx-border-color: #dc143c");
            error_msg.setText("Password mismatch");
            return false;
        }
    }

    private void save_to_database(String email, String username, String phone, String password) {
        String insertQuery = "INSERT INTO users (username, email, phone, password) " +"VALUES ('" + username + "', '" + email + "', " + phone + ", '" + password + "')";
        DbConfig.executeQuery(insertQuery);
    }

    private boolean sanitize_phone() {
        String pattern = "^07\\d{8}$";
        if (!phone.getText().matches(pattern)) {
            phone.setStyle("-fx-border-color: #dc143c;");
            error_msg.setText("Invalid Phone number");
            return false;
        }else{
            email.setStyle("-fx-border-color: #2e3333;");
            error_msg.setText("");
            return true;
        }
    }
    private boolean sanitize_password() {
        if (password.getText().length() < 8) {
            password.setStyle("-fx-border-color: #dc143c;");
            error_msg.setText("Password must be 8 or more characters");
            return false;
        }else{
            password.setStyle("-fx-border-color: #2e3333;");
            error_msg.setText("");
            return true;
        }
    }
    public boolean sanitize_email() throws NoSuchAlgorithmException {
        String email_= email.getText();


        if (email_.contains("@")) {
            email.setStyle("-fx-border-color: #2e3333;");
            error_msg.setText("");
            return true;
        } else if (!(email_.contains("@"))) {
            email.setStyle("-fx-border-color: #dc143c;");
            error_msg.setText("Invalid email");
            return false;
        } else {
            return false;
        }
    }
}
