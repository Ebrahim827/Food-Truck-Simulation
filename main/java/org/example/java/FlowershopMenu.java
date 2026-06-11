package org.example.java;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FlowershopMenu extends Application {

    static Timeline T;


    private ArrayList<Double> total;





    @FXML void initialize(){

        total = new ArrayList<>();

    }

    @FXML void Prawn(){

    }
    @FXML void FishMasala(){
    }

    @FXML void submit(){
        double cost = 0;


    }

    @FXML void yes(){



    }




    @FXML
    Text DText;

    @Override
    public void start(Stage stage) throws Exception {

        // Using getClass() ensures it looks in the same package as this file
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("flowerfoodmenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        fxmlLoader.setController(this);

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();




    }

    @FXML
    void curries(){

        if (T != null) {
            T.stop();
        }
        DText.setText("");


        slowText("welcome we offer the most esqusit curries " , 50 , DText);


}

  static  public  void slowText(String msg , int x , Text dialog){

        dialog.setText("");
        final int[] i = {0};
        KeyFrame ticks = new KeyFrame(Duration.millis(x), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {





                if(i[0] < msg.length()){

                    dialog.setText(dialog.getText() + msg.charAt(i[0]));
                    i[0]++;

                }
            }
        });

        T = new Timeline(ticks);
        T.setCycleCount(msg.length());
        T.play();

    }
}






