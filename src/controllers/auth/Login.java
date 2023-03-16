package controllers.auth;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import utils.DbConfig;
import utils.LoginManager;
import utils.Routes;

import java.io.IOException;
import java.util.prefs.Preferences;

public class Login {
    Routes route = new Routes();

    @FXML
    private Label create_account;
    @FXML
    private TextField email;
    @FXML
    private TextField password;
    @FXML
    private Button error;
    public void Login(ActionEvent actionEvent) {
        String email_text = email.getText();
        String password_text = password.getText();
        System.out.println("s");
        String selectQuery = "SELECT password FROM users WHERE username='"+email_text+"' OR email='"+email_text+"';";
        String pass = (String) DbConfig.executeQuery(selectQuery);
        System.out.println(pass);
        if(pass==null){
            error.setText("Invalid email / password");
        }else{
            try{
                Encryption encryption = new Encryption();
                boolean ENC = encryption.compare_hash(pass, password_text);
                System.out.println(ENC);
                if(ENC==false){
                    error.setText("Invalid email / password");
                }else{
                   new LoginManager().login(email_text,pass);

                    route.goDashboard("../views/home/home.fxml",email_text,actionEvent);
                }
            }catch(Exception e){
                System.out.println("eee;"+e);
            }
        }
    }

    public void loginCreate(ActionEvent actionEvent) throws IOException {
        route.goTo("../views/auth/signup.fxml",actionEvent);
    }
}
