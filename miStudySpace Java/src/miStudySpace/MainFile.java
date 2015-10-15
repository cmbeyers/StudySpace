package miStudySpace;

import javax.swing.*;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;



public class MainFile
{
  public static HomeScreen win;
  public static sqlDatabase db;

  public static void main( String[] args ) throws IOException
  {
    db = new sqlDatabase();
    win = new HomeScreen();
    win.setMinimumSize(new Dimension(400, 400));
    //win.pack();
    win.setVisible(true);
    win.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  }
}
