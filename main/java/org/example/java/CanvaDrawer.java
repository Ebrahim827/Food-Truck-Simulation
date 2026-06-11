package org.example.java;

import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class CanvaDrawer implements Runnable{

    Color color;

    final float[] nodeTracker = new float[4];
    Truck trucks ;
    PathManager pathManagers;
    GraphicsContext gc = null;
    Text tk;

    public CanvaDrawer(Truck trucks, PathManager pathManagers , GraphicsContext gc , Color color , Text text) {
        this.trucks = trucks;
        this.pathManagers = pathManagers;
        this.gc = gc;
        this.color = color;
        this.tk = text;
    }



    @Override
    public void run() {

        nodeTracker[0] = trucks.getX();
        nodeTracker[1] = trucks.getY();
        for(int i = 0 ; i< pathManagers.getPaths().size() ;i++){



            float parameterT = 0;

            for(int j = 0 ; j < 1000 ; j++){
                nodeTracker[2] = nodeTracker[0] + parameterT * ( pathManagers.getPaths().get(i).getX() - nodeTracker[0]) ;
                nodeTracker[3] = nodeTracker[1] + parameterT * ( pathManagers.getPaths().get(i).getY() - nodeTracker[1]) ;
                parameterT += 0.001f;
                final double x1 = nodeTracker[0];
                final double y1 = nodeTracker[1];
                final double x2 = nodeTracker[2];
                final double y2 = nodeTracker[3];
                Platform.runLater(()->{
                    if(gc != null){

                        gc.save();
                        gc.setStroke(this.color);
                        gc.setLineWidth(10);
                        gc.strokeLine( x1 ,  y1 ,  x2 ,  y2 );
                        gc.restore();

                    }
                });
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }


            }
            pathManagers.getPaths().get(i).setAmount(pathManagers.getPaths().get(i).getAmount()+trucks.getAmount());
            pathManagers.setTotalAmount(pathManagers.getTotalAmount() + trucks.getAmount());
            trucks.setAmount(0);

          nodeTracker[0] =  pathManagers.getPaths().get(i).getX();
            nodeTracker[1] =  pathManagers.getPaths().get(i).getY();
        }
        Platform.runLater(()->{
            FlowershopMenu.slowText(trucks.getName() + " has completed its journey " , 10 ,tk);

        });
    }
}
