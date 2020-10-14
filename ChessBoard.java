package com.company;

import javax.swing.*;
import java.awt.*;

public class ChessBoard extends JPanel
{
  private JAN model;
  
  private JToggleButton[][] square = new JToggleButton[8][8];
  private JLabel[] let1 = new JLabel[8];
  private JLabel[] let2 = new JLabel[8];
  private JLabel[] num1 = new JLabel[8];
  private JLabel[] num2 = new JLabel[8];
  private JLabel[] empty = new JLabel[4];
  private Color lightBrwn = new Color(255,217,178);
  private Color darkBrwn = new Color(162,118,89);
  
  private JPanel main = new JPanel();
  
  private final String LETTERS = "ABCDEFGH";
  
  private int size = 600;
  
  private Color bg;
  
  /*0- nothing
   * 1- queen
   * 2- rook
   * 3 - bishop
   * 4 -knight
   * 5- pawn
   * 6- king
   * */
  
  public ChessBoard(JAN aModel)
  {
    super();
    this.model = aModel;
    this.makeLayout();
    this.registerControllers();
    this.update();
  }
  
  public ChessBoard(int aSize, Color aColor, JAN aModel)
  {
    super();
    this.model = aModel;
    this.size = aSize;
    this.bg = aColor;
    this.makeLayout();
    this.registerControllers();
    this.update();
  }
  
  public void makeLayout()
  {
    main.setPreferredSize(new Dimension(size,size));
    main.setMinimumSize(new Dimension(size,size));
    
    main.setLayout(new GridLayout(10,10));
    
    this.setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    
    this.setBackground(this.bg);
    
    
    
    for(int i = 0; i< empty.length;i++)
    {
      empty[i] = new JLabel();
      empty[i].setOpaque(true);
      empty[i].setBackground(this.bg);
    }
    
    for(int i = 0 ;i < let1.length; i++)
    {
      let1[i] = new JLabel(LETTERS.substring(i,i+1));
      let1[i].setHorizontalAlignment(SwingConstants.CENTER);
      let1[i].setOpaque(true);
      let1[i].setBackground(this.bg);
      
      let2[i] = new JLabel(LETTERS.substring(i,i+1));
      let2[i].setHorizontalAlignment(SwingConstants.CENTER);
      let2[i].setOpaque(true);
      let2[i].setBackground(this.bg);
    }
    
    for(int i = 0 ;i < num1.length; i++)
    {
      num1[i] = new JLabel(Integer.toString(i+1));
      num1[i].setHorizontalAlignment(SwingConstants.CENTER);
      num1[i].setOpaque(true);
      num1[i].setBackground(this.bg);
      
      num2[i] = new JLabel(Integer.toString(i+1));
      num2[i].setHorizontalAlignment(SwingConstants.CENTER);
      num2[i].setOpaque(true);
      num2[i].setBackground(this.bg);
    }
    
 
    for(int x = 0; x < square.length; x++)
    {
      for(int y = 0; y < square.length; y++)
      { 
        square[y][x] = new JToggleButton();
        if((x%2==0 && y%2==0) || (y%2!=0 && x%2!=0))
        {
          square[y][x].setBackground(lightBrwn);
        }
        else
        {
          square[y][x].setBackground(darkBrwn);
        }
        square[y][x].setBorderPainted(false);
      }
    }
    
    
    for(int row = 0; row < 10; row++)
    {
      for(int col = 0; col < 10; col++)
      {
        if(row==0 && col==0) 
          main.add(empty[0]);
        else if(row==0 && col==9) 
          main.add(empty[1]);
        else if(row==9 && col==0) 
          main.add(empty[2]);
        else if(row==9 && col==9) 
          main.add(empty[3]);
        else if(row==0 && col>0 && col<9)
          main.add(let1[col-1]);
        else if((col==0) && (row<9) && (row>0))
          main.add(num1[8-row]);
        else if((col==9) && (row<9) && (row>0))
          main.add(num2[8-row]);
        else if(col<9 && row<9 && col>0 && row>0)
          main.add(square[row-1][col-1]);
        else if (row==9 && col>0 && col<9)
          main.add(let2[col-1]);
      }
    }
    
    gbc.weightx=1.0;
    gbc.weighty=1.0;
    gbc.fill = GridBagConstraints.BOTH;
    
    
    this.add(main);
  }
  
