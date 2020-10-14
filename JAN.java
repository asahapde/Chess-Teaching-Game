package com.company;

public class JAN
{
  private JANGUI view; //The GUI
  private String currentPanel = "MainMenu";
  
  private int wcChoice = 0;
  private int scChoice = 0;
  
  private int[][] pieces = new int[8][8];
  
  private Pawn[] pawn = new Pawn[16];
  
  private int fx = -1;
  private int fy = -1;
  
  private int sx = -1;
  private int sy = -1;
  
  
  public JAN()
  {
    super();
    
    /*0- nothing
   * 1- queen
   * 2- rook
   * 3 - bishop
   * 4 -knight
   * 5- pawn
   * 6- king
   * */
    
    int i = 0;
    for(int row =0; row<pieces.length; row++)
    {
      for(int col =0; col<pieces[row].length; col++)
      {
        if(row==6)
        {
          pieces[row][col] = 5; // pawn
          //pawn[i] = new Pawn(true, "white", col, row);
        }
        else if(row==7 && col ==0)
          pieces[row][col] = 2; // rook
        else if(row==7 && col ==7)
          pieces[row][col] = 2; // rook
        else if(row==7 && col ==1)
          pieces[row][col] = 4; // knight
        else if(row==7 && col ==6)
          pieces[row][col] = 4; // knight
        else if(row==7 && col ==2)
          pieces[row][col] = 3; // bishop
        else if(row==7 && col ==5)
          pieces[row][col] = 3; // bishop
        else if(row==7 && col ==3)
          pieces[row][col] = 1; // queen
        else if(row==7 && col ==4)
          pieces[row][col] = 6; // king  
        else if(row==1)
          pieces[row][col] = 11; // pawn
        else if(row==0 && col ==0)
          pieces[row][col] = 8; // rook
        else if(row==0 && col ==7)
          pieces[row][col] = 8; // rook
        else if(row==0 && col ==1)
          pieces[row][col] = 10; // knight
        else if(row==0 && col ==6)
          pieces[row][col] = 10; // knight
        else if(row==0 && col ==2)
          pieces[row][col] = 9; // bishop
        else if(row==0 && col ==5)
          pieces[row][col] = 9; // bishop
        else if(row==0 && col ==3)
          pieces[row][col] = 7; // queen
        else if(row==0 && col ==4)
          pieces[row][col] = 12; // king
        else
          pieces[row][col] = 0; 
        
        
        i++;
      }
    }
  }
  
  public void setGUI(JANGUI aView)
  {
    this.view = aView;
  }
  
  public String getCurrentPanel()
  {
    return this.currentPanel;
  }
  
  public void switchWcPanel(String option)
  {
    if(option == "next" && wcChoice < 2)
    {
      wcChoice++;
    }
    else if(option == "prev" && wcChoice > 0)
    {
      wcChoice--;
    }
    else if(option == "prev" && wcChoice == 0)
    {
      wcChoice = 2;
    }
    
    else if(option == "next" && wcChoice == 2)
    {
      wcChoice = 0;
    }
    
    if(wcChoice == 0)
    {
      this.changePanel("WinConditionGUI1");
    }
    else if(wcChoice == 1)
    {
      this.changePanel("WinConditionGUI2");
    }
    else
    {
      this.changePanel("WinConditionGUI3");
    }
  }
  
  public void switchScPanel(String option)
  {
    if(option == "next" && scChoice < 2)
    {
      scChoice++;
    }
    else if(option == "prev" && scChoice > 0)
    {
      scChoice--;
    }
    else if(option == "prev" && scChoice == 0)
    {
      scChoice = 2;
    }
    
    else if(option == "next" && scChoice == 2)
    {
      scChoice = 0;
    }
    
    if(scChoice == 0)
    {
      this.changePanel("SpecialConditionGUI1");
    }
    else if(scChoice == 1)
    {
      this.changePanel("SpecialConditionGUI2");
    }
    else
    {
      this.changePanel("SpecialConditionGUI3");
    }
  }
  
  public void changePanel(String panel)
  {
    this.view.removePanel(currentPanel);
    this.currentPanel = panel;
    this.view.changeCurrPanel(this.currentPanel);
    this.updateView();
  }
  
  public void setPiece(int row, int col, int value)
  {
    this.pieces[row][col] = value;
  }
  
  public int getPieceLength()
  {
    return this.pieces.length;
  }
  
  public int getPiece(int row, int col)
  {
    return this.pieces[row][col];
  }
  
  public void setCurrent(int r, int c)
  {
    fy = r;
    fx = c;
    
    
    for(int row =0; row<this.getPieceLength(); row++)
    {
      for(int col =0; col<this.getPieceLength(); col++)
      {
        if(row!=fy && col!=fx && this.fx!=-1)
        {
          if(pieces[fy][fx]==5 && !(pawn[col].isOpen(fx, fy, col, row, this.pieces, "white"))) //pawn
          {
            pieces[row][col] = -2;
          }
        }
      }
    }
    
    
    
    this.updateView();
  }
  
  public int getCurrentX()
  {
    return fx;
  }
  
  public int getCurrentY()
  {
    return fy;
  }
  
  public void updateView()
  {
    view.update();
  }
}