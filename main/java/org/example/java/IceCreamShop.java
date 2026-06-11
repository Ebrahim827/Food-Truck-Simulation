package org.example.java;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class IceCreamShop extends Application {

    @FXML Text info;

Truck truck;
IceCreams iceCreams;
 @FXML void vanalla(){
    iceCreams = new Vanalla();
     FlowershopMenu.slowText(iceCreams.getDiscription() , 10  , info);
    }
    @FXML void mango(){
        iceCreams = new Mango();
        FlowershopMenu.slowText(iceCreams.getDiscription() , 10  , info);
    }
    @FXML void ChocolateChips(){
        iceCreams = new ChocolateChips();
        FlowershopMenu.slowText(iceCreams.getDiscription() , 10  , info);
    }
    @FXML void honey(){
        iceCreams = new Honey();
        FlowershopMenu.slowText(iceCreams.getDiscription() , 10  , info);
    }
    @FXML void setwaffles(){
     iceCreams = new WaffleCone(iceCreams);
     FlowershopMenu.slowText(iceCreams.getDiscription() , 10  , info);
    }
    @FXML void setCakecone(){
        iceCreams = new CakeCone(iceCreams);
        FlowershopMenu.slowText(iceCreams.getDiscription() , 10  , info);
    }




    @FXML void setchocoTopping(){
        iceCreams = new ChocolateSause(iceCreams);
        FlowershopMenu.slowText(iceCreams.getDiscription() , 10  , info);

    }

    @FXML void price(){
        FlowershopMenu.slowText("" +iceCreams.getAmount() , 10  , info);
    }

    @FXML void clear(){
        iceCreams = null;
        FlowershopMenu.slowText("ohh was there a problem report to the managmenrt ", 10  , info);
    }
    @FXML void Orderingup(){
        truck.setAmount(iceCreams.getAmount() + truck.getAmount());
        FlowershopMenu.slowText("all done enjoy you have been costed a bill of " + iceCreams.getAmount() , 10 ,info);
        iceCreams = null;
 }

    @FXML void initialize(){

        this.truck = truckRegistry.gettruck(TruckNameidentifier.getName());

    }


    @Override
    public void start(Stage stage) throws Exception {


            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("IceCreamMenu.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();

    }
}
