package controllers.home.table;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import utils.db_config;

import java.util.Arrays;
import java.util.List;

public class Barchart {
    public Barchart(BarChart<?, ?> bar_chart){
        List<String> colors = Arrays.asList("#dc143c", "#0146ad", "#b9b9b9");

        XYChart.Series series1= new XYChart.Series();
        XYChart.Series series2= new XYChart.Series();
        XYChart.Series series3= new XYChart.Series();


        int[] vals = {};
        String[][] dates={
                {"2023-01-01","2023-01-31"},
                {"2023-02-01","2023-03-31"},
                {"2023-03-01","2023-03-31"},
        };
        String[] sizes={"S", "M","L"};
        String[] months={};

        for (int i = 0; i < sizes.length; i++) {
            for (int j = 0; j < dates.length; j++) {
                String q ="select count(*) from lot where size_ = '"+sizes[i]+"' and date_ between'"+dates[j][0]+"' and '"+dates[j][1]+ "'";
                Object target=  db_config.executeQuery(q);
                System.out.println(target+"-----"+q);
            }
        }










        series1.setName("small");
        series1.getData().add(new XYChart.Data("JAN",171));
        series1.getData().add(new XYChart.Data("FEB",212));
        series1.getData().add(new XYChart.Data("MAR",150));
        new db_config().executeQuery("select count(*) from lot where ");
        series2.setName("medium");
        series2.getData().add(new XYChart.Data("JAN",122));
        series2.getData().add(new XYChart.Data("FEB",200));
        series2.getData().add(new XYChart.Data("MAR",78));

        series3.setName("Large");
        series3.getData().add(new XYChart.Data("JAN",30));
        series3.getData().add(new XYChart.Data("FEB",54));
        series3.getData().add(new XYChart.Data("MAR",10));


        bar_chart.setStyle(".chart-legend-item-symbol { -fx-background-color: red; } .chart-legend-item-text { -fx-text-fill: red; }");
        bar_chart.getData().addAll(series1,series2,series3);











//        Node node = ((XYChart.Data<String, Number>) series1.getData().get(0)).getNode();
//        String c  = "dc143c";
//        node.setStyle("-fx-bar-fill: " + c + ";");
//        node.setStyle(".chart-legend-item-symbol: red; ");
//        Node node1 = ((XYChart.Data<String, Number>) series1.getData().get(1)).getNode();
//        node1.setStyle("-fx-bar-fill: " + c + ";");
//        node.setStyle("-fx-bar-fill: " + c + ";");
//        Node node2 = ((XYChart.Data<String, Number>) series1.getData().get(2)).getNode();
//        node2.setStyle("-fx-bar-fill: " + c + ";");
//        node2.setStyle("-fx-bar-fill: " + c + ";");
//        Node series2_node = ((XYChart.Data<String, Number>) series2.getData().get(0)).getNode();
//        String series2_color  = colors.get(1);
//        series2_node.setStyle("-fx-bar-fill: " + series2_color + ";");
//        Node series2_node1 = ((XYChart.Data<String, Number>) series2.getData().get(1)).getNode();
//        series2_node1.setStyle("-fx-bar-fill: " + series2_color + ";");
//        Node series2_node2 = ((XYChart.Data<String, Number>) series2.getData().get(2)).getNode();
//        series2_node2.setStyle("-fx-bar-fill: " + series2_color + ";");

    }
}
