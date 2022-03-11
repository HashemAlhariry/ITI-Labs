package gov.iti.jets;
import javax.swing.*;
import java.awt.*;

public class TextBanner extends JFrame implements Runnable {
   
    Thread th;
    JLabel label = new JLabel();

    public TextBanner() {

        this.setTitle("Text Bannaer");
        label.setHorizontalAlignment(JLabel.LEFT);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setText("JAVA World");
        this.add(label, BorderLayout.CENTER);
        th = new Thread(this);
        th.start();

    }

    @Override
    public void run() {
        while (true) {
      
     
            if (label.getLocation().getX() >= this.getWidth()-20) {
                label.setLocation(-60, (int) label.getLocation().getY());
            } else {
                label.setLocation((int) label.getLocation().getX() + 1, (int) label.getLocation().getY());
            }
           
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}