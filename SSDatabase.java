package StudySpace;
import java.awt.List;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.mongodb.*;



public class SSDatabase {

    // variables for connecting to database
    private static MongoClientURI uri;
    private static MongoClient client;
    private static DB db;    
    public static DBCollection APs;
    public static DBCollection libraries;
    public static DBCollection Areas;
    public static DBCollection Clients;

    //mongodb://StudySpace:UC270008@mongolab.com:53160/StudySpace
    // initializes connection to database
    public static void init() {
      uri = new MongoClientURI("mongodb://cbeyers:Clayton5@ds053668.mongolab.com:53668/studyspace_db"); 
      try{ 
        client = new MongoClient(uri);
      } catch (UnknownHostException e) {
        System.out.println("Connection to database failed!");
      }
      db = client.getDB(uri.getDatabase());
      APs = db.getCollection("Name");
      Clients = db.getCollection("Clients");

      
    }
    //Updates the stats of routers
    //nameVector = vector of all AP names from input file
    //AP_names - mapping of integer to nameVector entry
    public static void updateStats(Vector<String> nameVector, HashMap<String, Integer> AP_names) {
      //.put("foo", new Integer(3));
      for(int i = 0; i < nameVector.size(); ++i){
        //JOptionPane.showConfirmDialog(null, "Name of AP: " + nameVector.elementAt(i), 
            //"Tester", JOptionPane.OK_CANCEL_OPTION);
        BasicDBObject AP_query = new BasicDBObject("Name", nameVector.elementAt(i));
        DBCursor find_AP = APs.find(AP_query);
        //JOptionPane.showConfirmDialog(null, "Found Count: " + find_AP.count(), 
            //"Tester", JOptionPane.OK_CANCEL_OPTION);
        if(find_AP.count() <= 0){ // Not found in DB, add
            BasicDBObject new_AP = new BasicDBObject();
            new_AP.put("Name", nameVector.elementAt(i));
            new_AP.put("Clients", AP_names.get(nameVector.elementAt(i)));//Update with stats
            APs.insert(new_AP);
        }
        else{ //Updates the score
          DBObject curAP = find_AP.next();
          BasicDBObject new_AP = new BasicDBObject();
          new_AP.put("Name", nameVector.elementAt(i));
          new_AP.put("Clients", AP_names.get(nameVector.elementAt(i)));
          APs.findAndModify(curAP, new_AP);
          //APs.remove(curAP);
          //curAP.put("Clients", AP_names.get(nameVector.elementAt(i)));
          //APs.insert(curAP);
        //JOptionPane.showConfirmDialog(null, "Updating AP: " + nameVector.elementAt(i) +
            //" \n With Value: " + AP_names.get(nameVector.elementAt(i)), 
          //"Tester", JOptionPane.OK_CANCEL_OPTION);
        }
      }
      
    }
    public static void updateLibrary(String library, Integer capacity, Integer maxCapacity, String color){
      BasicDBObject Library_query = new BasicDBObject("Library", library);
      DBCursor find_Library = libraries.find(Library_query);
      if(find_Library.count() <= 0){ // Not found in DB, add
        BasicDBObject new_Library = new BasicDBObject();
        new_Library.put("Name", library);
        new_Library.put("Clients", capacity);//Update with stats
        new_Library.put("Clients_Max", maxCapacity);
        new_Library.put("status_Color", color);
        libraries.insert(new_Library);
    }
    else{ //Updates the score
      DBObject curAP = find_Library.next();
      BasicDBObject new_Library = new BasicDBObject();
      new_Library.put("Name", library);
      new_Library.put("Clients", capacity);//Update with stats
      new_Library.put("Clients_Max", maxCapacity);
      new_Library.put("status_Color", color);
      libraries.insert(new_Library);
    }
    }
    public static void updateFloor(String library,String floor, int curOccupancy, int totalOccupancy){
      
    }
    public static void updateArea(String library,String floor, String region, int curOccupancy, int totalOccupancy, String statusColor) {
      BasicDBObject Area_query = new BasicDBObject("Area", region);
      Area_query.append("Floor", floor);
      Area_query.append("Library", library);
      DBCursor find_Area = Areas.find(Area_query);
      if(find_Area.count() <= 0){ // Not found in DB, add
        BasicDBObject new_Area = new BasicDBObject();
        new_Area.put("Library", library);
        new_Area.put("Area", region);
        new_Area.put("Floor", floor);
        new_Area.put("Occupancy", curOccupancy);
        new_Area.put("MaxOccupancy", totalOccupancy);
        new_Area.put("StatusColor", statusColor);
        Areas.insert(new_Area);
      }
      else{
        DBObject curArea = find_Area.next();
        BasicDBObject update_Area = new BasicDBObject();
        update_Area.put("Library", library);
        update_Area.put("Floor", floor);
        update_Area.put("Region", region);
        update_Area.put("Occupancy", curOccupancy);
        update_Area.put("MaxOccupancy", totalOccupancy);
        update_Area.put("StatusColor", statusColor);
        Areas.findAndModify(curArea, update_Area);
      }
    }
    //0-basement 1-first 
    public static void updateMap(){
      DBCursor find_APs = APs.find();
      
      while(find_APs.hasNext()) {
        DBObject AP = find_APs.next();
        HomeScreen.updateAP(AP.get("Name").toString(), AP.get("Clients").toString());
    }
    }
    
    // closes the connection to the database
    public static void closeConnection() {
      client.close();
    }
    
  }

    

    
