package miStudySpace;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class sqlDatabase {
//You must use the following variable as the JDBC connection
 Connection mysqlConnection = null;
  public sqlDatabase() {
    super();
    if(!dbConnector()){
      System.out.println("Database connection failed");
    }
  }
  public boolean dbConnector(){
    try {
      // Load the JDBC driver
      Class.forName("com.mysql.jdbc.Driver").newInstance();
      // Create a connection to the database
      mysqlConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/miStudySpace?user=root&password=studyspace441");
  } catch (ClassNotFoundException e) {
      // Could not find the database driver
      System.out.println("ClassNotFoundException : "+e.getMessage());
      return false;
  } catch (SQLException e) {
      // Could not connect to the database
      System.out.println(e.getMessage());
      return false;
  } catch (InstantiationException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
  } catch (IllegalAccessException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
  }
    return true;
}
  
  public void updateRegions(Vector<RegionPacket> regionPackets) {
    // Find the following information from your database and store the information as shown 
    try (Statement stmt = 
        mysqlConnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                 ResultSet.CONCUR_READ_ONLY)) {
      String updateQuery = "";
      for(RegionPacket reg : regionPackets){
        updateQuery = "UPDATE Regions reg SET current_occupancy = "+reg.currentOccupancy+" where reg.region_name = '"+reg.regionName+"' and reg.floor_name = '"+reg.floorName+"' and reg.library_name = '"+reg.libraryName+"'";
        stmt.executeUpdate(updateQuery);
      }
    stmt.close();
    } catch (SQLException err) {
    System.err.println(err.getMessage());
      }
  }
  public void updateFloors(Vector<FloorPacket> floorPackets) {
    // Find the following information from your database and store the information as shown 
    try (Statement stmt = 
        mysqlConnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                 ResultSet.CONCUR_READ_ONLY)) {
      String updateQuery = "";
      for(FloorPacket flo : floorPackets){
        updateQuery = "UPDATE Floors floor SET current_occupancy = "+flo.currentOccupancy+" where floor.floor_name = '"+flo.floorName+"' and floor.library_name = '"+flo.libraryName+"'";
        stmt.executeUpdate(updateQuery);
      }
    stmt.close();
    } catch (SQLException err) {
    System.err.println(err.getMessage());
      }
  }
  public void updateLibraries(Vector<LibraryPacket> libraryPackets) {
    // Find the following information from your database and store the information as shown 
    try (Statement stmt = 
        mysqlConnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                 ResultSet.CONCUR_READ_ONLY)) {
    String updateQuery = "";
    for(LibraryPacket lib : libraryPackets){
      updateQuery = "UPDATE Libraries lib SET current_occupancy =  "+lib.currentOccupancy+" where lib.library_name = '"+lib.libraryName+"'";
      stmt.executeUpdate(updateQuery);
    }
    stmt.close();
    } catch (SQLException err) {
    System.err.println(err.getMessage());
      }
  }
  public void updateHourlyStats(Vector<HourStatPacket> hourPackets) {
    // Find the following information from your database and store the information as shown 
    try (Statement stmt = 
        mysqlConnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                 ResultSet.CONCUR_READ_ONLY)) {
      Statement stmt2 = 
          mysqlConnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                   ResultSet.CONCUR_READ_ONLY);
      String updateQuery = "";
      String selectQuery = "";
      ResultSet rst;
      rst = stmt.executeQuery("select * from Libraries");
      for(HourStatPacket hour : hourPackets){
        //Grab the data you are trying to update
        rst = stmt.executeQuery("select H.fill_average from Hour_Average H where H.library_name ='" + hour.libraryName + "' and H.floor_name= '" + hour.floorName + "' and H.hour='"+ hour.hourIndex.toString()+"'");
        while(rst.next()) {
          Float avg = rst.getFloat(1);
          //Compute the new average factoring in the value
          avg = (float) ((avg * (hour.numIntervals - 1) + hour.floorFillPercentage)/hour.numIntervals);
          //Place the value back in the database factoring in this hour
          updateQuery = "UPDATE Hour_Average H SET fill_average = "+avg+" where H.library_name ='" + hour.libraryName + "' and H.floor_name='" + hour.floorName + "' and H.hour='"+ hour.hourIndex.toString()+"'";
          stmt2.executeUpdate(updateQuery);
      }
      }
      rst.close();
    stmt.close();
    stmt.close();
    } catch (SQLException err) {
    System.err.println(err.getMessage());
      }
  }
}
