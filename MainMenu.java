package com.company;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JPanel
{ 
  private JANGUI view;
  
  private JButton boardButton = new JButton(new ImageIcon("images/MainMenuButtons/chessboard3.png"));
  private JButton piecesButton = new JButton(new ImageIcon("images/MainMenuButtons/piece3.png"));;
  private JButton winConditionButton = new JButton(new ImageIcon("images/MainMenuButtons/WinCondition2.png"));
  private JButton specialConditionButton = new JButton(new ImageIcon("images/MainMenuButtons/SpecialCondition2.png"));
  private JButton puzzleButton = new JButton(new ImageIcon("images/MainMenuButtons/puzzle2.png"));
  private JButton freePlayButton = new JButton(new ImageIcon("images/MainMenuButtons/FreePlayMode2.png"));
  private JButton exitButton = new JButton(new ImageIcon(getClass().getResource("images/MainMenuButtons/exit2.png")));
  
  
  private GridBagConstraints gbc = new GridBagConstraints();
  
  
  public MainMenu(JANGUI aView)
  {
    super();
    this.view = aView;
    this.makeLayout();
    this.registerControllers();
    this.update();
  }
  
  public void makeLayout()
  {
    
    this.setBackground(new Color(247,225,183));

    this.setPreferredSize(new Dimension(500,500));
    this.setLayout(new GridBagLayout());
    
    gbc.weightx = 1.0;
    gbc.weighty = 1.0;
    
   
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.gridwidth = 2;
    gbc.fill = GridBagConstraints.BOTH;
    gbc.insets = new Insets(50, 25, 5, 5);
    boardButton.setMaximumSize(new Dimension(100, 200));
    boardButton.setMinimumSize(new Dimension(600, 120));
    this.add(boardButton, gbc);
    gbc.gridwidth = 1;
    
    gbc.gridx = 2;
    gbc.gridy = 0;
    gbc.insets = new Insets(50, 5, 5, 5);
    this.add(piecesButton, gbc);
    
    gbc.gridx = 3;
    gbc.gridy = 0;
    gbc.insets = new Insets(50, 5, 5, 25);
    this.add(winConditionButton, gbc);
    
    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.insets = new Insets(5, 25, 50, 5);
    this.add(specialConditionButton, gbc);
    
    gbc.gridx = 1;
    gbc.gridy = 1;
    gbc.insets = new Insets(5, 5, 50, 5);
    this.add(puzzleButton, gbc);
    
    gbc.gridx = 2;
    gbc.gridy = 1;
    gbc.insets = new Insets(5, 5, 50, 5);
    this.add(freePlayButton, gbc);
    
    gbc.gridx = 3;
    gbc.gridy = 1;
    gbc.insets = new Insets(5, 5, 50, 25);
    this.add(exitButton, gbc);
    
    
  }
  
  public void setImage()
  {
    boardButton.setIcon(resizeIcon(new ImageIcon("images/MainMenuButtons/chessboard3.png"),boardButton.getWidth(),boardButton.getHeight()));
    piecesButton.setIcon(resizeIcon(new ImageIcon("images/MainMenuButtons/piece3.png"),piecesButton.getWidth(),piecesButton.getHeight()));
    winConditionButton.setIcon(resizeIcon(new ImageIcon("images/MainMenuButtons/WinCondition2.png"),winConditionButton.getWidth(),winConditionButton.getHeight()));
    specialConditionButton.setIcon(resizeIcon(new ImageIcon("images/MainMenuButtons/SpecialCondition2.png"),specialConditionButton.getWidth(),specialConditionButton.getHeight()));
    puzzleButton.setIcon(resizeIcon(new ImageIcon("images/MainMenuButtons/puzzle2.png"),puzzleButton.getWidth(),puzzleButton.getHeight()));
    freePlayButton.setIcon(resizeIcon(new ImageIcon("images/MainMenuButtons/FreePlayMode2.png"),freePlayButton.getWidth(),freePlayButton.getHeight()));
    exitButton.setIcon(resizeIcon(new ImageIcon("images/MainMenuButtons/exit2.png"),exitButton.getWidth(),exitButton.getHeight()));
  }
  
  private static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight)
  {
    Image img = icon.getImage();  
    Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight,  Image.SCALE_SMOOTH);
    return new ImageIcon(resizedImage);
  }
  
  public void registerControllers()
  {
    
    MainMenuController controller = new MainMenuController(this.view.getModel(), boardButton, piecesButton,
                                                           winConditionButton, specialConditionButton, puzzleButton, freePlayButton, exitButton);
    
    this.boardButton.addActionListener(controller);
    this.piecesButton.addActionListener(controller);
    this.winConditionButton.addActionListener(controller);
    this.specialConditionButton.addActionListener(controller);
    this.puzzleButton.addActionListener(controller);
    this.freePlayButton.addActionListener(controller);
    this.exitButton.addActionListener(controller);
  }

  public void update()
  {
  }
}