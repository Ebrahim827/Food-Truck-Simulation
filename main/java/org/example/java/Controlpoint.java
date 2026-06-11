package org.example.java;

import javafx.scene.text.Text;

import java.io.*;
import java.util.ArrayList;

public class Controlpoint {


    static ArrayList<growthMenu> menu;



    static  void  storeIt(ArrayList<PathManager> pm , Text text) throws IOException {
      try {
          ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("pathData"));
          objectOutputStream.writeObject(pm);
          FlowershopMenu.slowText("saving succesfull " , 10  ,text);

      }catch (Exception e){
         FlowershopMenu.slowText("error loading didnt work out " , 10  ,text);
      }



    }
    static ArrayList<PathManager> getData(Text text) throws IOException, ClassNotFoundException {
       try {
           ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("pathData"));
           FlowershopMenu.slowText("loading successfull " , 10  ,text);
           return (ArrayList<PathManager>)objectInputStream.readObject();


       }catch (Exception e){
           FlowershopMenu.slowText("error loading didnt work out " , 10  ,text);
       }
        return  new ArrayList<>();
    }



}
class growthMenu implements  Serializable{
    float growth;
    String name;

    public growthMenu(float growth, String name) {
        this.growth = growth;
        this.name = name;
    }
}

