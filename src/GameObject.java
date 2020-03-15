package src;


import src.*;
import java.awt.*;

public abstract class GameObject{
    protected double x,y,r;
    protected double velX,velY,velR;
    public GameObject(double x, double y, double r){
        this.x =x;
        this.y = y;
        this.r = r;

    }
    public abstract void tick();
    public abstract void render(Graphics g);

    public double getX(){

        return this.x;
    }
    public double getY(){

        return this.y;
    }
    public double getR(){

        return this.r;
    }
    public void setX(double x){
        this.x = x;
    }
    public void setY(double y){
        this.y = y;
    }
    public void setR(double r){
        this.r = r;
    }
    public void setVelY(double velY){
        this.velY =velY;
    }
    public void setVelX(double velX){
        this.velX =velX;
    }
    public double getVelX(){
        return this.velX;
    }
    public double getVelY(){
        return this.velY;
    }



}