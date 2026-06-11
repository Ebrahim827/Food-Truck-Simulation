package org.example.java;

import java.util.HashMap;
import java.util.Map;

public class Truck {
    private float X;
    private float Y;
    private float amount;
    private String Name;

    public Truck(float x, float y, float amount, String name) {
        X = x;
        Y = y;
        this.amount = amount;
        Name = name;
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
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
class truckRegistry{
    public static final Map<String , Truck>trucks = new HashMap<>();

   static  void setTruck(String s , Truck t){
        trucks.put(s , t);
    }
   static Truck gettruck(String s){
       return trucks.get(s);
   }

}
class TruckNameidentifier{
    private static  String name;

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        TruckNameidentifier.name = name;
    }
}

