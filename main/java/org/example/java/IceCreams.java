package org.example.java;


public abstract class IceCreams {

protected String discription;
protected int amount;

    public IceCreams(String discription, int amount) {
        this.discription = discription;
        this.amount = amount;
    }


    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
class Vanalla extends IceCreams{

    public Vanalla() {
        super("Chillly Vanalla  iceCream", 4);
    }
}

class Chocolate extends IceCreams{

    public Chocolate() {
        super("Chocolate IceCream", 4);

    }
}
class ChocolateChips extends IceCreams{

    public ChocolateChips() {
        super("ChocolateChips  IceCream", 4);

    }
}
class Mango extends IceCreams{

    public Mango() {
        super("Mango  IceCream", 4);

    }
}
class Honey extends IceCreams{

    public Honey() {
        super("Honey  IceCream", 5);

    }
}