/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontend;

import PojoClass.pojo;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;

/**
 * FXML Controller class
 *
 * @author KL RAHUL
 */
public class ChartScreenController implements Initializable {

    @FXML
    private PieChart pie_chart;
    @FXML
    private StackedBarChart<PojoClass.pojo, Integer> bar_chart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void Refresh_pie_button(ActionEvent event) {
        ObservableList<Data> list = FXCollections.observableArrayList(
                new PieChart.Data("Rahul", 10),
                new PieChart.Data("Vimal", 20),
                new PieChart.Data("Dhinesh", 30),
                new PieChart.Data("Suresh", 40),
                new PieChart.Data("Mani", 50)
        );
        
        pie_chart.setData(list);
        System.out.println("hello");
    }

    @FXML
    private void Refresh_bar_button(ActionEvent event) {
         XYChart.Series series1 = new XYChart.Series();
         series1.setName("2025");
         series1.getData().add(new XYChart.Data("Rahul", 10));
         series1.getData().add(new XYChart.Data("Vimal", 20));
         series1.getData().add(new XYChart.Data("Dhinesh", 30));
         series1.getData().add(new XYChart.Data("Suresh", 40));
         series1.getData().add(new XYChart.Data("Mani", 50));
         
          XYChart.Series series2 = new XYChart.Series();
         series2.setName("2026");
         series2.getData().add(new XYChart.Data("Rahul", 10));
         series2.getData().add(new XYChart.Data("Vimal", 20));
         series2.getData().add(new XYChart.Data("Dhinesh", 30));
         series2.getData().add(new XYChart.Data("Suresh", 40));
         series2.getData().add(new XYChart.Data("Mani", 50));
 
         
         bar_chart.getData().addAll(series1,series2);
    }

}
