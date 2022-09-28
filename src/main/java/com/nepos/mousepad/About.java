
package com.nepos.mousepad;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class About extends JFrame implements ActionListener {
    
    JButton b1;
    
    About(){
        setBounds(600,200,300,270);
        setLayout(null);
        
        setTitle("About The MousePad");
        
      /*  ImageIcon i1 = new ImageIcon(new URL("com/nepos/mousepad/icon/os.png"));
        Image i2 = i1.getImage().getScaledInstance(400, 80, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(150,40,400,80);
        l1.setIcon(i3);
        add(l1);
        
        
       /* ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("com/nepos/mousepad/icon/mouseicon.png"));
        Image i5 = i4.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel l2 = new JLabel(i6);
        l2.setBounds(50,180,70,70);
        l2.setIcon(i6);
       // add(l2);*/
        
        JLabel l3 = new JLabel("<html> Mousepad is a text editor developed by Mr. Manik Shrivastav as the practical of Class 11.<br> The Mousepad is a text editor made in Java Programming Language. It supports only .txt files for now.<br> It has been a good text editor for normal use of public.<br><br>By Mr. Manik Shrivastav</html>");
        l3.setBounds(50, 30,200 , 170);
        l3.setFont(new Font("SAN_SERIF",Font.PLAIN,12));
        add(l3);
        
        b1 = new JButton("Okay");
        b1.setBounds(580, 500, 80, 25);
        b1.addActionListener(this);
        add(b1);                   
    } 
    
    public void actionPerformed(ActionEvent ae){
        this.setVisible(false);
    }
    
    public static void main(String[] args){
    
        new About().setVisible(true);
    }
}
