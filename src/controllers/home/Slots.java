package controllers.home;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import models.DbConfig;
import utils.Routes;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class Slots implements Initializable  {
    @FXML
    private AnchorPane C1R1S01;
    @FXML
    private AnchorPane C1R1S02;

    @FXML
    private AnchorPane C1R1S03;

    @FXML
    private AnchorPane C1R1S04;

    @FXML
    private AnchorPane C1R1S05;

    @FXML
    private AnchorPane C1R1S06;

    @FXML
    private AnchorPane C1R1S07;

    @FXML
    private AnchorPane C1R1S08;

    @FXML
    private AnchorPane C1R1S09;


    @FXML
    private AnchorPane C1R1S10;

    @FXML
    private AnchorPane C1R1S12;

    @FXML
    private AnchorPane C1R2S01;

    @FXML
    private AnchorPane C1R2S02;

    @FXML
    private AnchorPane C1R2S03;

    @FXML
    private AnchorPane C1R2S04;

    @FXML
    private AnchorPane C1R2S05;

    @FXML
    private AnchorPane C1R2S06;

    @FXML
    private AnchorPane C1R2S07;

    @FXML
    private AnchorPane C1R2S08;

    @FXML
    private AnchorPane C1R2S09;

    @FXML
    private AnchorPane C1R2S10;

    @FXML
    private AnchorPane C1R2S11;

    @FXML
    private AnchorPane C1R2S12;

    @FXML
    private AnchorPane C1R3S02;

    @FXML
    private AnchorPane C1R3S03;

    @FXML
    private AnchorPane C1R3S04;

    @FXML
    private AnchorPane C1R3S05;

    @FXML
    private AnchorPane C1R3S06;

    @FXML
    private AnchorPane C1R3S07;

    @FXML
    private AnchorPane C1R3S08;

    @FXML
    private AnchorPane C1R3S09;

    @FXML
    private AnchorPane C1R3S10;

    @FXML
    private AnchorPane C1R3S101;

    @FXML
    private AnchorPane C1R3S11;

    @FXML
    private AnchorPane C1R3S111;

    @FXML
    private AnchorPane C1R3S12;

    @FXML
    private AnchorPane C1R1S11;
    @FXML
    private AnchorPane C1R3S01;




    @FXML
    private AnchorPane C1R4S06;
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        AnchorPane[] panes = {
                C1R1S02,C1R1S03,C1R1S04,C1R1S05,C1R1S06,C1R1S07,C1R1S08,C1R1S09,C1R1S10,C1R1S11, C1R1S12,C1R2S01,C1R2S02,C1R2S03,C1R2S04,C1R2S05,C1R2S06,
                C1R2S07,C1R2S08,C1R2S09,C1R2S10,C1R2S11,C1R2S12,C1R3S01,C1R3S02,C1R3S03,C1R3S04,C1R3S05,C1R3S06,C1R3S07,C1R3S08, C1R3S09,C1R3S10,C1R3S11,C1R3S12,
        };
        System.out.println("--------");
        String[] colors = {"#2d2d2d","#2d2d2d"};
        ArrayList<String>[] vals = (ArrayList<String>[]) DbConfig.executeQuery("select * from slots");
        for (int k= 0; k < 2; k++) {
            ArrayList<String> innerList = vals[k];
            String color = colors[k];
            for (String element : innerList) {
                for (int i = 0; i < panes.length; i++) {
                    if (panes[i].getId().equals(element)) {
                             panes[i].setStyle("-fx-background-color: "+color);
                    }
                }

            }
        }
    }
    public void goToDashboard(ActionEvent actionEvent) throws IOException {new Routes().goTo("../views/home/home.fxml", actionEvent);}
    public void goToFinancials(ActionEvent actionEvent) throws IOException {new Routes().goTo("../views/home/finacial_report.fxml", actionEvent);}
    public void goToManualClearance(ActionEvent actionEvent) throws IOException {new Routes().goTo("../views/home/vehicle_clearance.fxml", actionEvent);}

}
