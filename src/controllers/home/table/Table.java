package controllers.home.table;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import utils.db_config;
import javafx.collections.FXCollections;

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
    private PieChart pie_chart;
    @FXML
    private BarChart<?, ?> bar_chart;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        db_config db = new db_config();
        tebles_setup(db);

        new Barchart(bar_chart);
        new Piechart(pie_chart);










    }

    private void tebles_setup(db_config db) {
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
