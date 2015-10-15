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
    try {
      db = new sqlDatabase();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    win = new HomeScreen();
    win.setMinimumSize(new Dimension(400, 400));
    //win.pack();
    win.setVisible(true);
    win.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  }
}
