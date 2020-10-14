package com.company;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**  StarWarsName Program
  *    A Program that allows users to learn about the game of Chess
  *    Last Modified: 02/05/2018
  *    @author S.Abdullah
  */ 
public class JANChessTutorial
{
  private static JAN model = new JAN(); //The Model
  private static JANGUI view = new JANGUI(model); //The GUI
  
  public static void main (String [] args)
  {

    //Initialize the Frame
    JFrame f = new JFrame("JAN Chess Tutorial");
    f.setContentPane(view);
    //f.pack();
    f.setSize(1200,600);
    f.setLocation(35,50);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setExtendedState(JFrame.MAXIMIZED_BOTH);
    f.setResizable(true);
    f.setVisible(true);
    
    f.getContentPane().addComponentListener(new ComponentAdapter()
    {
      public void componentResized(ComponentEvent e)
      {
        Component c = (Component)e.getSource();
        if (c.getWidth()>0 || c.getHeight()>0)
        {
          view.resized = true;
          view.update();
        }
      }
    });
  }
  
}