package com.company;

public class Knight extends Piece
{
  public Knight(boolean available, String color, int x, int y)
  {
    super(available, color, x, y);
  }
  
  public boolean isValidMove(int startX, int startY, int x, int y)
  {
    if(super.isValidMove(startX, startY, x, y) == false)
    {
      return false;
    }
    if(x != startX - 1 && x != startX + 1 && x != startX - 2 && x != startX + 2)
    {
      return false;
    }
    if(y != startY - 1 && y != startY + 1 && y != startY - 2 && y != startY + 2)
    {
      return false;
    }
    return true;
  }
  
  public String getKnightInfo()
  {
    return("LETS GO BRUH");
  }
}