package src;

import src.*;

import java.awt.Color;
import java.awt.*;
import java.lang.Object;


public class Bird extends GameObject {
   

    public Bird(double x, double y, double r, double velx, double vely){
        super(x,y,r);
        setVelY(vely);
        setVelX(velx);

    }
    public void render(Graphics g){
        g.setColor(Color.black);
        g.fillRect((int)getX(),(int)getY(),10,10);
        


    }
    public void tick(){
        System.out.println("Moved");

        setY(getY()+ getVelY());
        setX(getX()+getVelX());
        if (getY() >= 390 || getY() <= 0){
            setVelY(getVelY() *-1);

        }
        if (getX() >= 390 || getX() <= 0){
            setVelX(getVelX() *-1);

        }

    }


}