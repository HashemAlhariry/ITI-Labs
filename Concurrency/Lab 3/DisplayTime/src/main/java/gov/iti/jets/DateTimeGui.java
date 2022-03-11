package gov.iti.jets;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class DateTimeGui extends JFrame implements Runnable {
 
    Date date = new Date();
    JLabel label = new JLabel();
    ExecutorService executarService = Executors.newSingleThreadExecutor();
    public DateTimeGui() {
        
        this.setTitle("Date & Time app");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setText(date.toString());
        this.add(label, BorderLayout.CENTER);
        executarService.execute(this);
    
    }

    @Override
    public void run() {
        while (true) {
            date = new Date();
            label.setText(date.toString());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}