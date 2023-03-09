package controllers.auth;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import utils.db_config;

public class Login {
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
        String pass = db_config.executeQuery(selectQuery);
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
                    error.setText("valid email / password");
                }
            }catch(Exception e){
                System.out.println("eee;"+e);
            }
        }
    }
}
