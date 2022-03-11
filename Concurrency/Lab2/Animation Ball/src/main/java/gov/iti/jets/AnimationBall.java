package gov.iti.jets;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AnimationBall extends JFrame implements Runnable {

    Thread th;
    JLabel label = new JLabel();
    JPanel panel = new JPanel();
    ImageIcon imageIcon = new ImageIcon("images/ball.png");
    private JButton pause;
    private JButton resume;
    private Boolean ballpaused=false;
    int x = 0;
    int y = 0;

    public AnimationBall() {    

        this.setTitle("Animation Ball");
        label.setIcon(imageIcon);
        label.setHorizontalAlignment(JLabel.LEFT);
        label.setVerticalAlignment(JLabel.TOP);
        pause=new JButton();
        pause.setText("Pause");
        resume=new JButton();
        resume.setText("Resume");
        panel.add(pause);
        pause.setBounds(100,30,100,30);
        panel.add(resume);
        resume.setBounds(300,30,100,30);
        pause.addActionListener(this::pauseButton);
        resume.addActionListener(this::resumeButton);
        panel.add(label);
        this.add(panel);
        th = new Thread(this);
        th.start();
        
    }
    private synchronized void pauseButton(ActionEvent e){

        System.out.println("pause");
        ballpaused=true;

    }
    private synchronized void resumeButton(ActionEvent e){
        System.out.println("resume");
        ballpaused=false;
        notify();
    }
 

 

    @Override
    public void run() {
        //Random ran = new Random();
        //int randomNumber;
        int width=0;
        int height=0;
        while (true) {
           // randomNumber=ran.nextInt(4);
            /*
            if(randomNumber==0){
                if(label.getX()==0){
                    while(label.getX()<this.getWidth()-40&&label.getY()<this.getHeight()-70){
                         
                        label.setLocation(label.getX()+1,label.getY()+1); 
                        try {
                           Thread.sleep(10);
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }  
                   }
                }
              else if(label.getX()<=this.getWidth() -20 ){
        
                    while(label.getX()>0){
                        label.setLocation(label.getX()-1,label.getY()); 
                        try {
                           Thread.sleep(10);
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }  
                   }
                }
                 
            }
            if(randomNumber==1){
                if(label.getY()==0){
                    while(label.getY()<this.getHeight()-70){
                        label.setLocation(label.getX(),label.getY()+1); 
                        try {
                           Thread.sleep(10);
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }  
                   }
                }
                
               else if(label.getY()<=this.getHeight()){
                    while(label.getY()>0){
                        label.setLocation(label.getX() ,label.getY()-1); 
                        try {
                           Thread.sleep(10);
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }  
                   }
                }
               
               
            }
            if(randomNumber==2){
                if(label.getX()<(this.getWidth()/2)||label.getY()<(this.getHeight()/2)){
                    while(label.getX()<(this.getWidth()-40)&&label.getY()<(this.getHeight()-70)){
        
                        label.setLocation(label.getX()+1,label.getY()+1); 
                        try {
                           Thread.sleep(10);
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }  
                   }
                }
               else if(label.getX()>(this.getWidth()/2)&&label.getY()>(this.getHeight()/2)){
                    while(label.getX()>0&&label.getY()>0){
                       
                        label.setLocation(label.getX()-1,label.getY()-1); 
                        try {
                           Thread.sleep(10);
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }  
                   }
                }
               
            }
            if(randomNumber==3){
             
                if(label.getX()<(this.getWidth()/2)||label.getY()<(this.getHeight()/2)){
                    
                    while(label.getX()<(this.getWidth()-40)&&label.getY()<(this.getHeight()-70)){
                    
                        label.setLocation(label.getX()+1,label.getY()+1); 
                        try {
                           Thread.sleep(10);
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }  
                   }
                }
               else if(label.getX()>(this.getWidth()/2)&&label.getY()>(this.getHeight()/2)){
                    while(label.getX()>0&&label.getY()>0){
                    
                        label.setLocation(label.getX()-1,label.getY()-1); 
                        try {
                           Thread.sleep(10);
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }  
                   }
                } 
            }
            */          
            
            if(ballpaused){
                synchronized (this){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            else if(!ballpaused){
                if(label.getLocation().getY() >= this.getHeight()-imageIcon.getIconHeight()-20)
                {
                    height=-1;
                }
                if(label.getLocation().getY()<= 0)
                {
                    height =1;
                }
                if(label.getLocation().getX() >= this.getWidth()-imageIcon.getIconWidth())
                {
                    width=-1;
                }
                if(label.getLocation().getX()<= 0)
                {
                    width =1;
                }

                label.setLocation((int)label.getLocation().getX()+width,(int)label.getLocation().getY()+height);

                try {
                    Thread.sleep(1);
                  
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }  
            }
            
        }

    }



}