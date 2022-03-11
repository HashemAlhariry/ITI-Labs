package gov.iti.jets;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class DateTimeGui extends JFrame implements Runnable {
    Thread th;
    Date date = new Date();
    JLabel label = new JLabel();

    public DateTimeGui() {
        this.setTitle("Date & Time app");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setText(date.toString());
        this.add(label, BorderLayout.CENTER);
        th = new Thread(this);
        th.start();
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