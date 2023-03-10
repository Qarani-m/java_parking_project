package controllers.home.table;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.collections.FXCollections;

public class Piechart {
    public Piechart(PieChart pie_chart){
        PieChart.Data slice1 = new PieChart.Data("Free", 25);
        PieChart.Data slice2 = new PieChart.Data("Reserved ", 35);
        PieChart.Data slice3 = new PieChart.Data("Occupied", 40);

        pie_chart.getData().addAll(slice1, slice2, slice3);
        pie_chart.setLegendVisible(false);

        Platform.runLater(() -> {
            slice1.getNode().setStyle("-fx-pie-color: #dc143c;");
            slice2.getNode().setStyle("-fx-pie-color: #4c4c7c;");
            slice3.getNode().setStyle("-fx-pie-color: b9b9b9;");
            Font font = Font.font("Verdana", FontWeight.BOLD, 12);

        });



    }
}
