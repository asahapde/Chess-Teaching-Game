package com.company;

public class Piece
{
  private boolean available;
  private int xPosition;
  private int yPosition;
  private String color;
  
  public Piece(boolean available, String color, int x, int y)
  {
    super();
    this.available = available;
    this.xPosition = x;
    this.yPosition = y;
    this.color = color;
  }
  
  public String getColor()
  {
    return color;
  }
  
  public int getXPosition()
  {
    return xPosition;
  }
  
  public int getYPosition()
  {
    return yPosition;
  }
  
  public boolean isAvailable()
  {
    return available;
  }
  
  public void setXPosition(int x)
  {
    this.xPosition = x;
  }
  
  public void setYPosition(int y)
  {
    this.yPosition = y;
  }
  
  public void setAvailable(boolean available)
  {
    this.available = available;
  }
  
  public boolean isValidMove(int startX, int startY, int x, int y)
  {
    if(startX == x && startY == y)
    {
      return false;
    }
    return true;
  }
}