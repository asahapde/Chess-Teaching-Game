package com.company;

import javax.swing.*;
import java.awt.*;

public class SpecialConditionGUI1 extends JPanel
{
  private JAN model;
  
  private String currentPanel;
  
  private ChessBoard board;
  private JPanel topPanel = new JPanel();
  private JPanel rightPanel = new JPanel();
  private JPanel botPanel = new JPanel();
  private JPanel buttons = new JPanel();
  private JPanel colorPanel = new JPanel();
  private JPanel colorPanel2 = new JPanel();
  private JPanel titlePanel = new JPanel();
  private JButton leftButton = new JButton("< Prev");
  private JButton rightButton = new JButton("Next >");
  private JButton mainMenuButton = new JButton("Main Menu");
  private JButton resetButton = new JButton("Reset");
  private JLabel title = new JLabel("Castling");
  private JLabel description = new JLabel("<html><left>"+"Castling is a move that is normally used to improve the king's safety. Castling is" + 
                                          "<br>" + "the only move that allows two pieces, the king and a rook to move at the same time." + "<br>" + " " + "<br>" +
                                          "You can only castle if all of the following conditions are present:" + "<br>" + " " + "<br>" +
                                          "1. If neither the king nor the rook being used has been moved yet during the game," + "<br>" +
                                          "&emsp;" + "castling is possible." + "<br>" + 
                                          "2. If either piece has been moved, then castling is not allowed, even if the piece is" + "<br>" + 
                                          "&emsp;" + "moved back to its original square." + "<br>" + 
                                          "3. The king must not be in check when castling is performed, nor can castling" + "<br>" + 
                                          "&emsp;" + "move the king through a square where it would be in check." + "<br>" + " " + "<br>" +
                                          "If all of these conditions are met, you can castle:" + "<br>" + " " + "<br>" +
                                          "Step 1: Move the king two squares toward the rook." + "<br>" + 
                                          "Step 2: Hop the rook over the king so it lands on the square next to the king." + "<br>" + " " + "<br>" +
                                          "Demonstration:" + "<br>" + "<b> TRY IT OUT ON THE BOARD </b>" +
                                          "</left></html>");
  private Font font1 = new Font("Times New Roman", Font.PLAIN, 30);
  private Font font2 = new Font("Times New Roman", Font.PLAIN, 17);
  //https://www.thesprucecrafts.com/castling-promotion-and-en-passant-611548
  public SpecialConditionGUI1(JAN model)//JAN model)
  {
    super();
    this.model = model;
    board = new ChessBoard(745, Color.WHITE, this.model);
    this.layoutView();
    this.registerController();
  }
  
  private void layoutView()
  {
    title.setHorizontalAlignment(SwingConstants.CENTER);
    title.setFont(font1);
    
    description.setFont(font2);
    
    leftButton.setPreferredSize(new Dimension(130,50));
    rightButton.setPreferredSize(new Dimension(130,50));
    mainMenuButton.setPreferredSize(new Dimension(80,50));
    

    titlePanel.add(title);
    titlePanel.setBackground(new Color(185,156,107));
    
    topPanel.setBackground(new Color(185,156,107));
    topPanel.setLayout(new BorderLayout());
    topPanel.add(leftButton, BorderLayout.WEST);
    topPanel.add(titlePanel, BorderLayout.CENTER);
    topPanel.add(rightButton, BorderLayout.EAST);
    
    buttons.setBackground(new Color(185,156,107));
    buttons.setLayout(new GridLayout(2,7,7,7));
    buttons.add(new JLabel(""));
    buttons.add(new JLabel(""));
    buttons.add(new JLabel(""));
    buttons.add(resetButton);
    buttons.add(new JLabel(""));
    buttons.add(new JLabel(""));
    buttons.add(new JLabel(""));
    buttons.add(new JLabel(""));
    buttons.add(new JLabel(""));
    buttons.add(new JLabel(""));
    buttons.add(mainMenuButton);
    buttons.add(new JLabel(""));
    buttons.add(new JLabel(""));
    buttons.add(new JLabel(""));
    
    colorPanel.setPreferredSize(new Dimension(700,7));
    colorPanel.setBackground(new Color(185,156,107));
    colorPanel2.setPreferredSize(new Dimension(700,7));
    colorPanel2.setBackground(new Color(185,156,107));
    
    botPanel.setLayout(new BoxLayout(botPanel, BoxLayout.Y_AXIS));
    botPanel.add(colorPanel);
    botPanel.add(buttons);
    botPanel.add(colorPanel2);
                 
    rightPanel.setLayout(new BorderLayout());
    rightPanel.setBackground(new Color(213,196,161));
    rightPanel.setPreferredSize(new Dimension(700,700));
    rightPanel.add(new JLabel("        "), BorderLayout.WEST);
    rightPanel.add(new JLabel("        "), BorderLayout.EAST);
    rightPanel.add(description, BorderLayout.CENTER);
    rightPanel.add(botPanel, BorderLayout.SOUTH);
    
    this.setLayout(new BorderLayout());
    this.add(topPanel, BorderLayout.NORTH);
    this.add(board, BorderLayout.WEST);
    this.add(rightPanel, BorderLayout.EAST);
    
  }

  
  private void registerController()
  {
    BackButtonController controller = new BackButtonController(this.mainMenuButton,this.model);
    
    this.mainMenuButton.addActionListener(controller);
    
    SpecialConditionButtonController controller2 = new SpecialConditionButtonController(this.leftButton,this.rightButton,this.model);
    
    this.leftButton.addActionListener(controller2);
    this.rightButton.addActionListener(controller2);
  }
  
