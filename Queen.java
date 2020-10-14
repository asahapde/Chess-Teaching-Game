package com.company;

public class Queen extends Piece
{
  public Queen(boolean available, String color, int x, int y)
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
    if(((startX - x)*(startX - x)) == ((startY - y)*(startY - y)))
    {
      return true;
    }
    return false;
  }
  
  public boolean isOpen(int startX, int startY, int x, int y, int[][] piece)
  {
    int l = startX;
    int m = startY;
    if(x > startX && y == startY)
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
    if(x < startX && y == startY)
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
    if(x == startX && y > startY)
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
    if(x == startX && y < startY)
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
    if(x > startX && y > startY)
    {
      l++;
      m++;
      while(l <= x)
      {
        if(piece[l][m] != 0)
        {
          return false;
        }
        l++;
        m++;
      }
      return true;
    }
    if(x < startX && y > startY)
    {
      l--;
      m++;
      while(l >= x)
      {
        if(piece[l][m] != 0)
        {
          return false;
        }
        l--;
        m++;
      }
      return true;
    }
    if(x < startX && y < startY)
    {
      l--;
      m--;
      while(l >= x)
      {
        if(piece[l][m] != 0)
        {
          return false;
        }
        l--;
        m--;
      }
      return true;
    }
    if(x > startX && y < startY)
    {
      l++;
      m--;
      while(l <= x)
      {
        if(piece[l][m] != 0)
        {
          return false;
        }
        l++;
        m--;
      }
      return true;
    }
    return false;
  }
  
  public String getQueenInfo()
  {
    return("MY GUY");
  }
}