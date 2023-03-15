package controllers.home;

import javafx.event.ActionEvent;
import utils.Routes;

import java.io.IOException;

public class FinancialReport {
    public void goToStatistics(ActionEvent actionEvent) throws IOException {new Routes().goTo("../views/home/v2.fxml", actionEvent);}
    public void goToSlots(ActionEvent actionEvent) throws IOException {new Routes().goTo("../views/home/slots.fxml", actionEvent);}
    public void vehicleClearance(ActionEvent actionEvent) throws IOException {new Routes().goTo("../views/home/vehicle_clearance.fxml", actionEvent);}

}
