package com.company;

import javax.swing.*;
import java.awt.event.*;

public class SpecialConditionButtonController implements ActionListener
{
  private JAN model;        //The Model used for the Program
  private JButton pButton;
  private JButton nButton;
  
  
  public SpecialConditionButtonController(JButton prev, JButton next, JAN aModel)
  {
    this.model = aModel;
    this.pButton = prev;
    this.nButton = next;
  }
  
  /** Guesses the selected letter
    * @param e      The event sent from the button that was clicked
    */ 
  public void actionPerformed(ActionEvent e)
  {
    if(e.getSource() == this.pButton)
    {
      model.switchScPanel("prev");
    }
    else if(e.getSource() == this.nButton)
    {
      model.switchScPanel("next");
    }
      
  }
}