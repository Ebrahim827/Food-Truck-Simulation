package org.example.java;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class MainEngine extends Application {

    @FXML MenuButton nodeIncome;

    @FXML
    TextArea textArea;
    @FXML Text canvaprinter;

    @FXML Text infoText;
    @FXML
    MenuButton threadstar;
    @FXML
    MenuButton storebutton;
    @FXML Canvas c ;
    @FXML
    TextField TF;
    @FXML
    TextField Coordinate;
    @FXML
     TextField Ordinate;
    @FXML
     Text answer ;
    Color CanvasColor = Color.BLUE;

    @FXML
    ColorPicker magicColors;
    ArrayList<Thread> threads;


    Truck messengerTruck ;
    ArrayList<Application> menus ;
    Application dummymenues;
    PathManager dummypathManager;

    ArrayList<PathManager> pathManagers ;
    @FXML
    Rectangle bluerec;
    @FXML void red(){
        CanvasColor =  Color.RED;
        bluerec.setFill(CanvasColor);
    }
    @FXML void yellow(){
        CanvasColor =  Color.YELLOW;
        bluerec.setFill(CanvasColor);
    }
    @FXML void black(){
        CanvasColor =  Color.BLACK;
        bluerec.setFill(CanvasColor);
    }
    @FXML void colorMe(){
        CanvasColor = magicColors.getValue();
        bluerec.setFill(CanvasColor);
    }

    @FXML void save() throws IOException {

            Controlpoint.storeIt(pathManagers , infoText);


    }
    @FXML void retrive() throws IOException, ClassNotFoundException {
        pathManagers =   Controlpoint.getData(infoText);


    }

    @FXML void pathA(){
        dummypathManager = new RosePath();
        FlowershopMenu.slowText("Rose path initailted" , 10 , answer);
    }
    @FXML void PathB(){
        dummypathManager = new UrbanPath();
        FlowershopMenu.slowText("urbanPath is initialed" , 10 , answer);
    }
    @FXML void pizzamenu(){
        dummymenues = new Pizzamenu();
        FlowershopMenu.slowText("pizza Truck made hahah" , 10 , answer);
    }
    @FXML void iceCreamMenu(){
        dummymenues = new IceCreamShop();
        FlowershopMenu.slowText("iCEcREAM  Truck made hahah" , 10 , answer);

    }

    @FXML void reset(){
        dummypathManager = null;
        dummymenues = null;

    }

    @FXML MenuButton mb;




    @FXML
    AnchorPane anchorPane;
    @FXML Text infoText1;
    @FXML void Status(){

        StringBuilder s = new StringBuilder();
        for(int i = 0 ; i < pathManagers.size() ; i++){
            for(int j =0 ; j < pathManagers.get(i).getPaths().size() ; j++)

           s.append(String.format("""
                           Report analasis of truck %s
                           %s -> %s \n
                           
                           """, pathManagers.get(i).getClass().getCanonicalName() , pathManagers.get(i).getPaths().get(j).getLocation()
                   , pathManagers.get(i).getPaths().get(j).getAmount()));

        }

    FlowershopMenu.slowText(s.toString() , 10 , infoText1 );

    }
    @FXML void reset1(){
        infoText1.setText("");
    }


    @FXML void Input() throws Exception {
        answer.setText("");
        if(TF.getText().isEmpty() || Coordinate.getText().isEmpty() || Ordinate.getText().isEmpty()){
            FlowershopMenu.slowText("atlest enter the things no trucks starts today" , 100 , answer);

        } else if (dummypathManager == null || dummymenues == null ) {
            FlowershopMenu.slowText("PLZ SELECT BOTH OPTIONS" , 100 , answer);

        } else{
            messengerTruck = new Truck(Float.parseFloat(Coordinate.getText()) , Float.parseFloat(Ordinate.getText()) ,0, TF.getText());
            truckRegistry.setTruck(TF.getText() , messengerTruck);
            // this will store the truck in the registry
            answer.setText("");
            pathManagers.add(dummypathManager);
            menus.add(dummymenues);
            truckstarted("abc " , messengerTruck , pathManagers.getLast() , CanvasColor);
            Thread drawer = new Thread(new CanvaDrawer(messengerTruck , pathManagers.getLast() , c.getGraphicsContext2D() , CanvasColor , canvaprinter));
            drawer.start();
            threads.add(drawer);
            register(dummypathManager);
            menuopener(messengerTruck , dummymenues );
            FlowershopMenu.slowText("all done yayayyaya" , 10 , answer);
            dummymenues = null;
            dummypathManager = null;


        }
    }
    void menuopener(Truck truck ,Application p) throws Exception {

        MenuItem MI = new MenuItem(p.getClass().getName());
        TruckNameidentifier.setName(truck.getName());
        storebutton.getItems().add(MI);
        MI.setOnAction(e->{
            try {

                TruckNameidentifier.setName(truck.getName());
                p.start(new Stage());
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    void register(PathManager pk){
        MenuItem Ik = new MenuItem(pk.getClass().getCanonicalName());
        Ik.setOnAction(event->{
            printer.addData(pk , anchorPane );
        });
        nodeIncome.getItems().add(Ik);
    }

    void truckstarted( String s  , Truck messengerTruck , PathManager pathManager, Color se ){
        MenuItem S1 = new MenuItem(s + threads.size());;
        int size = threads.size();
        S1.setOnAction(e->{


            Thread.State state = threads.get(size).getState();
            switch (state){
                case Thread.State.NEW ->  threads.get(size).start();
                case Thread.State.TERMINATED ->{

                    Thread drawer = new Thread(new CanvaDrawer(messengerTruck , pathManagers.getLast() , c.getGraphicsContext2D() , se, canvaprinter ));
                    drawer.start();
                    threads.set( size,drawer);
                }
                case RUNNABLE, TIMED_WAITING -> {

                    threads.get(size).interrupt();

                }
            }

        });

        threadstar.getItems().add(S1);

    }

    public AnchorPane getAnchorPane() {
        return anchorPane;
    }

    @FXML
    void initialize(){
        pathManagers = new ArrayList<>();
        menus=new ArrayList<>();
        threads=new ArrayList<>();
    }



  @Override
public void start(Stage stage) throws Exception {
    FXMLLoader fxmlLoader = new FXMLLoader(MainEngine.class.getResource("Panel.fxml"));
    Scene scene = new Scene(fxmlLoader.load());
    stage.setTitle("Hello!");
    stage.setScene(scene);
    stage.show();
}
}
