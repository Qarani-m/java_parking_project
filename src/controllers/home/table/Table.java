package controllers.home.table;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import utils.db_config;

import java.net.URL;
import java.util.ResourceBundle;



public class Table implements Initializable {
    @FXML
    private TableView<Vehicle> table;
    @FXML
    private TableColumn<Vehicle, String> date_column;
    @FXML
    private TableColumn<Vehicle, String> plates_column;
    @FXML
    private TableColumn<Vehicle, String> slotnumber_column;
    @FXML
    private TableColumn<Vehicle, String> entrytime_column;
    @FXML
    private TableColumn<Vehicle, String> departuretime_column;
    @FXML
    private TableColumn<Vehicle, String> charge_column;
    @FXML
    private TableColumn<Vehicle, String> paymentid_column;


    @FXML
    private BarChart<?, ?> bar_chart;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        new Barchart(bar_chart);
        db_config db = new db_config();
        date_column.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("date_column"));
        plates_column.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("plates_column"));
        slotnumber_column.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("slotnumber_column"));
        entrytime_column.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("entrytime_column"));
        departuretime_column.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("departuretime_column"));
        charge_column.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("charge_column"));
        paymentid_column.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("paymentid_column"));
        table.setItems((ObservableList<Vehicle>) db.executeQuery("select * from lot"));
    }
}
