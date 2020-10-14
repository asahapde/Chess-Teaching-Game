package com.company;

public class Pawn extends Piece
{
  public Pawn(boolean available, String color, int x, int y)
  {
    super(available, color, x, y);
  }
  
  public boolean isValidMove(int startX, int startY, int x, int y, String color)
  {
    if(super.isValidMove(startX, startY, x, y) == false)
    {
      return false;
    }
    if(color == "BLACK")
    {
      if(startY == 1 && y - startY == 2 && startX == x)
      {
        return true;
      }
      if(y - startY == 1 && startX == x)
      {
        return true;
      }
      return false;
    }
    else
    {
      if(startY == 6 && y - startY == -2 && startX == x)
      {
        return true;
      }
      if(y - startY == -1 && startX == x)
      {
        return true;
      }
      return false;
    }
  }
  
  public boolean isOpen(int startX, int startY, int x, int y, int[][] piece, String color)
  {
    int m = startY + 1;
    if(color == "WHITE")
    {
      while(m <= y)
      {
        if(piece[startX][m] != 0)
        {
          return false;
        }
        m++;
      }
      return true;
    }
    else
    {
      while(m >= y)
      {
        if(piece[startX][m] != 0)
        {
          return false;
        }
        m--;
      }
      return true;
    }
  }
}