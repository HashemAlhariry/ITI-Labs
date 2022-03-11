package gov.iti.jets;

import javax.swing.*;
import java.awt.event.*;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.concurrent.locks.Lock;

public class GUIIPFinder extends JFrame implements ActionListener {

    private JButton button;
    private JTextField textArea;
    private JLabel textLabel;

    String urlToSearch;
    String ipForSearchedURL;
    Thread th;
    boolean clicked = false;
    public Lock lock;

    GUIIPFinder(String title) {

        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setTitle(title);
        textLabel = new JLabel("Enter URL: ");
        button = new JButton("Find IP");
        textArea = new JTextField(20);

        button.addActionListener(this);

        button.setBounds(275, 165, 100, 30);
        textArea.setBounds(240, 110, 175, 30);
        textLabel.setBounds(140, 110, 75, 30);

        add(button);
        add(textArea);
        add(textLabel);

    }

    public static void main(String[] args) {

        GUIIPFinder guiipFinder = new GUIIPFinder("IP Finder Tool - Event Handling Demo");
        guiipFinder.setBounds(600, 250, 600, 400);
        guiipFinder.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        new Thread(() -> {
            urlToSearch = textArea.getText();
            if (urlToSearch != null) {
                // send to get the ip for that url
                try {

                    URI uri = new URI(urlToSearch);
                    if (!clicked)
                        if (uri.getHost() == null) {
                            InetAddress ip = InetAddress.getByName(urlToSearch);
                            ipForSearchedURL = ip.getHostAddress();
                            System.out.println(ipForSearchedURL);
                            JOptionPane.showMessageDialog(this,
                                    "URL: " + urlToSearch + "\n" + "IP: " + ipForSearchedURL);

                        } else {
                            System.out.println(uri.getHost());
                            InetAddress ip = InetAddress.getByName(uri.getHost());
                            ipForSearchedURL = ip.getHostAddress();
                            System.out.println(ipForSearchedURL);
                            JOptionPane.showMessageDialog(this,
                                    "URL: " + urlToSearch + "\n" + "IP: " + ipForSearchedURL);
                        }

                } catch (UnknownHostException e1) {
                    JOptionPane.showMessageDialog(this, "please enter valid host name", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } catch (URISyntaxException e1) {
                    JOptionPane.showMessageDialog(this, "please enter valid host name", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }

            }
        }).start();

    }

}
