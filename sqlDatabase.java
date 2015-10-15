package miStudySpace;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JList;

public class sqlDatabase {
//You must use the following variable as the JDBC connection
 Connection oracleConnection = null;
 static String dataType = "PUBLIC"; 
 static String oracleUserName = "cmbeyers"; //replace with your Oracle account name
 static String password = "Clayton5"; //replace with your Oracle password
  
  public sqlDatabase() throws SQLException {
    super();
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
    } catch (InstantiationException e1) {
      e1.printStackTrace();
    } catch (IllegalAccessException e1) {
      e1.printStackTrace();
    } catch (ClassNotFoundException e1) {
      e1.printStackTrace();
    }
    oracleConnection = DriverManager.getConnection("jdbc:oracle:thin:@forktail.dsc.umich.edu:1521:COURSEDB", oracleUserName, password);
  }
  
  public void updateRegions(Vector<RegionPacket> regionPackets) {
    // Find the following information from your database and store the information as shown 
    try (Statement stmt = 
        oracleConnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                 ResultSet.CONCUR_READ_ONLY)) {
    //MAX LENGTH
    String updateQuery = "";
    stmt.executeQuery(updateQuery);
    stmt.close();
    } catch (SQLException err) {
    System.err.println(err.getMessage());
      }
  }
  public void updateFloors(Vector<FloorPacket> inputList) {
    // Find the following information from your database and store the information as shown 
    try (Statement stmt = 
        oracleConnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                 ResultSet.CONCUR_READ_ONLY)) {
    //MAX LENGTH
    String updateQuery = "";
    stmt.executeQuery(updateQuery);
    stmt.close();
    } catch (SQLException err) {
    System.err.println(err.getMessage());
      }
  }
  public void updateLibraries(Vector<LibraryPacket> libraryPackets) {
    // Find the following information from your database and store the information as shown 
    try (Statement stmt = 
        oracleConnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                 ResultSet.CONCUR_READ_ONLY)) {
    //MAX LENGTH
    String updateQuery = "";
    stmt.executeQuery(updateQuery);
    stmt.close();
    } catch (SQLException err) {
    System.err.println(err.getMessage());
      }
  }
}
