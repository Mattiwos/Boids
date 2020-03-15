package src;

import src.*;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.Graphics.*;


public class Sim extends Canvas {
    JFrame frame;
    int x = 0;
    boolean running = true;
    int width,height;
    Handler handler = new Handler();


    public Sim(){
        frame = new JFrame("Boids");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        
        frame.getContentPane().add(new Sim(400,400));

        frame.setVisible(true);

        


    }
    public Sim(int width, int height){
        this.width = width;
        this.height = height;
        handler.addObject(new Bird(100,100,100));
    }

    public void paint(Graphics g){

       
        run(g);
        g.dispose();

    }

    public void run(Graphics g){
        System.out.println("Loop");


        
        
        int init = (int)System.currentTimeMillis() / 1000;
        int timepassed = (int)System.currentTimeMillis() / 1000 - init;
        int prevtimepassed =0;
        while (running == true){
            
            int start = (int)System.currentTimeMillis() / 1000 - init;
            
             while ( (timepassed - prevtimepassed) >= 1){
                prevtimepassed = timepassed;
                render(g);

                x+= 1;
                System.out.println(x);
              
                timepassed=0;
                tick(g);

            }
            timepassed = Math.abs(timepassed - start);
            render(g);
        
        if (running == false)
            break;
        }
  
    }

    public void tick(Graphics g){
        
        handler.tick();
        

    }
    public void render(Graphics g){
        
        handler.render(g);
        
        
       
      

        
       
    }




}