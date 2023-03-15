package controllers.home;

import javafx.event.ActionEvent;
import utils.Routes;

import java.io.IOException;

public class VehicleClearance {
    public void goToDashboard(ActionEvent actionEvent) throws IOException {new Routes().goTo("../views/home/home.fxml", actionEvent);}
    public void goToSlots(ActionEvent actionEvent) throws IOException {new Routes().goTo("../views/home/slots.fxml", actionEvent);}
    public void goToFinancials(ActionEvent actionEvent) throws IOException {new Routes().goTo("../views/home/finacial_report.fxml", actionEvent);}

}
