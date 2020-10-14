package com.company;

import javax.swing.*;
import java.awt.*;
/** JANGUI
  * @since 02/05/2018
  * @author S. Abdullah
  * Creates a layout for JAN Chess Tutorial*/
public class JANGUI extends JPanel
{
  private JAN model; //The Model
  public boolean resized = false;
  private String currentPanel;
  
  private MainMenu mainMenu;
  private Puzzle puzzleGUI;
  private StartUpGUI startUp;
  private WinConditionGUI1 wCond1;
  private SpecialConditionGUI1 sCond1;

  private FreePlayModeGUI fpMode;
  
  /** Default constructor for the GUI.  Assigns Model and View, identifies controllers
    * and draws the layout
    * @param aModel The Model for the name generator
    */
  public JANGUI(JAN aModel)
  {
    super();
    this.model = aModel;
    this.mainMenu = new MainMenu(this);
    this.puzzleGUI = new Puzzle(this.model);
    this.startUp = new StartUpGUI();
    this.wCond1 = new WinConditionGUI1(this.model);

    this.sCond1 = new SpecialConditionGUI1(this.model);

    this.fpMode = new FreePlayModeGUI(this.model);
    this.currentPanel = model.getCurrentPanel();
    this.model.setGUI(this);
    this.layoutView();
    this.registerControllers();
    this.update();
  }
  
  public void layoutView()
  {
    
    this.setLayout(new BorderLayout());
    
  }
  
  public void registerControllers()
  {
  }
  
  public JAN getModel()
  {
    return this.model;
  }
  
  public String getCurrentPanel()
  {
    return this.currentPanel;
  }
  
  public void changeCurrPanel(String panel)
  {
    this.currentPanel = panel;
  }
  
  public void removePanel(String panel)
  {
    if(panel == "Puzzle")
      this.remove(this.puzzleGUI);
    else if(panel == "MainMenu")
      this.remove(mainMenu);
    else if(panel == "StartUpGUI")
      this.remove(startUp);
    else if(panel == "WinConditionGUI1")
      this.remove(wCond1);
    else if(panel == "WinConditionGUI2")
      this.remove(wCond1);
    else if(panel == "WinConditionGUI3")
      this.remove(wCond1);
    else if(panel == "SpecialConditionGUI1")
      this.remove(sCond1);
    else if(panel == "SpecialConditionGUI2")
      this.remove(sCond1);
    else if(panel == "SpecialConditionGUI3")
      this.remove(sCond1);
    else if(panel == "FreePlayModeGUI")
      this.remove(fpMode);
  }
  
  public void update()
  {
    if(this.currentPanel == "Puzzle")
      this.add(this.puzzleGUI, BorderLayout.CENTER);
    else if(this.currentPanel == "MainMenu")
      this.add(mainMenu, BorderLayout.CENTER);
    else if(this.currentPanel == "StartUpGUI")
      this.add(startUp, BorderLayout.CENTER);
    else if(this.currentPanel == "WinConditionGUI1")
    {
      this.add(wCond1, BorderLayout.CENTER);
      wCond1.setCurrentPanel("WinConditionGUI1");
      wCond1.update();
    }
    else if(this.currentPanel == "WinConditionGUI2")
    {
      this.add(wCond1, BorderLayout.CENTER);
      wCond1.setCurrentPanel("WinConditionGUI2");
      wCond1.update();
    }
    else if(this.currentPanel == "WinConditionGUI3")
    {
      this.add(wCond1, BorderLayout.CENTER);
      wCond1.setCurrentPanel("WinConditionGUI3");
      wCond1.update();
    }
    else if(this.currentPanel == "SpecialConditionGUI1")
    {
      this.add(sCond1, BorderLayout.CENTER);
      sCond1.setCurrentPanel("SpecialConditionGUI1");
      sCond1.update();
    }
    else if(this.currentPanel == "SpecialConditionGUI2")
    {
      this.add(sCond1, BorderLayout.CENTER);
      sCond1.setCurrentPanel("SpecialConditionGUI2");
      System.out.println("lol");
      sCond1.update();
    }
    else if(this.currentPanel == "SpecialConditionGUI3")
    {
      this.add(sCond1, BorderLayout.CENTER);
      sCond1.setCurrentPanel("SpecialConditionGUI3");
      sCond1.update();
    }
    else if(this.currentPanel == "FreePlayModeGUI")
      this.add(fpMode, BorderLayout.CENTER);
 
    
    this.validate();
    this.repaint();
    
    if(resized){
      mainMenu.setImage();
    }
  }
}
  