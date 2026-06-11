package org.example.java;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Pizzamenu extends Application {

    @FXML
    Text answer;
    @FXML
    Polygon Shape;
    private float amount;
    private  Truck truck;
    public float getAmount() {
        return amount;
    }


    public void setAmount(float amount) {
        this.amount = amount;
    }


    @FXML void initialize(){

        this.truck = truckRegistry.gettruck(TruckNameidentifier.getName());

    }

    ArrayList<Float> burgers = new ArrayList<>();
    ArrayList<Float> spirals = new ArrayList<>();
    ArrayList<Float> fries = new ArrayList<>();

    @FXML
    void Burger(){
        burgers.add(10f);
        truck.setAmount(truck.getAmount() + burgers.getLast());
        FlowershopMenu.slowText("Burger updated 10 dollers cost added" , 10 ,answer);
        Shape.setFill(Color.CORAL);

    }

    @FXML
    void Fries(){
        fries.add(5f);
        truck.setAmount(truck.getAmount() + fries.getLast());
        FlowershopMenu.slowText(" Fries 10 dollers cost added" , 10 ,answer);
        Shape.setFill(Color.ROSYBROWN);


    }

    @FXML
    void Spiral(){
        spirals.add(15f);
        truck.setAmount(truck.getAmount() + spirals.getLast());
        FlowershopMenu.slowText(" Spiral 15 dollers cost added" , 10 ,answer);
        Shape.setFill(Color.PLUM);

    }

    @FXML
    void total(){
        float total = 0f;
        for(float f : spirals){
            total += f;
        }
        for(float f : fries){
            total += f;
        }
        for(float f : burgers){
            total += f;
        }
        FlowershopMenu.slowText("your total is " + total+ " ruppes " ,  10  , answer);
    }

    @FXML
    void Sp(){
        float total = 0;

        for(float f : spirals){
            total += f;
        }
        FlowershopMenu.slowText("your spirals dish count is " + total +" ruppes " , 10 , answer);
    }


    @FXML
    void br(){
        float total = 0;

        for(float f : burgers){
            total += f;
        }
        FlowershopMenu.slowText("your burgers dish count is " + total + " ruppes " ,  10  , answer);
    }


    @FXML
    void fr(){
        float total = 0;

        for(float f : fries){
            total += f;
        }
        FlowershopMenu.slowText("your fries dish count is " + total +" ruppes " , 10  , answer);
    }

    @FXML
    void reset(){
        float total = 0;
        for(float f : spirals){
            total += f;
        }

        for(float f : fries){
            total += f;
        }
        for(float f : burgers){
            total += f;
        }
        truck.setAmount(truck.getAmount() - total );
        burgers.clear();
        fries.clear();
        spirals.clear();
        FlowershopMenu.slowText("your menu is now reseted "  , 10  , answer);

    }








    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("pizzamenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}
