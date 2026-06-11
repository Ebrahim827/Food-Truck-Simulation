package org.example.java;

public class Cones extends IceCreams {
IceCreams iceCreams;
    public Cones(IceCreams iceCreams) {
        super(iceCreams.getDiscription(), iceCreams.getAmount());
        this.iceCreams = iceCreams;
    }
}
class WaffleCone extends Cones{
    public WaffleCone(IceCreams iceCreams) {
        super(iceCreams);
    }

    @Override
    public String getDiscription() {
        return "WaffleCone with an extra 2  " + super.getDiscription();
    }

    @Override
    public int getAmount() {
        return super.getAmount() + 2;
    }

}

class CakeCone extends Cones{
    public CakeCone(IceCreams iceCreams) {
        super(iceCreams);
    }

    @Override
    public String getDiscription() {
        return "CakeCone with an extra 3  " + super.getDiscription();
    }

    @Override
    public int getAmount() {
        return super.getAmount() + 3;
    }

}

class SimpleCone extends Cones{
    public SimpleCone(IceCreams iceCreams) {
        super(iceCreams);
    }

    @Override
    public String getDiscription() {
        return "SimpleCone with an extra 2  " + super.getDiscription();
    }

    @Override
    public int getAmount() {
        return super.getAmount() + 2;
    }

}

