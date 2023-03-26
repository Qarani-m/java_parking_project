package controllers.home.table;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import java.io.IOException;

public class Test {
    private static Stage stage;
    private Scene scene;

    public static void main(String[] args) {



    }
    public void t(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("./views/home/slots.fxml"));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
