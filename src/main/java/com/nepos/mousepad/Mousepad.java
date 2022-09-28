

package com.nepos.mousepad;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.filechooser.FileNameExtensionFilter;


public class Mousepad extends JFrame implements ActionListener {
    
    JTextArea textarea;
    JScrollPane pane;
    String text;
    
            Mousepad(){
            
            
                setBounds(0,0,1920,1080);
                
               
                

                // Icon
              /*  ImageIcon img_icon = new ImageIcon("com/nepos/mousepad/icon/mouseicon.png");
               // Image imgIconImage = img_icon.getImage();
                JFrame.setIcon(img_icon);
                //ImageIcon imageIcon = new ImageIcon();*/

                //Title
                setTitle("MousePad");
                
                
                
                
                //MenuBar
                JMenuBar menubar = new JMenuBar();
                
                //File Menu
                JMenu file = new JMenu("File");
                
                JMenuItem newdoc = new JMenuItem("New");
                newdoc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
                newdoc.addActionListener(this);
                
                JMenuItem open = new JMenuItem("Open");
                open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
                open.addActionListener(this);
                
                JMenuItem save = new JMenuItem("Save");
                save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
                save.addActionListener(this);
                
                JMenuItem print = new JMenuItem("Print");
                print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
                print.addActionListener(this);
                
                JMenuItem exit = new JMenuItem("Exit");
                exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE,0));
                exit.addActionListener(this);
                
               //Adding MenuItems to Menu
                file.add(newdoc);
                file.add(open);
                file.add(save);
                file.add(print);
                file.add(exit);
                               
                
                           
                //Edit Menu
                JMenu edit = new JMenu("Edit");
                
                JMenuItem copy = new JMenuItem("Copy");
                copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
                copy.addActionListener(this);
                
                JMenuItem cut = new JMenuItem("Cut");
                cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
                cut.addActionListener(this);
                
                JMenuItem paste = new JMenuItem("Paste");
                paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,ActionEvent.CTRL_MASK));
                paste.addActionListener(this);
                
                JMenuItem select_all = new JMenuItem("Select All");
                select_all.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
                select_all.addActionListener(this);  
                
                
                //Edit menuItems
                edit.add(copy);
                edit.add(cut);
                edit.add(paste);
                edit.add(select_all);
                
                
                
                //Help Menu
                JMenu help = new JMenu("Help");
                
                JMenuItem about = new JMenuItem("About The MousePad");
                about.addActionListener(this);
                 
                 //Adding help menu Item
                 help.add(about);
              
                 
                //Adding menu to menu bar
                menubar.add(file);
                menubar.add(edit);
                menubar.add(help);
                
                setJMenuBar(menubar);
                
                
                textarea = new JTextArea();
                textarea.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
                textarea.setLineWrap(true);
                textarea.setWrapStyleWord(true);
                
                pane = new JScrollPane(textarea);
                pane.setBorder(BorderFactory.createEmptyBorder());
                add(pane,BorderLayout.CENTER);
                
            }

            
            public void actionPerformed(ActionEvent ae){
            
                if (ae.getActionCommand().equals("New")){
                    textarea.setText("");
                }else if (ae.getActionCommand().equals("Open")){
                    
                    JFileChooser chooser = new JFileChooser();
                    chooser.setAcceptAllFileFilterUsed(false);
                    FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only .txt files","txt");
                    chooser.addChoosableFileFilter(restrict);
                    
                    int action = chooser.showOpenDialog(this);
                    if(action != JFileChooser.APPROVE_OPTION){
                            return;
                    }
                    
                    File file = chooser.getSelectedFile();
                    
                    try{
                        BufferedReader reader = new BufferedReader(new FileReader(file));
                        textarea.read(reader, null);
                    }catch(Exception e){}
                
                    
                }else if (ae.getActionCommand().equals("Save")){
                
                    JFileChooser saveas = new JFileChooser();
                    saveas.setApproveButtonText("Save");
                    int action = saveas.showOpenDialog(this);
                    if(action != JFileChooser.APPROVE_OPTION){
                            return;
                    }
                    
                    File filename = new File(saveas.getSelectedFile()+".txt");
                    BufferedWriter outfile = null;
                    
                    try{
                        outfile = new BufferedWriter(new FileWriter(filename));
                        textarea.write(outfile);
                         
                    }catch(Exception e){
                    }
                    
                    
                }
                
                else if (ae.getActionCommand().equals("Print")){
                    try{
                     textarea.print();
                    }catch(Exception e){}
                    
                       }
                else if (ae.getActionCommand().equals("Exit")){
                    System.exit(0);
                }
                else if (ae.getActionCommand().equals("Copy")){
                    text = textarea.getSelectedText();
                }
                else if (ae.getActionCommand().equals("Paste")){
                    textarea.insert(text, textarea.getCaretPosition());
                }
                else if (ae.getActionCommand().equals("Cut")){
                    text = textarea.getSelectedText();
                    textarea.replaceRange("", textarea.getSelectionStart(), textarea.getSelectionEnd());
                } else if (ae.getActionCommand().equals("Select All")){
                 textarea.selectAll();
                }else if (ae.getActionCommand().equals("About The MousePad")){
                 new About().setVisible(true);
                }
                
            }
            
            public static void main(String[] args) {
                     
                new Mousepad().setVisible(true);
         
    }


}
