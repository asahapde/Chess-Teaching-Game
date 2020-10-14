package com.company;

import javax.swing.*;
import java.awt.event.*;

public class BackButtonController implements ActionListener
{
  private JAN model;        //The Model used for the Program
  private JButton bButton;
  
  
  public BackButtonController(JButton back, JAN aModel)
  {
    this.model = aModel;
    this.bButton = back;
  }
  
  /** Guesses the selected letter
    * @param e      The event sent from the button that was clicked
    */ 
  public void actionPerformed(ActionEvent e)
  {
    if(e.getSource() == this.bButton)
    {
      model.changePanel("MainMenu");
    }
      
  }
}