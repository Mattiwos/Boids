package src;

import src.*;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.Graphics.*;
import java.awt.Color;

public class Sim extends Canvas {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
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
        handler.addObject(new Bird(100,100,100,1,1));
        handler.addObject(new Bird(100,100,100,-1,-1));
    }

    public void paint(Graphics g){

       
        run(g);
        g.dispose();

    }

    public void run(Graphics g){
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;//nano seconds in ticks
        //
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;

        while(running)
        {
            long now = System.nanoTime(); //gets current nanoseconds passed
            delta += (now - lastTime) / ns;// current time - previous then divided by  nsper tecks
            lastTime = now;
            while(delta >=1)
            {
                tick(g);
                delta--;
            }
            if(running)
                render(g);
            frames++;

            if(System.currentTimeMillis() - timer > 1000)
            {
                timer += 1000;
                //System.out.println("FPS: "+ frames);
                frames = 0;
            }
        }

        // System.out.println("Loop");


        
        
        // int init = (int)System.currentTimeMillis() / 1000;
        // int timepassed = (int)System.currentTimeMillis() / 1000 - init;
        // int prevtimepassed =0;
        // while (running == true){
            
        //     int start = (int)System.currentTimeMillis() / 1000 - init;
            
        //      while ( (timepassed - prevtimepassed) >= 1){
        //         prevtimepassed = timepassed;
        //         render(g);

        //         x+= 1;
        //         System.out.println(x);
              
        //         timepassed=0;
        //         tick(g);

        //     }
        //     timepassed = Math.abs(timepassed - start);
        //     render(g);
        
        // if (running == false)
        //     break;
        // }
  
    }

    public void tick(Graphics g){
        
        handler.tick();
        

    }
    public void render(Graphics g){
        g.setColor(Color.white);
        g.fillRect(0,0,400,400);
        handler.render(g);
        
        
       
      

        
       
    }




}