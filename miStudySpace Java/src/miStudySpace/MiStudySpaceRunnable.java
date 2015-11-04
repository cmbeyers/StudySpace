package miStudySpace;

import javax.swing.*;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;



public class MiStudySpaceRunnable
{
  public static BackendUpdate backend;
  public static sqlDatabase db;

  public static void main( String[] args ) throws IOException
  {
    db = new sqlDatabase();
    backend = new BackendUpdate();
  }
}
