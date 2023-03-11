package controllers.home.table;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;
import utils.db_config;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;


public class Table extends Thread implements Initializable{
    private Timeline timeline;

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
    @FXML
    private Label reserved_space;
    @FXML
    private Label free_space;
    @FXML
    private Label percent_occupancy;
    @FXML
    private Label occupied;
    @FXML
    private Label filled_floors;
    @FXML
    private Label avg_time;
    @FXML
    private Label revenue;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        db_config db = new db_config();
        tables_setup(db);
        new Barchart(bar_chart);
        new Piechart(pie_chart);
        Statistics st =new Statistics();
        st.start();
        timeline = new Timeline(new KeyFrame(Duration.seconds(3), event -> {
            reserved_space.setText(String.valueOf(st.reservation_count));
            free_space.setText(String.valueOf(st.free_space));
            percent_occupancy.setText(String.valueOf(st.percent_occupancy));
            occupied.setText(String.valueOf(st.capacity));
            filled_floors.setText(String.valueOf(st.filled_floors));
            avg_time.setText(String.valueOf(st.avg_time));
//            revenue.setText(String.valueOf(st.avg_time));
            revenue.setText("21,342");
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void tables_setup(db_config db) {
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
