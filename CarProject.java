/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carproject;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;


public class CarProject extends Applet implements Runnable,KeyListener
{

    
    Image yellow_car;
    Image red_car1,red_car2,red_car3,red_car4;
    Thread th;
    int score = 0;
    String go = "";
    //strip running code
    int strip1_x=575, strip1_y=100;
    int strip2_x=575, strip2_y=400;
    int strip3_x=575, strip3_y=700;
    int strip4_x=575, strip4_y=1000;
    
    
    //yellow car running code
    int yellow_car_x = 400;
    int yellow_car_y = 540;
    
    //red car running code
    int red_car1_x , red_car1_y = -100;
    int red_car2_x , red_car2_y = -400;
//    int red_car3_x , red_car3_y = -1700;
//    int red_car4_x , red_car4_y = -1700;
    
    
    public void start()
    {
        setSize(1200,900);
        setBackground(Color.green);
//        img = getImage(getDocumentBase(),"yellowcar.png");
        yellow_car =getImage(getDocumentBase(),"Yellow2Car.png");
        red_car1 = getImage(getDocumentBase(),"Red2Car.png");
        red_car2 = getImage(getDocumentBase(),"Red2Car.png");
//        red_car3 = getImage(getDocumentBase(),"Red2Car.png");
//        red_car4 = getImage(getDocumentBase(),"Red2Car.png");
        
        th = new Thread(this);
        th.start();
        
        red_car1_x = getRandomNo(300,700);
        red_car2_x = getRandomNo(300,700);
//        red_car3_x = getRandomNo(300,700);
//        red_car4_x = getRandomNo(300,700);
        
        addKeyListener(this);
    }
    
    public void paint(Graphics g)
    {
        g.fillRect(300,0,600,900);
        g.setColor(Color.white);
        g.fillRect(strip1_x,strip1_y,40,120);
        g.fillRect(strip2_x,strip2_y,40,120);
        g.fillRect(strip3_x,strip3_y,40,120);
        g.fillRect(strip4_x,strip4_y,40,120);
//      
        
        g.drawImage(yellow_car,yellow_car_x,yellow_car_y,this);
        g.drawImage(red_car1,red_car1_x,red_car1_y,this);
        g.drawImage(red_car2,red_car2_x,red_car2_y,this);
//        g.drawImage(red_car3,red_car3_x,red_car3_y,this);
//        g.drawImage(red_car4,red_car4_x,red_car4_y,this);
        
        
        g.setColor(Color.red);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawString("Score : "+score, 1000, 50);
        
        g.setColor(Color.blue);
        g.setFont(new Font("Arial", Font.BOLD, 100));
        g.drawString(go, 330, 500);
        
    }

    @Override
    public void run()
    {
        try
        {
            while(true)
            {
                if(strip4_y==1000)
                {
                    strip4_y=-200;
                }
                else if(strip3_y==1000)
                {
                    strip3_y = -200;
                }
                else if(strip2_y==1000)
                {
                    strip2_y = -200;
                }
                else if(strip1_y==1000)
                {
                    strip1_y = -200;
                }
                
                if(red_car1_y==900)
                {
                    red_car1_y = -100;
                    red_car1_x = getRandomNo(300,700);
                    score = score + 1;
//                    System.out.println(red_car1_x);
                }
                if(red_car2_y==900)
                {
                    red_car2_y = -100;
                    red_car2_x = getRandomNo(300,700);
                    score = score + 1;
//                    System.out.println(red_car1_x);
                }
//                if(red_car3_y==900)
//                {
//                    red_car3_y = -100;
//                    red_car3_x = getRandomNo(500,700);
////                    System.out.println(red_car1_x);
//                }
//                if(red_car4_y==900)
//                {
//                    red_car4_y = -100;
//                    red_car4_x = getRandomNo(300,700);
////                    System.out.println(red_car1_x);
//                }
                
                
                strip1_y = strip1_y+5;
                strip2_y = strip2_y+5;
                strip3_y = strip3_y+5;
                strip4_y = strip4_y+5;

                red_car1_y = red_car1_y + 5;
//                System.out.println(red_car1_y);
                red_car2_y = red_car2_y + 5;
//                red_car3_y = red_car3_y + 5;
//                red_car4_y = red_car4_y + 5;
                
                boolean cond_1 = yellow_car_x+55>=red_car1_x && yellow_car_x<=red_car1_x+60 && red_car1_y>400;
                boolean cond_2 = yellow_car_x+55>=red_car2_x && yellow_car_x<=red_car2_x+60 && red_car2_y>400;
                if(cond_1||cond_2)
                {
                    go = "Game Over";
                    repaint();
                    th.stop();
                }
                repaint();
                Thread.sleep(80);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) 
    {
        if(e.getKeyCode()==KeyEvent.VK_RIGHT)
        {
            if(yellow_car_x==795)
            {
                yellow_car_x=795;
            }
            else
            {
                yellow_car_x = yellow_car_x + 5;
                repaint();
            }
        }
        
        if(e.getKeyCode()==KeyEvent.VK_LEFT)
        {
            if(yellow_car_x==260)
            {
                yellow_car_x=260;
            }
            else
            {
                yellow_car_x = yellow_car_x - 5;
//                System.out.println(yellow_car_x);
                repaint();
            }
        }
        
        if(e.getKeyCode()==KeyEvent.VK_UP)
        {
            if(yellow_car_y==20)
            {
                yellow_car_y=20;
            }
            else
            {
                yellow_car_y = yellow_car_y - 5;
//                System.out.println(yellow_car_y);
                repaint();
                
            }
        }
        
        if(e.getKeyCode()==KeyEvent.VK_DOWN)
        {
            if(yellow_car_y==545)
            {
                yellow_car_y=545;
            }
            else
            {
                yellow_car_y = yellow_car_y + 5;
//                System.out.println(yellow_car_y);
                repaint();
            }
        }
        
    }
        
    @Override
    public void keyReleased(KeyEvent e) {}
    
    int getRandomNo(int low, int high)
    {
        Random r=new Random();
        int result = r.nextInt(high-low) + low;
        return result;
    }
    
}
