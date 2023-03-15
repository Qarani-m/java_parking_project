package controllers.home;

import javafx.event.ActionEvent;
import utils.Routes;

import java.io.IOException;

public class VehicleClearance {
    public void goToStatistics(ActionEvent actionEvent) throws IOException {new Routes().goTo("../views/home/v2.fxml", actionEvent);}
    public void goToSlots(ActionEvent actionEvent) throws IOException {new Routes().goTo("../views/home/finacial_report.fxml", actionEvent);}
    public void financialReport(ActionEvent actionEvent) throws IOException {new Routes().goTo("../views/home/vehicle_clearance.fxml", actionEvent);}

}
