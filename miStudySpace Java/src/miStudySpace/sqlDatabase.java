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
  
 
 String  driverName ="oracle.jdbc.driver.OracleDriver"; // for Oracle
 // String driverName = “com.mysql.jdbc.Driver”; //for MySql
 String serverName = "localhost"; // Use this server.
 String portNumber = "1521";
 String sid = "orcl";
 String url="jdbc:oracle:thin:@"+serverName+":"+ portNumber+":"+sid; // for Oracle
  public sqlDatabase() {
    super();
    if(!dbConnector()){
      System.out.println("Database connection failed");
    }
  }
  public boolean dbConnector(){
    try {
      // Load the JDBC driver
       Class.forName(driverName);
      // Create a connection to the database
      oracleConnection = DriverManager.getConnection(url, oracleUserName, password);
  } catch (ClassNotFoundException e) {
      // Could not find the database driver
      System.out.println("ClassNotFoundException : "+e.getMessage());
      return false;
  } catch (SQLException e) {
      // Could not connect to the database
      System.out.println(e.getMessage());
      return false;
  }
    return true;
}
  
  public void updateRegions(Vector<RegionPacket> regionPackets) {
    // Find the following information from your database and store the information as shown 
    try (Statement stmt = 
        oracleConnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                 ResultSet.CONCUR_READ_ONLY)) {
      String updateQuery = "";
      for(RegionPacket reg : regionPackets){
        updateQuery = "UPDATE regions reg SET (current_occupancy) = "+reg.currentOccupancy+" where reg.region_name = "+reg.regionName+" and reg.floor_name = "+reg.floorName+" and reg.library_name = "+reg.libraryName;
        stmt.executeQuery(updateQuery);
      }
    stmt.close();
    } catch (SQLException err) {
    System.err.println(err.getMessage());
      }
  }
  public void updateFloors(Vector<FloorPacket> floorPackets) {
    // Find the following information from your database and store the information as shown 
    try (Statement stmt = 
        oracleConnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                 ResultSet.CONCUR_READ_ONLY)) {
      String updateQuery = "";
      for(FloorPacket flo : floorPackets){
        updateQuery = "floors floor SET (current_occupancy) = "+flo.currentOccupancy+" where floor.floor_name = "+flo.floorName+" and floor.library_name = "+flo.libraryName;
        stmt.executeQuery(updateQuery);
      }
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
    String updateQuery = "";
    for(LibraryPacket lib : libraryPackets){
      updateQuery = "UPDATE libraries lib SET (current_occupancy) =  "+lib.currentOccupancy+" where lib.library_name = "+lib.libraryName;
      stmt.executeQuery(updateQuery);
    }
    stmt.close();
    } catch (SQLException err) {
    System.err.println(err.getMessage());
      }
  }
}