  public void setCurrentPanel(String aPanel)
  {
    this.currentPanel = aPanel;
  }
  
  public String getCurrentPanel()
  {
    return this.currentPanel;
  }
  
  public void update()
  {
    if(this.currentPanel == "SpecialConditionGUI1")
    {
      title.setText("Castling");
      board.setColor(Color.YELLOW);
      description.setText("<html><left>"+"Castling is a move that is normally used to improve the king's safety. Castling is" + 
                                          "<br>" + "the only move that allows two pieces, the king and a rook to move at the same time." + "<br>" + " " + "<br>" +
                                          "You can only castle if all of the following conditions are present:" + "<br>" + " " + "<br>" +
                                          "1. If neither the king nor the rook being used has been moved yet during the game," + "<br>" +
                                          "&emsp;" + "castling is possible." + "<br>" + 
                                          "2. If either piece has been moved, then castling is not allowed, even if the piece is" + "<br>" + 
                                          "&emsp;" + "moved back to its original square." + "<br>" + 
                                          "3. The king must not be in check when castling is performed, nor can castling" + "<br>" + 
                                          "&emsp;" + "move the king through a square where it would be in check." + "<br>" + " " + "<br>" +
                                          "If all of these conditions are met, you can castle:" + "<br>" + " " + "<br>" +
                                          "Step 1: Move the king two squares toward the rook." + "<br>" + 
                                          "Step 2: Hop the rook over the king so it lands on the square next to the king." + "<br>" + " " + "<br>" +
                                          "Demonstration:" + "<br>" + "<b> TRY IT OUT ON THE BOARD </b>" +
                                          "</left></html>");
    }
    else if(this.currentPanel == "SpecialConditionGUI2")
    {
      System.out.println("lol");
      title.setText("Pawn Promotion");
      board.setColor(Color.RED);
      description.setText("<html><left>"+"Pawns are the weakest pieces on the board, but they have the potential to become" + 
                                          "<br>" + "much stronger. Should a pawn manage to make it all the way to the other end of" +
                                          "<br>" + "the board, that pawn must be promoted to any piece its player chooses, other than" + "<br>" +
                                          "a king" + "<br>" + " " + "<br>" +
                                          "Generally, you would promote a pawn to a queen; however, you can also promote it " + "<br>" +
                                          "to a rook, knight, or bishop. When the pawn is promoted to a queen, the move is " + "<br>" + 
                                          "often termed queening, and it is allowable for there to be two queens of the same " + "<br>" + 
                                          "color on the board. Sometimes a rook is used in an inverted position to designate " + "<br>" + 
                                          "the second queen." + "<br>" + " " + "<br>" +
                                          "Promoting to something other than a queen is known as underpromotion. Since the " + "<br>" +
                                          "queen is the most powerful piece, promotion is for a queen. However, there may be " + "<br>" +
                                          "a rare instance where the movement of a knight or other piece might offer an" + "<br>" + 
                                          "immediate benefit, in which case underpromotion is used." + "<br>" + " " + "<br>" +
                                          "Demonstration:" + "<br>" + "<b> Try moving the pawn to the end of the board </b>" +
                                          "</left></html>");
    }
    else if(this.currentPanel == "SpecialConditionGUI3")
    {
      title.setText("En Passant");
      board.setColor(Color.BLUE);
      description.setText("<html><left>"+"En Passant is a move that allows a pawn that has moved two squares to be captured as" + 
                                          "<br>" + "though it had only moved one."+ "However, there are several conditions must be present for" + "<br>" +
                                          "an en passant capture to be legal: " + "<br>" + 
                                          " " + "<br>" +
                                          "<b>" + "1. En Passant is ONLY for PAWNS!" + "</b>" + "<br>" +
                                          "Although pawns are considered as the weakest piece in chess, they are the only piece that can use this special rule." + 
                                          "<br>" + " " + "<br>" +
                                          "<b>" + "2. The capturing pawn must be on the fifth rank. The captured pawn must be on the fourth rank." + "</b>" + "<br>" + 
                                          "For example your white pawn must be on the fifth rank, and for Black the pawn must be on the fouth rank!" + "<br>" + " " + "<br>" +
                                          "<b>" + "3. The captured pawn MUST move two squares forward." + "</b>" + "<br>" +
                                          "For you to capture en passant your opponent's pawn MUST move two squares forward, landing next to your pawn." + 
                                          "That means they had to move a pawn that has not moved, as pawns can only move two squares on their first turn." + 
                                          "<br>" + " "+ "<br>" +
                                          "<b>" + "4. You MUST use the en passant capture on that turn!" + "</b>" + "<br>" +
                                          "As soon as your opponent moves two squares forward next to your pawn, you have to decide if" + 
                                          "you want to use the en passant capture. You only get one chance to capture en passant." +
                                          "</left></html>");
    }
    
    board.update();
    this.repaint();
  }
}