package com.company;

import javax.swing.*;
import java.awt.*;

public class Puzzle extends JPanel
{
  private JAN model;
  private ChessBoard board;
  private JPanel panel = new JPanel();
  private JPanel centerPanel = new JPanel();
  private JPanel botPanel = new JPanel();
  private JLabel title = new JLabel("Puzzle - 1");
  private JLabel description = new JLabel("Descritption\n bla\n bla");
  private JLabel turnsLabel = new JLabel("Turns left: 10");
  private JButton retryButton = new JButton("Retry");
  private JButton mainMenuButton = new JButton("Main Menu");
  
  private int turnsLeft = 0;
  
  public Puzzle(JAN model)
  {
    super();
    this.model = model;
    board = new ChessBoard(this.model);
    //this.setGUI = this;
    this.layoutView();
    //this.registerController();
  }
  
  private void layoutView()
  { 
    this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
    //title.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    description.setBorder(BorderFactory.createLineBorder(Color.RED));
    
    
    panel.setLayout(new BorderLayout());
    panel.setMinimumSize(new Dimension(500,800));
    panel.setBackground(new Color(185,156,107));
    
    title.setPreferredSize(new Dimension(300,70));
    title.setHorizontalAlignment(JLabel.CENTER);
    description.setPreferredSize(new Dimension(450,600));
    turnsLabel.setPreferredSize(new Dimension(300,20));
    turnsLabel.setHorizontalAlignment(JLabel.CENTER);
    turnsLabel.setOpaque(true);
    retryButton.setPreferredSize(new Dimension(100,40));
    
    centerPanel.setLayout(new BorderLayout());
    centerPanel.add(description, BorderLayout.NORTH);
    centerPanel.add(turnsLabel, BorderLayout.CENTER);
    centerPanel.setBackground(new Color(213,196,161));
    
    botPanel.setLayout(new GridLayout(2,5,10,10));
    botPanel.setBackground(new Color(185,156,107));
    botPanel.add(new JLabel(""));
    botPanel.add(new JLabel(""));
    botPanel.add(retryButton);
    botPanel.add(new JLabel(""));
    botPanel.add(new JLabel(""));
    botPanel.add(new JLabel(""));
    botPanel.add(new JLabel(""));
    botPanel.add(mainMenuButton);
    botPanel.add(new JLabel(""));
    botPanel.add(new JLabel(""));
    
    panel.add(title, BorderLayout.NORTH);
    panel.add(centerPanel, BorderLayout.CENTER);
    panel.add(botPanel, BorderLayout.SOUTH);
    this.add(board);
    this.add(panel);

    
  }
  
}