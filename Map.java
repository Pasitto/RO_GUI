import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JFrame;
public class Map {

    public Map(Novice novice){

        JFrame window = new JFrame("Ragnarok Online");
        BorderLayout bg = new BorderLayout();

        // Left
        JPanel left = new JPanel();
        left.setLayout(new GridLayout(2,1,10,10));
        JPanel topl = new JPanel();
        topl.setLayout(new BoxLayout(topl, BoxLayout.Y_AXIS));
        JPanel topl1 = new JPanel();
        topl1.setLayout(new FlowLayout());
        JLabel lbtopl = new JLabel("STATUS");
        
        JPanel topl2 = new JPanel();
        topl2.setLayout(new BoxLayout(topl2, BoxLayout.Y_AXIS));
        // 6 item to show in topl2
        JLabel nvName = new JLabel("NAME: "+ novice.getName());
        JLabel nvHp = new JLabel("HP: "+novice.getHp());
        JLabel nvSp = new JLabel("SP: "+novice.getSp());
        JLabel nvLvl = new JLabel("LEVEL: "+novice.getLvl());
        JLabel nvZeny = new JLabel("Zeny(z.): "+novice.getZeny());
        JLabel nvKill = new JLabel("Kill: "+novice.getKill());

        topl2.add(nvName);
        topl2.add(nvHp);
        topl2.add(nvSp);
        topl2.add(nvLvl);
        topl2.add(nvZeny);
        topl2.add(nvKill);
        // add All top left
        topl1.add(lbtopl);
        topl.add(topl1);
        topl.add(topl2);

        JPanel botl = new JPanel();
        botl.setLayout(new BoxLayout(botl, BoxLayout.Y_AXIS));
        JPanel botl1 = new JPanel();
        botl1.setLayout(new FlowLayout());
        JLabel lbbotl = new JLabel("ITEM");
        JPanel botl2 = new JPanel();
        botl2.setLayout(new GridLayout(2,2,5,5));
        // 2 button to Menu bar
        ImageIcon it1icon = new ImageIcon("RedPotion.jpg");
        JButton it1 = new JButton(it1icon);
        ImageIcon it2icon = new ImageIcon("BluePotion.png");
        JButton it2 = new JButton(it2icon);
        
        botl2.add(it1);
        botl2.add(it2);

        //add All bot left
        botl.add(lbbotl);
        botl.add(botl1);
        botl.add(botl2);
        //add All left
        left.add(topl);
        left.add(botl);
        
        //---------Center---------
        JPanel cen = new JPanel();
        cen.setLayout(new BoxLayout(cen, BoxLayout.Y_AXIS));
        JPanel topcen = new JPanel();
        topcen.setLayout(new FlowLayout());
        JLabel lbtcen = new JLabel("YOUR CHARACTER");

        JPanel botcen = new JPanel();
        botcen.setLayout(new FlowLayout());
        ImageIcon charac = new ImageIcon("Novice.png");
        JLabel characimg = new JLabel(charac);
        
        topcen.add(lbtcen);
        cen.add(topcen);
        botcen.add(characimg);
        cen.add(botcen);

        //-----------Right----------
        JPanel right = new JPanel();
        right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
        JPanel topr = new JPanel();
        topr.setLayout(new FlowLayout());
        JLabel lbtopr = new JLabel("!!!ATTACK!!!");
        topr.add(lbtopr);

        JPanel botr = new JPanel();
        botr.setLayout(new BoxLayout(botr, BoxLayout.Y_AXIS));
        JPanel botr1 = new JPanel();
        botr1.setLayout(new FlowLayout());
        JLabel lbbotr = new JLabel("++MONTERS++");
        botr1.add(lbbotr);
        botr.add(botr1);
        
        JPanel botr2 = new JPanel();
        botr2.setLayout(new GridLayout(2,1,5,5));
        
        //Monters
        ImageIcon mt1icon = new ImageIcon("Smokie.png");
        JButton mt1 = new JButton(mt1icon);
        Smokie smokie = new Smokie();
        botr2.add(mt1);
        JPanel mtin = new JPanel();
        mtin.setLayout(new BoxLayout(mtin, BoxLayout.Y_AXIS));
        
        JLabel mtName = new JLabel("NAME: Smokie");
        JLabel mtHp = new JLabel("HP: "+smokie.getHp());
        mtin.add(mtName);
        mtin.add(mtHp);
        botr2.add(mtin);

        //add All Right
        botr.add(botr2);
        right.add(topr);
        right.add(botr);

        // Show
        window.setLayout(bg);
        window.add(left, BorderLayout.WEST);
        window.add(cen, BorderLayout.CENTER);
        window.add(right, BorderLayout.EAST);

        //-------------ACTION---------------
        it1.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                novice.hpUpdate(40);
                nvHp.setText("HP: "+novice.getHp());
            }
        });
        it2.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                novice.spUpdate(60);
                nvSp.setText("SP: "+novice.getSp());
            }
        });
        mt1.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                novice.hpUpdate(smokie.getAttack());
                nvHp.setText("HP: "+novice.getHp());
                smokie.HpUpdate(novice.getAttack());
                mtHp.setText("HP: "+smokie.getHp());

                if (smokie.getHp() <= 0){
                    novice.expUpdate(smokie.getExp());
                    novice.zenyUpdate(smokie.getZeny());
                    novice.killUp();
                    smokie.setHp();
                    mtHp.setText("HP: "+smokie.getHp());
                    if (novice.getExp() >= 100){
                        novice.expUpdate(0-(novice.getExp()));
                        novice.lvlUP();
                        nvLvl.setText("LEVEL: "+novice.getLvl());
                    }
                    nvZeny.setText("Zeny(z.): "+novice.getZeny());
                    nvKill.setText("Kill: "+novice.getKill());
                }

                if(novice.getHp() <= 0){
                    JOptionPane.showMessageDialog(null, "Your Die!!\n"+"Game will Ressurection Your Character:)"
                                                , "Sorry!", JOptionPane.ERROR_MESSAGE);
                    novice.hpUpdate(40);
                    nvHp.setText("HP: "+novice.getHp());                            
                }
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