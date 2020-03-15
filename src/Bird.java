package src;
import src.*;

import java.awt.Color;
import java.awt.*;
import java.lang.Object;


public class Bird extends GameObject {
   

    public Bird(double x, double y, double r){
        super(x,y,r);
        setVelY(10);
        setVelX(10);

    }
    public void render(Graphics g){
        g.setColor(Color.white);
        g.fillRect((int)getX(),(int)getY(),10,10);
        g.drawRect((int)getX(),(int)getY(),100,100);


    }
    public void tick(){
        System.out.println("Moved");

        setY(getY()+ getVelY());
        setX(getX()+getVelX());


    }


}