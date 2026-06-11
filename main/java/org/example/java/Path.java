package org.example.java;

import java.io.Serializable;
import java.util.ArrayList;

public class Path implements Serializable{
    private float X;
    private float Y;
    private float Amount;
    private String location;



    public Path(float x, float y, float amount, String location) {
        X = x;
        Y = y;
        Amount = amount;
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public float getX() {
        return X;
    }

    public void setX(float x) {
        X = x;
    }

    public float getY() {
        return Y;
    }

    public void setY(float y) {
        Y = y;
    }

    public float getAmount() {
        return Amount;
    }

    public void setAmount(float amount) {
        Amount = amount;
    }
}

abstract  class PathManager implements Serializable  {
    ArrayList<Path> paths;
    private float totalAmount = 0;
    private String info;

    public float totalCalculate(){
        for(Path p : paths){
           totalAmount += p.getAmount();
        }
        return totalAmount;
    }

    public PathManager(ArrayList<org.example.java.Path> paths, float totalAmount, String info) {
        this.paths = paths;
        this.totalAmount = totalAmount;
        this.info = info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public ArrayList<Path> getPaths() {
        return paths;
    }

    public void setPaths(ArrayList<Path> paths) {
        this.paths = paths;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }


    protected   static String infoGatherer(ArrayList<Path> p){
        String info =  "THE UrbanPath transverses from ";

        for (Path name : p) {
            info = info.concat(name.getLocation() + " ->");
        }
        info = info.concat("finish" );

        return info ;
    }

}

class RosePath extends PathManager implements  Serializable {

    public RosePath() {
        this(myPath());

    }
    private RosePath(ArrayList<Path>paths){
        super(paths , 0  , infoGatherer(paths));
    }

    private  static  ArrayList<Path> myPath(){
        ArrayList<Path> paths = new ArrayList<>();

        paths.add(new Path(100 , 0 ,0 , "node1"));
        paths.add(new Path(00 , 100 ,0 ,"node2"));
        paths.add(new Path(50 , 100 ,0,"node3"));
        paths.add(new Path(50 , 200 ,0, "node4"));
        paths.add(new Path(70 ,100  ,0 , "node5"));
        paths.add(new Path(20 , 300 ,0 , "node6"));
        paths.add(new Path(50 , 50 ,0 , "node7"));
        return paths;
    }


}


class UrbanPath extends PathManager implements  Serializable {

    public UrbanPath() {
        this(myPath());
        ;
    }
    private  UrbanPath(ArrayList<Path>paths){
        super(paths, 0, infoGatherer(paths));
    }

    private static ArrayList<Path> myPath(){
        ArrayList<Path>paths = new ArrayList<>();
        paths.add(new Path(2 , 100 ,0 , "node1"));
        paths.add(new Path(23 , 123 ,0 ,"node2"));
        paths.add(new Path(6 , 512 ,0,"node3"));
        paths.add(new Path(200 , 23 ,0, "node4"));
        paths.add(new Path(74 ,104  ,0 , "node5"));
        paths.add(new Path(200 , 3 ,0 , "node6"));
        paths.add(new Path(5 , 7 ,0 , "node7"));
        return paths;

    }







}