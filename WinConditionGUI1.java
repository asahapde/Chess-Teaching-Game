package com.company;

import javax.swing.*;
import java.awt.*;

public class WinConditionGUI1 extends JPanel
{
  private JAN model;
    
  private JPanel botPanel = new JPanel();
  private JPanel leftButtonPanel = new JPanel();
  private JPanel rightButtonPanel = new JPanel();
  private JPanel centerPanel = new JPanel();
  private JPanel titlePanel = new JPanel();
  private JPanel buttonPanel = new JPanel();
  private JButton leftButton = new JButton("< Prev");
  private JButton rightButton = new JButton("Next >");
  private JButton mainMenuButton = new JButton("Main Menu");
  private Font font1 = new Font("Times New Roman", Font.PLAIN, 25);
  private Font font2 = new Font("Times New Roman", Font.PLAIN, 17);
  private JLabel title = new JLabel("Checkmate");
  private JLabel description = new JLabel("<html><center>"+"Checkmate (often shortened to mate) is a game position in chess and" +
                                          "other chess-like" + "<br>" + "games in which a player's king is in check (threatened with capture)" +
                                          " and there" + "<br>" + "is no way to remove the threat. Checkmating the opponent wins the game." + "</center></html>");
  
  
  private String currentPanel;
  private ChessBoard board;
  
  public WinConditionGUI1(JAN model)
  {
    super();
    this.model = model;
    board = new ChessBoard(this.model);
    this.currentPanel = model.getCurrentPanel();
    this.layoutView();
    this.registerController();
    this.update();
  }
  
  private void layoutView()
  {
    title.setPreferredSize(new Dimension(200,40));
    title.setHorizontalAlignment(SwingConstants.CENTER);
    title.setFont(font1);
    
    titlePanel.add(title);
    titlePanel.setBackground(new Color(185,156,107));
    
    description.setPreferredSize(new Dimension(700,130));
    description.setVerticalAlignment(SwingConstants.CENTER);
    description.setHorizontalAlignment(SwingConstants.CENTER);
    description.setFont(font2);
    
    buttonPanel.setPreferredSize(new Dimension(700,40));
    buttonPanel.setBackground(new Color(213,196,161));
    buttonPanel.setLayout(new GridLayout(1,9));
    buttonPanel.add(new JLabel(""));
    buttonPanel.add(new JLabel(""));
    buttonPanel.add(new JLabel(""));
    buttonPanel.add(new JLabel(""));
    buttonPanel.add(mainMenuButton);
    buttonPanel.add(new JLabel(""));
    buttonPanel.add(new JLabel(""));
    buttonPanel.add(new JLabel(""));
    buttonPanel.add(new JLabel(""));
    
    botPanel.setBackground(new Color(213,196,161));
    botPanel.setPreferredSize(new Dimension(100,200));
    botPanel.setLayout(new BorderLayout());
    botPanel.add(titlePanel, BorderLayout.NORTH);
    botPanel.add(description, BorderLayout.CENTER);
    botPanel.add(buttonPanel, BorderLayout.SOUTH);
 
    centerPanel.setLayout(new BorderLayout());
    centerPanel.add(board, BorderLayout.CENTER);
    centerPanel.add(botPanel, BorderLayout.SOUTH);
    this.setLayout(new BorderLayout());
    this.add(leftButton, BorderLayout.WEST);
    this.add(rightButton, BorderLayout.EAST);
    this.add(centerPanel, BorderLayout.CENTER);
  }
  
  private void registerController()
  {
    BackButtonController controller = new BackButtonController(this.mainMenuButton,this.model);
    
    this.mainMenuButton.addActionListener(controller);
    
    WinConditionButtonController controller2 = new WinConditionButtonController(this.leftButton,this.rightButton,this.model);
    
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
    if(this.currentPanel == "WinConditionGUI1")
    {
      description.setText("<html><center>"+"Checkmate (often shortened to mate) is a game position in chess and" +
                                          "other chess-like" + "<br>" + "games in which a player's king is in check (threatened with capture)" +
                                          " and there" + "<br>" + "is no way to remove the threat. Checkmating the opponent wins the game." + "</center></html>");
      
      title.setText("Checkmate");
    }
    else if(this.currentPanel == "WinConditionGUI2")
    {
      description.setText("<html><center>"+"A draw can occur in several situations, including draw by agreement, stalemate" +
                                          ", threefold repition of a position, the fifty-move rule"+ "<br>" + "or a draw by impossibility of" + 
                                          " checkmate (usually because of insufficient pieces to checkmate). As checkmate from some positions cannot" +
                                          "<br>" + "be forced in fewer than 50 moves (such as in the pawnless chess endgame and two knights endgame)" +
                                          ", the fifty-move rule is not applied everywhere." + "</center></html>");
      
      title.setText("Draw");
    }
    else if(this.currentPanel == "WinConditionGUI3")
    {
      description.setText("<html><center>"+"Although the objective of the game is to checkmate the opponent, chess games do not have to end in checkmate." +
                                          "<br>" + " Either player may resign which is a win for the other player. It is considered bad etiquette to continue playing when" + 
                                          "<br>" + "in a truly hopeless position." + "<br>" + "</center></html>");
      
      title.setText("Resignation");
    }
    
    board.update();
    this.repaint();
  }
}