package com.company;

import javax.swing.*;
import java.awt.event.*;

public class BoardButtonController implements ActionListener
{
  private JAN model;        //The Model used for the Program
  private JToggleButton[][] bButton = new JToggleButton[8][8];
  
  
  public BoardButtonController(JToggleButton[][] buttons, JAN aModel)
  {
    this.model = aModel;
    for(int row =0; row<bButton.length; row++)
    {
      for(int col =0; col<bButton[row].length; col++)
      {
        bButton[row][col] = buttons[row][col];
      }
    }

  }
  
  /** Guesses the selected letter
    * @param e      The event sent from the button that was clicked
    */ 
  public void actionPerformed(ActionEvent e)
  {
    System.out.println("detect");
    
    for(int row =0; row<bButton.length; row++)
    {
      for(int col =0; col<bButton[row].length; col++)
      {
        if(bButton[row][col].isSelected())
        {
          model.setCurrent(row,col);
          System.out.println("row = " + row + " col = " + col);
        }
      }
    }
  }
}