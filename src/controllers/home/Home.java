package controllers.home;
import controllers.home.table.Barchart;
import controllers.home.table.Table;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;

public class Home {
    @FXML
    private BarChart<?, ?> bar_chart;
    public Home(BarChart<?, ?> barChart){
        bar_chart = barChart;
        new Barchart(bar_chart);
        new Table();
    }
}
