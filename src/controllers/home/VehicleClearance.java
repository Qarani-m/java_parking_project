package controllers.home;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import models.DbConfig;
import utils.Routes;

import java.awt.*;
import java.io.IOException;

public class VehicleClearance {
    @FXML
    private TextField plate;

    public void delete(ActionEvent actionEvent) throws IOException {
        String plate_ = plate.getText();
        String q1 = "delete from  reservations where plate_number='"+plate_+"';";
        DbConfig cfg = new DbConfig();
        DbConfig.executeQuery(q1);


        new Routes().goTo("../views/home/home.fxml", actionEvent);
    }
    public void goToDashboard(ActionEvent actionEvent) throws IOException {new Routes().goTo("../views/home/home.fxml", actionEvent);}
    public void goToSlots(ActionEvent actionEvent) throws IOException {new Routes().goTo("../views/home/slots.fxml", actionEvent);}
    public void goToFinancials(ActionEvent actionEvent) throws IOException {new Routes().goTo("../views/home/finacial_report.fxml", actionEvent);}

}
