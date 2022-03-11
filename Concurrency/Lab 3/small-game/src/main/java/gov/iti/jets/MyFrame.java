package gov.iti.jets;
import java.awt.event.*;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.*;

public class MyFrame extends JFrame implements KeyListener, Runnable {

    ExecutorService executarService = Executors.newCachedThreadPool();
    Thread th1;
    Thread th2;
    Thread th3;
    Thread th4;

    JLabel label;
    ImageIcon icon;
    JLabel eLabel1;
    ImageIcon ene1;

    JLabel eLabel2;
    ImageIcon ene2;

    JLabel eLabel3;
    ImageIcon ene3;

    JLabel eLabel4;
    ImageIcon ene4;
    MyFrame() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLayout(null);
        this.addKeyListener(this);
        this.setBounds(500,150,500,500);

        icon = new ImageIcon("images/enemy1.png");
        ene1 = new ImageIcon("images/ball.png");
        ene2 = new ImageIcon("images/enemy2.png");
        ene3 = new ImageIcon("images/enemy3.png");
        ene4 = new ImageIcon("images/enemy4.png");

        eLabel1 = new JLabel();
        label = new JLabel();
        eLabel2 = new JLabel();
        eLabel3 = new JLabel();
        eLabel4 = new JLabel();

        label.setBounds(0, 0, 30, 30);
        eLabel1.setBounds(200, 100, 30, 30);
        eLabel2.setBounds(150, 50, 30, 30);
        eLabel3.setBounds(100, 100, 30, 30);
        eLabel4.setBounds(50, 100, 30, 30);

        label.setIcon(icon);
        eLabel1.setIcon(ene1);
        eLabel2.setIcon(ene2);
        eLabel3.setIcon(ene3);
        eLabel4.setIcon(ene4);

        this.add(label);
        this.add(eLabel1);
        this.add(eLabel2);
        this.add(eLabel3);
        this.add(eLabel4);

        this.setVisible(true);

        Random ran = new Random();
        // executarService.execute(this);
        //th1 = new Thread(() -> moveIconVertHorz(label, ran));
        //th2 = new Thread(() -> moveIconRandomally(eLabel3, ran));
        //th3 = new Thread(() -> moveIconRandomally(eLabel2, ran));
        //th4 = new Thread(() -> moveIconRandomally(eLabel4, ran));
        
