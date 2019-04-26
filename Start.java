import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JFrame;

public class Start {
    public static void main(String[] args) {
        JFrame window = new JFrame("Ragnarok Online");
        BorderLayout bg = new BorderLayout();
        
        // Create Icon
        ImageIcon logo = new ImageIcon("Logo.png");
        ImageIcon srMale = new ImageIcon("SuraIconMale.png");
        ImageIcon srFemale = new ImageIcon("SuraIconFemale.png");
        JLabel logoimg = new JLabel(logo);
        JLabel maleimg = new JLabel(srMale);
        JLabel femaleimg = new JLabel(srFemale);
        JPanel centop = new JPanel();
        centop.setLayout(new BoxLayout(centop, BoxLayout.Y_AXIS));

        //create textfield and bt
        JPanel cenmid = new JPanel();
        cenmid.setLayout(new GridLayout(8, 1, 10, 10));

        JPanel m1 = new JPanel(new FlowLayout());
        JLabel lb1 = new JLabel("Enter Character's Name");
        m1.add(lb1);
        
        JTextField namein = new JTextField();
        namein.setHorizontalAlignment(JTextField.CENTER);
        JButton startb = new JButton("START");

        //add All
        window.setLayout(bg);
        centop.add(logoimg);
        cenmid.add(m1);
        cenmid.add(namein);
        cenmid.add(startb);
        centop.add(cenmid);
        window.add(centop, BorderLayout.CENTER);
        window.add(maleimg, BorderLayout.WEST);
        window.add(femaleimg, BorderLayout.EAST);
        
        //Action
        startb.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                new Map(new Novice(namein.getText()));
            }
        });

        // set window
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close button
        window.setSize(800, 600); //resolution window size(px) 
        window.setLocationRelativeTo(null); //set to show in center on windows
        window.setResizable(false); //fix window size user not change
        window.setVisible(true); //set to show frame
    }
}