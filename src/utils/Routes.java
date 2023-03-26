package utils;

import controllers.home.table.MainController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Routes {
    Stage stage;
    Scene scene;
    Parent root;
    public void goTo(String route, ActionEvent actionEvent) throws IOException {
        System.out.println(route);
        Parent root = FXMLLoader.load(getClass().getResource(route));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void goDashboard(String route,String email, ActionEvent actionEvent) throws IOException {
        System.out.println(route);

//        Parent root = FXMLLoader.load(getClass().getResource(route));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/home/home.fxml"));
        root = loader.load();
        MainController maincontroller = loader.getController();
        maincontroller.displayName(email);
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void financialReport(){

    }
    public void Slots(){

    }
    public void manualClearance(){

    }
}
