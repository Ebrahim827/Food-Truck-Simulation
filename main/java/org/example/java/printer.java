package org.example.java;

import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class printer {


    static void addData(PathManager pm , AnchorPane p){
        final  CategoryAxis nodes = new CategoryAxis();
        final   NumberAxis amount = new NumberAxis();
        final  BarChart<String, Number > table = new BarChart<>(nodes , amount );

        table.setPrefWidth(300);
        table.setPrefHeight(300);
        // Optional: prevent it from shrinking too small
        table.setMinWidth(300);
        table.setMinHeight(300);

        XYChart.Series<String,Number> Series = new XYChart.Series<String, Number>();


        Platform.runLater(()->{
            p.getChildren().clear();
            if (!p.getChildren().contains(table)) {
                p.getChildren().add(table);
            }

            Series.getData().clear();
            table.getData().clear();

            for(int i = 0 ; i < pm.getPaths().size() ; i++){
                Series.getData().add(new XYChart.Data<>(pm.getPaths().get(i).getLocation(), pm.getPaths().get(i).getAmount() ));

            }


            table.getData().add(Series);

            AnchorPane.setTopAnchor(table, 20.0);
            AnchorPane.setLeftAnchor(table, 20.0);
        });


        }


    }






