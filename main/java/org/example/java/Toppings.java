package org.example.java;

public class Toppings extends IceCreams {
IceCreams iceCreams;
    public Toppings(IceCreams iceCreams){
        super(iceCreams.getDiscription() , iceCreams.getAmount());
        this.iceCreams = iceCreams;
    }
}
class ChocolateSause extends Toppings{

    public ChocolateSause(IceCreams iceCreams) {
        super(iceCreams);
    }

    @Override
    public String getDiscription() {
        return "Chocolated Sause" +  super.getDiscription();
    }

    @Override
    public int getAmount() {
        return super.getAmount() + 5;
    }
}

class StrawberrySause extends Toppings{

    public StrawberrySause(IceCreams iceCreams) {
        super(iceCreams);
    }

    @Override
    public String getDiscription() {
        return "Strawberry Sause" +  super.getDiscription();
    }

    @Override
    public int getAmount() {
        return super.getAmount() + 5;
    }
}