  public void setColor(Color aColor)
  {
    this.bg = aColor;
    
    this.update();
  }
  
  public Color getColor()
  {
    return this.bg;
  }
  
  public void setDim(int x)
  {
    this.size = x;
    
    this.update();
  }
  
  public int getDim()
  {
    return this.size;
  }
  
  private void registerControllers()
  {
    BoardButtonController controller = new BoardButtonController(this.square, this.model);
    
    for(int row =0; row<square.length; row++)
    {
      for(int col =0; col<square[row].length; col++)
      {
        this.square[row][col].addActionListener(controller);
      }
    }
  }
  
  private void disable(int x, int y)
  {
    this.square[y][x].setEnabled(false);
  }
  
  private void enable(int x, int y)
  {
    this.square[y][x].setEnabled(true);
  }
  
  
  /*0- nothing
   * 1- queen
   * 2- rook
   * 3 - bishop
   * 4 -knight
   * 5- pawn
   * 6- king
   * */
  
  private void setPieceImage()
  {
    for(int row =0; row<this.model.getPieceLength(); row++)
    {
      for(int col =0; col<this.model.getPieceLength(); col++)
      {
        if(model.getPiece(row,col)==5)
        {
          this.square[row][col].setIcon(new ImageIcon("images/PiecesSprites/whitePawn.png"));
        }
        else if(model.getPiece(row,col)==4)
        {
          this.square[row][col].setIcon(new ImageIcon("images/PiecesSprites/whiteKnight.png"));
        }
        else if(model.getPiece(row,col)==3)
        {
          this.square[row][col].setIcon(new ImageIcon("images/PiecesSprites/whiteBishop.png"));
        }
        else if(model.getPiece(row,col)==2)
        {
          this.square[row][col].setIcon(new ImageIcon("images/PiecesSprites/whiteRook.png"));
        }
        else if(model.getPiece(row,col)==1)
        {
          this.square[row][col].setIcon(new ImageIcon("images/PiecesSprites/whiteQueen.png"));
        }
        else if(model.getPiece(row,col)==6)
        {
          this.square[row][col].setIcon(new ImageIcon("images/PiecesSprites/whiteKing.png"));
        }
        
        if(model.getPiece(row,col)==11)
        {
          this.square[row][col].setIcon(new ImageIcon("images/PiecesSprites/blackPawn.png"));
        }
        else if(model.getPiece(row,col)==10)
        {
          this.square[row][col].setIcon(new ImageIcon("images/PiecesSprites/blackKnight.png"));
        }
        else if(model.getPiece(row,col)==9)
        {
          this.square[row][col].setIcon(new ImageIcon("images/PiecesSprites/blackBishop.png"));
        }
        else if(model.getPiece(row,col)==8)
        {
          this.square[row][col].setIcon(new ImageIcon("images/PiecesSprites/blackRook.png"));
        }
        else if(model.getPiece(row,col)==7)
        {
          this.square[row][col].setIcon(new ImageIcon("images/PiecesSprites/blackQueen.png"));
        }
        else if(model.getPiece(row,col)==12)
        {
          this.square[row][col].setIcon(new ImageIcon("images/PiecesSprites/blackKing.png"));
        }

        
      }
    }
  }
  
  public void update()
  {
    this.setBackground(this.bg);
    
    this.setPieceImage();
    
    
    for(int row =0; row<this.model.getPieceLength(); row++)
    {
      for(int col =0; col<this.model.getPieceLength(); col++)
      {
        if(model.getPiece(row,col)==-2)
          this.square[row][col].setEnabled(false);
      }
    }
    
    for(int i = 0; i< empty.length;i++)
    {
      empty[i].setBackground(this.bg);
    }
    
    for(int i = 0 ;i < let1.length; i++)
    {

      let1[i].setBackground(this.bg);
      
      let2[i].setBackground(this.bg);
    }
    
    for(int i = 0 ;i < num1.length; i++)
    {

      num1[i].setBackground(this.bg);
      

      num2[i].setBackground(this.bg);
    }
    
    main.setPreferredSize(new Dimension(size,size));
    main.setMinimumSize(new Dimension(size,size));
    
    this.repaint();
  }
}