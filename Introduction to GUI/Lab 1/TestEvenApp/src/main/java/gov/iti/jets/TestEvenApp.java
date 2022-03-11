package gov.iti.jets;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TestEvenApp  extends JFrame 
{

    JLabel textLabel = new JLabel("Do event using mouse to see handling ");
    JLabel handleLabel = new JLabel("---------------");

    TestEvenApp(String title){
        super(title);
        this.setLayout(new FlowLayout());
        this.add(textLabel);
        this.add(handleLabel);
        textLabel.setOpaque(true);
        handleLabel.setOpaque(true);
        textLabel.setFont(new Font("MonoSpaced",Font.BOLD,20));
        handleLabel.setFont(new Font("MonoSpaced",Font.BOLD,20));
        textLabel.setBackground(Color.pink);
        handleLabel.setBackground(Color.LIGHT_GRAY);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.addMouseListener(new MyMouseListener());
        this.addMouseMotionListener(new MyMouseMotionListener());
    
    }


    public static void main( String[] args )
    {
        TestEvenApp app = new TestEvenApp("Event Handling Examples");
        app.setSize(600,600);
        app.setVisible(true);
       
    }

    class MyMouseListener implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
    
                handleLabel.setForeground(Color.yellow);
                handleLabel.setText("Mouse is clicked");
            
        }

        @Override
        public void mousePressed(MouseEvent e) {
            handleLabel.setForeground(Color.blue);
            handleLabel.setText("Mouse is pressed");            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
          
            handleLabel.setForeground(Color.red);
            handleLabel.setText("Mouse is released");
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {

            handleLabel.setForeground(Color.GRAY);
            handleLabel.setText("Mouse is entered");            
        }

        @Override
        public void mouseExited(MouseEvent e) {
          
            handleLabel.setForeground(Color.magenta);
            handleLabel.setText("Mouse is exited");
            
        }
        
    }

    class MyMouseMotionListener implements MouseMotionListener{

        @Override
        public void mouseDragged(MouseEvent e) {
            handleLabel.setForeground(new Color(0.0f,1.0f,1.0f));
            handleLabel.setText("Mouse is moving");
            
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            handleLabel.setForeground(Color.ORANGE);
            handleLabel.setText("Mouse is dragged");
            
        }

        
    }
    
}
 