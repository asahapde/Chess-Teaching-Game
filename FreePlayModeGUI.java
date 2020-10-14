package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.lang.*;

public class FreePlayModeGUI extends JPanel
{
  private JAN model;
  
  private ChessBoard board;
  private JPanel leftPanel = new JPanel();
  private JPanel leftButtons = new JPanel();
  private JPanel rightPanel = new JPanel();
  private JPanel centerPanel = new JPanel();
  private JPanel rightButtons = new JPanel();
  private JPanel titlePanel = new JPanel();
  private JLabel blackLabel = new JLabel("Black");
  private JLabel whiteLabel = new JLabel("White");
  private JLabel title = new JLabel("Free Play Mode");
  private JButton mainMenuButton = new JButton("Main Menu");
  
  private Font font1 = new Font("Adrift", Font.BOLD, 85);
  private Font font2 = new Font("Adrift", Font.PLAIN, 55);
  private Color color = new Color(213,196,161);
  
  private JButton blackKing = new JButton("blackKing");
  private JButton blackQueen = new JButton("blackQueen");
  private JButton blackRook = new JButton("blackRook");
  private JButton blackBishop = new JButton("blackBishop");
  private JButton blackKnight = new JButton("blackKnight");
  private JButton blackPawn = new JButton("blackPawn");
  
  private JButton whiteKing = new JButton("whiteKing");
  private JButton whiteQueen = new JButton("whiteQueen");
  private JButton whiteRook = new JButton("whiteRook");
  private JButton whiteBishop = new JButton("whiteBishop");
  private JButton whiteKnight = new JButton("whiteKnight");
  private JButton whitePawn = new JButton("whitePawn");
  
  private JButton blackRemoveButton = new JButton("Black Remove");
  private JButton whiteRemoveButton = new JButton("White Remove");
  
  public FreePlayModeGUI(JAN model)
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
    this.setLayout(new BorderLayout());
    
    leftPanel.setPreferredSize(new Dimension(400,800));
    leftPanel.setBackground(color);
    leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
    //leftButtons.setLayout(new GridLayout(8,3,10,20));
    leftButtons.setLayout(new GridLayout(8,1,10,20));
    leftButtons.setBackground(color);
    
    blackLabel.setPreferredSize(new Dimension(400,200));
    blackLabel.setFont(font1);
    blackLabel.setHorizontalAlignment(JLabel.CENTER);
    blackLabel.setForeground(Color.BLACK);
    
    blackKing.setPreferredSize(new Dimension(150,150));
    //leftButtons.add(new JLabel(""));
    leftButtons.add(blackKing);
    //leftButtons.add(new JLabel(""));
    //leftButtons.add(new JLabel(""));
    leftButtons.add(blackQueen);
    //leftButtons.add(new JLabel(""));
    //leftButtons.add(new JLabel(""));
    leftButtons.add(blackRook);
    //leftButtons.add(new JLabel(""));
    //leftButtons.add(new JLabel(""));
    leftButtons.add(blackBishop);
    //leftButtons.add(new JLabel(""));
    //leftButtons.add(new JLabel(""));
    leftButtons.add(blackKnight);
    //leftButtons.add(new JLabel(""));
    //leftButtons.add(new JLabel(""));
    leftButtons.add(blackPawn);
    //leftButtons.add(new JLabel(""));
    //leftButtons.add(new JLabel(""));
    leftButtons.add(blackRemoveButton);
    leftPanel.add(blackLabel);
    leftPanel.add(leftButtons);
    
    
    rightPanel.setPreferredSize(new Dimension(400,800));
    rightPanel.setBackground(color);
    rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
    rightButtons.setLayout(new GridLayout(8,3,10,20));
    rightButtons.setBackground(color);
    
    whiteLabel.setPreferredSize(new Dimension(400,200));
    whiteLabel.setFont(font1);
    whiteLabel.setHorizontalAlignment(JLabel.CENTER);
    whiteLabel.setForeground(Color.BLACK);
    
    rightButtons.add(new JLabel(""));
    rightButtons.add(whiteKing);
    rightButtons.add(new JLabel(""));
    rightButtons.add(new JLabel(""));
    rightButtons.add(whiteQueen);
    rightButtons.add(new JLabel(""));
    rightButtons.add(new JLabel(""));
    rightButtons.add(whiteRook);
    rightButtons.add(new JLabel(""));
    rightButtons.add(new JLabel(""));
    rightButtons.add(whiteBishop);
    rightButtons.add(new JLabel(""));
    rightButtons.add(new JLabel(""));
    rightButtons.add(whiteKnight);
    rightButtons.add(new JLabel(""));
    rightButtons.add(new JLabel(""));
    rightButtons.add(whitePawn);
    rightButtons.add(new JLabel(""));
    rightButtons.add(new JLabel(""));
    rightButtons.add(whiteRemoveButton);
    rightPanel.add(whiteLabel);
    rightPanel.add(rightButtons);
    
    mainMenuButton.setPreferredSize(new Dimension(50,70));
    title.setHorizontalAlignment(SwingConstants.CENTER);
    title.setVerticalAlignment(SwingConstants.CENTER);
    title.setPreferredSize(new Dimension(200,80));
    title.setFont(font2);
    
    titlePanel.setPreferredSize(new Dimension(50,100));
    titlePanel.setBackground(new Color(185,156,107));
    titlePanel.add(title);
    
    centerPanel.setLayout(new BorderLayout());
    centerPanel.add(titlePanel, BorderLayout.NORTH);
    centerPanel.add(board, BorderLayout.CENTER);
    centerPanel.add(mainMenuButton, BorderLayout.SOUTH);
    
    this.add(leftPanel, BorderLayout.WEST);
    this.add(centerPanel, BorderLayout.CENTER);
    this.add(rightPanel, BorderLayout.EAST);
    
  }
}
