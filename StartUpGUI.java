package com.company;

import javax.swing.*;
import java.awt.*;

public class StartUpGUI extends JPanel
{
  //private JAN model;
  ImageIcon image;
  
  public StartUpGUI()//JAN model)
  {
    super();
    //this.model = model;
    //this.setGUI = this;
    this.layoutView();
    //this.registerController();
  }
  
  protected void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    //image = new ImageIcon("images/startup.png");
    image = new ImageIcon("images/ChessWallPaper5.jpg");
    
    /*Graphics2D g2 = (Graphics2D)g;
    g2.scale(this.*/
      
    g.drawImage(image.getImage(), 0, 0, null);
  }
  
  private void layoutView()
  {
    JPanel botPanel = new JPanel(new FlowLayout());
    JButton startButton = new JButton("Click to Continue");
    startButton.setPreferredSize(new Dimension(300,60));
    
    botPanel.setOpaque(false);
    botPanel.add(startButton);                         
    this.setLayout(new BorderLayout());
    this.add(botPanel, BorderLayout.SOUTH);
  }
  
  private void registerController()
  {
    //ButtonsController = new ButtonsController(model);
    //this.startButton.addActionListener(ButtonsController);
  }
}