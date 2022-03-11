package gov.iti.jets;
import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
public class TextBanner extends JFrame implements Runnable {
   
    
    JLabel label = new JLabel();
    ExecutorService executarService = Executors.newSingleThreadExecutor();
    
    public TextBanner() {

        this.setTitle("Text Bannaer");
        label.setHorizontalAlignment(JLabel.LEFT);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setText("JAVA World");
        this.add(label, BorderLayout.CENTER);
        executarService.execute(this);

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