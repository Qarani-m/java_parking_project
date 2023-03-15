package controllers.home.table;

import controllers.home.Slots;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;
import utils.DbConfig;
import utils.Routes;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class MainController extends Thread implements Initializable{
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
    private Label weekly_income;
    @FXML
    private Label revenue;
    @FXML
    private TextField searchbar;
    @FXML
    private Button booked_btn;
    @FXML
    private Button reservation_btn;
    @FXML
    private Label turnover;




    String table_name = "lot";
    String searchQuery = "select * from "+table_name+" ORDER BY id DESC;";

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println(searchQuery);

        DbConfig db = new DbConfig();
        tables_setup(db);
        new Barchart(bar_chart);
        Statistics st =new Statistics();
        st.start();


        timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            new Slots();
            reserved_space.setText(String.valueOf(st.reservation_count));
            free_space.setText(String.valueOf(st.free_space));
            percent_occupancy.setText(String.valueOf(st.percent_occupancy));
            occupied.setText(String.valueOf(st.capacity));
            filled_floors.setText(String.valueOf(st.filled_floors));
            avg_time.setText(String.valueOf(st.avg_time));
            revenue.setText("$ "+st.todays_income);
            weekly_income.setText("$ "+st.weekly_income);
            turnover.setText(st.turnover_rate+" %");
            table.getItems().clear();
            String s = "select * from "+ table_name+" order by id desc";
            if(searchbar.getText().length()==0){searchQuery =s; table.setItems((ObservableList<Vehicle>) db.executeQuery(searchQuery));}
            else{table.setItems((ObservableList<Vehicle>) db.executeQuery(searchQuery));}
            tables_setup(db);
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
    public void search_db(KeyEvent keyEvent) {searchQuery="select * from lot where plate_number like '%"+searchbar.getText()+"%'";}

    private void tables_setup(DbConfig db) {
        date_column.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("date_column"));
        plates_column.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("plates_column"));
        slotnumber_column.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("slotnumber_column"));
        entrytime_column.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("entrytime_column"));
        departuretime_column.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("departuretime_column"));
        charge_column.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("charge_column"));
        paymentid_column.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("paymentid_column"));
    }
    public void booked_table(ActionEvent actionEvent) {
        table_name = "lot";
        booked_btn.setStyle("-fx-background-color: #dc143c;");
        reservation_btn.setStyle("-fx-background-color: #2d2d2d;");
    }
    public void reservation_table(ActionEvent actionEvent) {
        table_name = "reservations";
        reservation_btn.setStyle("-fx-background-color: #dc143c;");
        booked_btn.setStyle("-fx-background-color: #2d2d2d;");
    }

    public void gotToSlots(ActionEvent actionEvent) throws IOException {
        new Routes().goTo("../views/home/slots.fxml", actionEvent);
    }
}
