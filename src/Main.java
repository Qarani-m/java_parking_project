    import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static utils.LoginManager.isLoggedIn;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);

    }
    @Override
    public void start(Stage stage) throws Exception {
        try {
            String start = null;
             if(isLoggedIn()==false){
                   start = "views/auth/login.fxml";
             }
             if(isLoggedIn()==true) {
                start= "views/home/home.fxml";
             }
             
                Parent root = FXMLLoader.load(getClass().getResource(start));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}