package com.company;

public class King extends Piece
{
  public King(boolean available, String color, int x, int y)
  {
    super(available, color, x, y);
  }
  
  public boolean isValidMove(int startX, int startY, int x, int y, String color, int[][] piece)
  {
    if(super.isValidMove(startX, startY, x, y) == false)
    {
      return false;
    }
    if(x- startX == 1 && y - startY == 1)
    {
      if(this.isDanger(x, y, piece, color) == false)
      {
        return true;
      }
    }
    if(x - startX == 0 && y - startY == 1)
    {
      if(this.isDanger(x, y, piece, color) == false)
      {
        return true;
      }
    }
    if(x - startX == -1 && y - startY == 1)
    {
      if(this.isDanger(x, y, piece, color) == false)
      {
        return true;
      }
    }
    if(x - startX == -1 && y - startY == 0)
    {
      if(this.isDanger(x, y, piece, color) == false)
      {
        return true;
      }
    }
    if(x - startX == -1 && y - startY == -1)
    {
      if(this.isDanger(x, y, piece, color) == false)
      {
        return true;
      }
    }
    if(x - startX == 0 && y - startY == -1)
    {
      if(this.isDanger(x, y, piece, color) == false)
      {
        return true;
      }
    }
    if(x - startX == 1 && y - startY == -1)
    {
      if(this.isDanger(x, y, piece, color) == false)
      {
        return true;
      }
    }
    return false;
  }
  
  public boolean isDanger(int x, int y, int[][] piece, String color)
  {
    int l = x;
    int m = y;
    if(color == "BLACK")
    {
      while(piece[l][y] == 0 && l <= 8)
      {
        l++;
      }
      if(piece[l][y] == 1 || piece[l][y] == 2)
      {
        return true;
      }
      l = x;
      while(piece[l][y] == 0 && l >= 0)
      {
        l--;
      }
      if(piece[l][y] == 1 || piece[l][y] == 2)
      {
        return true;
      }
      l = x;
      while(piece[x][m] == 0 && m <= 8)
      {
        m++;
      }
      if(piece[x][m] == 1 || piece[x][m] == 2)
      {
        return true;
      }
      m = y;
      while(piece[x][m] == 0 && m >= 0)
      {
        m--;
      }
      if(piece[x][m] == 1 || piece[x][m] == 2)
      {
        return true;
      }
      m = y;
      while(piece[l][m] == 0 && (l <= 8 || m <= 8))
      {
        l++;
        m++;
      }
      if(piece[l][m] == 1 || piece[l][m] == 3)
      {
        return true;
      }
      l = x;
      m = y;
      while(piece[l][m] == 0 && (l >= 0 || m <= 7))
      {
        l--;
        m++;
      }
      if(piece[l][m] == 1 || piece[l][m] == 3)
      {
        return true;
      }
      l = x;
      m = y;
      while(piece[l][m] == 0 && (l >= 0 || m >= 0))
      {
        l--;
        m--;
      }
      if(piece[l][m] == 1 || piece[l][m] == 3)
      {
        return true;
      }
      l = x;
      m = y;
      while(piece[l][m] == 0 && (l <= 7 || m >= 0))
      {
        l++;
        m--;
      }
      if(piece[l][m] == 1 || piece[l][m] == 3)
      {
        return true;
      }
      l = x;
      m = y;
      if(piece[x + 1][y + 2] == 4 || piece[x + 2][y + 1] == 4 || piece[x + 2][y - 1] == 4 || piece[x + 1][y - 2] == 4 || piece[x - 1][y - 2] == 4 || piece[x - 2][y - 1] == 4 || piece[x - 2][y + 1]== 4 || piece[x - 1][y + 2] == 4)
      {
        return true;
      }
      return false;
    }
    else
    {
      while(piece[l][y] == 0 && l <= 8)
      {
        l++;
      }
      if(piece[l][y] == 7 || piece[l][y] == 8)
      {
        return true;
      }
      l = x;
      while(piece[l][y] == 0 && l >= 0)
      {
        l--;
      }
      if(piece[l][y] == 7 || piece[l][y] == 8)
      {
        return true;
      }
      l = x;
      while(piece[x][m] == 0 && m <= 8)
      {
        m++;
      }
      if(piece[x][m] == 7 || piece[x][m] == 8)
      {
        return true;
      }
      m = y;
      while(piece[x][m] == 0 && m >= 0)
      {
        m--;
      }
      if(piece[x][m] == 7 || piece[x][m] == 8)
      {
        return true;
      }
      m = y;
      while(piece[l][m] == 0 && (l <= 8 || m <= 8))
      {
        l++;
        m++;
      }
      if(piece[l][m] == 7 || piece[l][m] == 9)
      {
        return true;
      }
      l = x;
      m = y;
      while(piece[l][m] == 0 && (l >= 0 || m <= 7))
      {
        l--;
        m++;
      }
      if(piece[l][m] == 7 || piece[l][m] == 9)
      {
        return true;
      }
      l = x;
      m = y;
      while(piece[l][m] == 0 && (l >= 0 || m >= 0))
      {
        l--;
        m--;
      }
      if(piece[l][m] == 7 || piece[l][m] == 9)
      {
        return true;
      }
      l = x;
      m = y;
      while(piece[l][m] == 0 && (l <= 7 || m >= 0))
      {
        l++;
        m--;
      }
      if(piece[l][m] == 7 || piece[l][m] == 9)
      {
        return true;
      }
      l = x;
      m = y;
      if(piece[x + 1][y + 2] == 10 || piece[x + 2][y + 1] == 10 || piece[x + 2][y - 1] == 10 || piece[x + 1][y - 2] == 10 || piece[x - 1][y - 2] == 10 || piece[x - 2][y - 1] == 10 || piece[x - 2][y + 1] == 10 || piece[x - 1][y + 2] == 10)
      {
        return true;
      }
      return false;
    }
  }
  
  public String getKingInfo()
  {
    return("lets go");
  }
}