package com.company;

public class Rook extends Piece
{
  public Rook(boolean available, String color, int x, int y)
  {
    super(available, color, x, y);
  }
  
  public boolean isValidMove(int startX, int startY, int x, int y)
  {
    if(super.isValidMove(startX, startY, x, y) == false)
    {
      return false;
    }
    if(x == startX)
    {
      return true;
    }
    if(y == startY)
    {
      return true;
    }
    return false;
  }
  
  public boolean isOpen(int startX, int startY, int x, int y, int[][] piece)
  {
    int l = startX;
    int m = startY;
    if(x > startX)
    {
      l++;
      while(l <= x)
      {
        if(piece[l][startY] != 0)
        {
          return false;
        }
        l++;
      }
      return true;
    }
    if(x < startX)
    {
      l--;
      while(l >= x)
      {
        if(piece[l][startY] != 0)
        {
          return false;
        }
        l--;
      }
      return true;
    }
    if(y > startY)
    {
      m++;
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
    if(y < startY)
    {
      m--;
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
    return false;
  }
  
  public String getRookInfo()
  {
    return("This is a rook. It has the second most" + 
           " value of any other piece(excluding the king)." + 
           " It can move forward, backwards, to the left" + 
           " and right, in a straight line if unobstructed." +  
           " Each player starts the game with 2 rooks," + 
           " found at the 2 corners of their first row" + 
           " on their respective side.");
  }
}