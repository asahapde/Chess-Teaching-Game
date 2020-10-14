package com.company;

import javax.swing.*;
import java.awt.event.*;

public class MainMenuController implements ActionListener
{
  private JAN model;        //The Model used for the Program
  private JButton bButton;
  private JButton pButton;
  private JButton wCButton;
  private JButton sCButton;
  private JButton puzButton;
  private JButton fPButton;
  private JButton eButton;
  
  
  public MainMenuController(JAN aModel, JButton board, JButton pieces, JButton winCondition, JButton specialCondition,
                            JButton puzzle, JButton freePlay, JButton exit)
  {
    this.model = aModel;
    this.bButton = board;
    this.pButton = pieces;
    this.wCButton = winCondition;
    this.sCButton = specialCondition;
    this.puzButton = puzzle;
    this.fPButton = freePlay;
    this.eButton = exit;
  }
  
  /** Guesses the selected letter
    * @param e      The event sent from the button that was clicked
    */ 
  public void actionPerformed(ActionEvent e)
  {
    if(e.getSource() == this.bButton)
    {
      //model.changePanel("BoardGUI");
    }
    else if(e.getSource() == this.pButton)
    {
      //model.changePanel("PiecesGUI");
    }
    else if(e.getSource() == this.wCButton)
      model.changePanel("WinConditionGUI1");
    else if(e.getSource() == this.sCButton)
      model.changePanel("SpecialConditionGUI1");
    else if(e.getSource() == this.puzButton)
      model.changePanel("Puzzle");
    else if(e.getSource() == this.fPButton)
      model.changePanel("FreePlayModeGUI");
    else if(e.getSource() == this.eButton)
      System.exit(0);
      
  }
}