        executarService.execute(() -> moveIconVertHorz(label, ran));
        executarService.execute(() -> moveIconRandomally(eLabel3, ran));
        executarService.execute(() -> moveIconRandomally(eLabel2, ran));
        executarService.execute(() -> moveIconRandomally(eLabel4, ran));
        //th1.start();
        //th2.start();
        //th3.start();
        //th4.start();

    }

    @Override
    public void run() {

        //Random ran = new Random();
        while (true) {

            // moveIconVertHorz(eLabel1,ran);
            // moveIconRandomally(eLabel3,ran);
            // moveIconRandomally(eLabel2,ran);

        }

    }

    private void moveIconVertHorz(JLabel label1, Random ran) {


            int width = 0;
            int height = 0;
        while (true) {
            System.out.println(label1.getWidth()+" "+label1.getHeight());
            if (label1.getLocation().getY() >= this.getHeight() - 60) {
                height = -1;
            }
            if (label1.getLocation().getY() <= 0) {
                height = 1;
            }
            if (label1.getLocation().getX() >= this.getWidth() - 30) {
                width = -1;
            }
            if (label1.getLocation().getX() <= 0) {
                width = 1;
            }

            label1.setLocation((int) label1.getLocation().getX() + width, (int) label1.getLocation().getY() + height);

            if( (label1.getX()-label1.getWidth()/2)   <=  eLabel1.getX()  && eLabel1.getX() <= (label1.getX()+label1.getWidth()/2)  &&   eLabel1.getY() <= (label1.getY()+label1.getHeight()/2)    &&     eLabel1.getY() >= (label1.getY()-label1.getHeight()/2) ){
                 break;
            }    
            try {
                Thread.sleep(10);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void moveIconRandomally(JLabel label1, Random ran) {

        boolean check =false;
        while (!check) {
            System.out.println(label1.getWidth()+" "+label1.getHeight());
            int randomNumber;
            randomNumber = ran.nextInt(4);
            if (randomNumber == 0) {
                if (label1.getX() == 0) {
                    while (label1.getX() < this.getWidth() - 40 && label1.getY() < this.getHeight() - 70) {

                        label1.setLocation(label1.getX() + 1, label1.getY() + 1);
                        if( (label1.getX()-label1.getWidth()/2)   <=  eLabel1.getX()  && eLabel1.getX() <= (label1.getX()+label1.getWidth()/2)  &&   eLabel1.getY() <= (label1.getY()+label1.getHeight()/2)    &&     eLabel1.getY() >= (label1.getY()-label1.getHeight()/2)  ){
                           check=true;
                           break;
                       }    
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } else if (label1.getX() <= this.getWidth() - 20) {

                    while (label1.getX() > 0) {
                        label1.setLocation(label1.getX() - 1, label1.getY());
                        if( (label1.getX()-label1.getWidth()/2)   <=  eLabel1.getX()  && eLabel1.getX() <= (label1.getX()+label1.getWidth()/2)  &&   eLabel1.getY() <= (label1.getY()+label1.getHeight()/2)    &&     eLabel1.getY() >= (label1.getY()-label1.getHeight()/2) ){
                            check=true;
                            break;
                       }    
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
            if (randomNumber == 1) {
                if (label1.getY() == 0) {
                    while (label1.getY() < this.getHeight() - 70) {
                        label1.setLocation(label1.getX(), label1.getY() + 1);
                        if((label1.getX()-label1.getWidth()/2)   <=  eLabel1.getX()  && eLabel1.getX() <= (label1.getX()+label1.getWidth()/2)  &&   eLabel1.getY() <= (label1.getY()+label1.getHeight()/2)    &&     eLabel1.getY() >= (label1.getY()-label1.getHeight()/2) ){
                            check=true;
                            break;
                       }    
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

                else if (label1.getY() <= this.getHeight()) {
                    while (label1.getY() > 0) {
                        label1.setLocation(label1.getX(), label1.getY() - 1);
                        if( (label1.getX()-label1.getWidth()/2)   <=  eLabel1.getX()  && eLabel1.getX() <= (label1.getX()+label1.getWidth()/2)  &&   eLabel1.getY() <= (label1.getY()+label1.getHeight()/2)    &&     eLabel1.getY() >= (label1.getY()-label1.getHeight()/2)  ){
                            check=true;
                            break;
                       }    
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
            if (randomNumber == 2) {
                if (label1.getX() < (this.getWidth() / 2) || label1.getY() < (this.getHeight() / 2)) {
                    while (label1.getX() < (this.getWidth() - 40) && label1.getY() < (this.getHeight() - 70)) {

                        label1.setLocation(label1.getX() + 1, label1.getY() + 1);

                        if((label1.getX()-label1.getWidth()/2)   <=  eLabel1.getX()  && eLabel1.getX() <= (label1.getX()+label1.getWidth()/2)  &&   eLabel1.getY() <= (label1.getY()+label1.getHeight()/2)    &&     eLabel1.getY() >= (label1.getY()-label1.getHeight()/2) ){
                            check=true;
                            break;
                       }    
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } else if (label1.getX() > (this.getWidth() / 2) && label1.getY() > (this.getHeight() / 2)) {
                    while (label1.getX() > 0 && label1.getY() > 0) {

                        label1.setLocation(label1.getX() - 1, label1.getY() - 1);
                        if( (label1.getX()-label1.getWidth()/2)   <=  eLabel1.getX()  && eLabel1.getX() <= (label1.getX()+label1.getWidth()/2)  &&   eLabel1.getY() <= (label1.getY()+label1.getHeight()/2)    &&     eLabel1.getY() >= (label1.getY()-label1.getHeight()/2)  ){
                            check=true;
                            break;
                       }    
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
            if (randomNumber == 3) {

                if (label1.getX() < (this.getWidth() / 2) || label1.getY() < (this.getHeight() / 2)) {

                    while (label1.getX() < (this.getWidth() - 40) && label1.getY() < (this.getHeight() - 70)) {

                        label1.setLocation(label1.getX() + 1, label1.getY() + 1);
                        if((label1.getX()-label1.getWidth()/2)   <=  eLabel1.getX()  && eLabel1.getX() <= (label1.getX()+label1.getWidth()/2)  &&   eLabel1.getY() <= (label1.getY()+label1.getHeight()/2)    &&     eLabel1.getY() >= (label1.getY()-label1.getHeight()/2) ){
                            check=true;
                            break;
                       }    
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } else if (label1.getX() > (this.getWidth() / 2) && label1.getY() > (this.getHeight() / 2)) {
                    while (label1.getX() > 0 && label1.getY() > 0) {

                        label1.setLocation(label1.getX() - 1, label1.getY() - 1);
                        if( (label1.getX()-label1.getWidth()/2)   <=  eLabel1.getX()  && eLabel1.getX() <= (label1.getX()+label1.getWidth()/2)  &&   eLabel1.getY() <= (label1.getY()+label1.getHeight()/2)    &&     eLabel1.getY() >= (label1.getY()-label1.getHeight()/2)  ){
                            check=true;
                            break;
                       }    
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

        switch (e.getKeyChar()) {
            case 'a':
                if (eLabel1.getX() != 0)
                eLabel1.setLocation(eLabel1.getX() - 10, eLabel1.getY());
                break;
            case 'd':
                if (eLabel1.getX() < this.getWidth() - 30) {
                    eLabel1.setLocation(eLabel1.getX() + 10, eLabel1.getY());
                }
                break;
            case 's':
                if (eLabel1.getY() < this.getHeight() - 70) {
                    eLabel1.setLocation(eLabel1.getX(), eLabel1.getY() + 10);
                }
                break;
            case 'w':
                if (eLabel1.getY() != 0)
                eLabel1.setLocation(eLabel1.getX(), eLabel1.getY() - 10);
                break;

        }

    }
    @Override
    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()) {
            case 37:
                if (eLabel1.getX() != 0)
                eLabel1.setLocation(eLabel1.getX() - 10, eLabel1.getY());
                break;
            case 39:
                if (eLabel1.getX() != this.getWidth() - ene1.getIconWidth())
                eLabel1.setLocation(eLabel1.getX() + 10, eLabel1.getY());
                break;
            case 40:
                if (eLabel1.getY() != this.getHeight() - ene1.getIconHeight())
                eLabel1.setLocation(eLabel1.getX(), eLabel1.getY() + 10);
                break;
            case 38:
                if (eLabel1.getY() != 0)
                eLabel1.setLocation(eLabel1.getX(), eLabel1.getY() - 10);
                break;

        }

    }
    @Override
    public void keyReleased(KeyEvent e) {
        // System.out.println("You Release key char: " + e.getKeyCode());
    }

}
