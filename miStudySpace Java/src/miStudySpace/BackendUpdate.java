package miStudySpace;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

import javax.swing.JOptionPane;


public class BackendUpdate {
  public Vector<RegionPacket> regionPackets;
  public Vector<FloorPacket> floorPackets;
  public Vector<LibraryPacket> libraryPackets;
  public Vector<HourStatPacket> hourStatPackets;
  public Timer timer;
  //Current attachment being loaded into db
  public File curAttachment;
  //Mapping of Access Point (AP) name to integer values
  public static HashMap<String, Integer> statMap;
  //All of the AP names seen so far
  public static Vector<String> APNames;
  //Reader for the emails
  public MailReader reader;
  public String[] floors;
  public Integer hourIndex; //This keeps the hour you are currently grabbing from in the attachment
  public Integer numIntervalsThisHour;
  public Integer libraryTotal;
  public Integer floorTotal;
  public Integer northTotal;
  public Integer centerTotal;
  public Integer southTotal;
  
  public BackendUpdate(){
    hourIndex = 0;
    numIntervalsThisHour = 0;
    APNames = new Vector<String>();
    statMap = new HashMap<String, Integer>();
    regionPackets = new Vector<RegionPacket>();
    floorPackets = new Vector<FloorPacket>();
    libraryPackets = new Vector<LibraryPacket>();
    hourStatPackets = new Vector<HourStatPacket>();
    reader = new MailReader();
  //Timer For AutoUpdate
    timer = new Timer();
    //timer.schedule(new AutoUpdate(), 900000); //900000 milliseconds = 15 mins
    //timer.schedule(new AutoUpdate(), 5000); //900000 milliseconds = 15 mins
    timer.scheduleAtFixedRate(new AutoUpdate(),(long) 0.1 ,30000 );
  }
  public void getShapiroStats(){
    regionPackets = new Vector<RegionPacket>();
    floorPackets = new Vector<FloorPacket>();
    libraryPackets = new Vector<LibraryPacket>();
    hourStatPackets = new Vector<HourStatPacket>();
    //System.out.println("Getting Stats for Floor:" + floor);
    String floorStr = null;
    for(Integer floor = 0; floor < 5; floor++){
      floorTotal = northTotal = southTotal = centerTotal = 0;
      if(floor == 0){
        floorStr = "-B";
      }
      if(floor == 1){
        floorStr = "-1";
      }
      if(floor == 2){
        floorStr = "-2";
      }
      if(floor == 3){
        floorStr = "-3";
      }
      if(floor == 4){
        floorStr = "-4";
      }
      libraryTotal = 0;
      for(String curName : APNames){
        if(curName.contains("UGLI")){libraryTotal +=statMap.get(curName);}
        if(curName.contains(floorStr)){ floorTotal +=statMap.get(curName);}
        if(curName.contains(floorStr) && curName.contains("-N")){ northTotal +=statMap.get(curName);}
        else if(curName.contains(floorStr) && curName.contains("-S")){ southTotal +=statMap.get(curName);}
        else if(curName.contains(floorStr) && curName.contains("-C")){ centerTotal +=statMap.get(curName);}
        ////////Special Cases
        if(floor == 0){ ///Basement Cases
          if(curName.contains("B174")){ northTotal +=statMap.get(curName);}
          else if(curName.contains("B136")){ centerTotal +=statMap.get(curName);}
        }
        else if(floor == 1){ //First Floor
          if(curName.contains("1152")){ northTotal +=statMap.get(curName);}
          else if(curName.contains("1136")){ centerTotal +=statMap.get(curName);}
          else if(curName.contains("1024")){ northTotal +=statMap.get(curName);}
          else if(curName.contains("1098")){ southTotal +=statMap.get(curName);}
        }
        else if(floor == 2){ //Second Floor
          if(curName.contains("2024")){ northTotal +=statMap.get(curName);}
          else if(curName.contains("2178")){ northTotal +=statMap.get(curName);}
          else if(curName.contains("2026")){ northTotal +=statMap.get(curName);}
          else if(curName.contains("2160")){ northTotal +=statMap.get(curName);}
          else if(curName.contains("2142")){ centerTotal +=statMap.get(curName);}
          else if(curName.contains("2054")){ centerTotal +=statMap.get(curName);}
          else if(curName.contains("2124")){ southTotal +=statMap.get(curName);}
        }
        else if(floor == 3){ //Second Floor
          if(curName.contains("3C14")){ northTotal +=statMap.get(curName);}
          else if(curName.contains("3002")){ northTotal +=statMap.get(curName);}
          else if(curName.contains("3026C-H")){ northTotal +=statMap.get(curName);}
          else if(curName.contains("3162")){ northTotal +=statMap.get(curName);}
          else if(curName.contains("3076-H")){ southTotal +=statMap.get(curName);}
        }
        else if(floor == 4){ //Second Floor
          if(curName.contains("4000")){ northTotal +=statMap.get(curName);}
          else if(curName.contains("4190")){ northTotal +=statMap.get(curName);}
          else if(curName.contains("4008")){ northTotal +=statMap.get(curName);}
          else if(curName.contains("4016")){ northTotal +=statMap.get(curName);}
          else if(curName.contains("4172")){ northTotal +=statMap.get(curName);}
          else if(curName.contains("4050")){ northTotal +=statMap.get(curName);}
          else if(curName.contains("4059-H")){ centerTotal +=statMap.get(curName);}
          else if(curName.contains("4100-W")){ southTotal +=statMap.get(curName);}
          else if(curName.contains("4100-E")){ southTotal +=statMap.get(curName);}
        }
        //End of Special Cases
      }
      if(floor == 0){
        southTotal+=20; //Adds 20 to account for computers
        floorTotal+=20;
      }
      if(floor == 3){
        if(southTotal > 32){
          floorTotal-=30;
          southTotal-=30;
        }
        if(northTotal > 42){
          floorTotal-=40;
          northTotal-=40;
        }
      }
      ///SET UP THE SQL PACKETS
      if(floor == 0){
        floorPackets.add(new FloorPacket("Shapiro","Basement",floorTotal));
        hourStatPackets.add(new HourStatPacket("Shapiro","Basement", floorTotal/219.0, hourIndex,numIntervalsThisHour));
        regionPackets.add(new RegionPacket("Shapiro","Basement", "North",northTotal));
        regionPackets.add(new RegionPacket("Shapiro","Basement", "Center",centerTotal));
        regionPackets.add(new RegionPacket("Shapiro","Basement", "South",southTotal));
      }
      else if(floor == 1){
        floorPackets.add(new FloorPacket("Shapiro","First",floorTotal));
        hourStatPackets.add(new HourStatPacket("Shapiro","First",floorTotal/404.0, hourIndex,numIntervalsThisHour));
        regionPackets.add(new RegionPacket("Shapiro","First", "North",northTotal));
        regionPackets.add(new RegionPacket("Shapiro","First", "Center",centerTotal));
        regionPackets.add(new RegionPacket("Shapiro","First", "South",southTotal));
      }
      else if(floor == 2){
        floorPackets.add(new FloorPacket("Shapiro","Second",floorTotal));
        hourStatPackets.add(new HourStatPacket("Shapiro","Second",floorTotal/342.0, hourIndex,numIntervalsThisHour));
        regionPackets.add(new RegionPacket("Shapiro","Second", "North",northTotal));
        regionPackets.add(new RegionPacket("Shapiro","Second", "Center",centerTotal));
        regionPackets.add(new RegionPacket("Shapiro","Second", "South",southTotal));
      }
      else if(floor == 3){
        floorPackets.add(new FloorPacket("Shapiro","Third",floorTotal));
        hourStatPackets.add(new HourStatPacket("Shapiro","Third",floorTotal/206.0, hourIndex,numIntervalsThisHour));
        regionPackets.add(new RegionPacket("Shapiro","Third", "North",northTotal));
        regionPackets.add(new RegionPacket("Shapiro","Third", "South",southTotal));
      }
      if(floor == 4){
        floorPackets.add(new FloorPacket("Shapiro","Fourth",floorTotal));
        hourStatPackets.add(new HourStatPacket("Shapiro","Fourth",floorTotal/228.0, hourIndex,numIntervalsThisHour));
        regionPackets.add(new RegionPacket("Shapiro","Fourth", "North",northTotal));
        regionPackets.add(new RegionPacket("Shapiro","Fourth", "Center",centerTotal));
        regionPackets.add(new RegionPacket("Shapiro","Fourth", "South",southTotal));
      }
      System.out.println("Floor:"+floor+" Floor:"+floorTotal+" North:"+northTotal+" Center:"+centerTotal+" South:"+southTotal);
    }
    libraryPackets.addElement(new LibraryPacket("Shapiro", libraryTotal));
    MiStudySpaceRunnable.db.updateFloors(floorPackets);
    MiStudySpaceRunnable.db.updateLibraries(libraryPackets);
    MiStudySpaceRunnable.db.updateRegions(regionPackets);
    MiStudySpaceRunnable.db.updateHourlyStats(hourStatPackets);

  }
  public void getData(File inFile){
    
    //String dataFileName = "fill";
    BufferedReader br = null;
    try {
      br = new BufferedReader(new FileReader(inFile));
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      JOptionPane.showConfirmDialog(null, "Data File Not Found on Update", 
          "Tester", JOptionPane.OK_CANCEL_OPTION);
      e.printStackTrace();
    }
    String line = null;
    String uniqueUsers = null;
    String multipleAP = null;
    String timeStamp= null;
    int count = 0;
    try {
      br.readLine();//Date
      timeStamp = br.readLine();//Time
      br.readLine();//Blank
      br.readLine();//Total Devices
      uniqueUsers = br.readLine(); // Unique Users
      multipleAP = br.readLine(); //Multiple AP users
      br.readLine();//Skips empty line
      
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    //GRAB THE TIMESTAMP
    String hourString = null;
    //Move past the word date
    timeStamp = timeStamp.substring(timeStamp.indexOf(":")+1);
    timeStamp=timeStamp.trim();
    hourString = timeStamp.substring(0, timeStamp.indexOf(":")).trim();
    if(Integer.parseInt(hourString) == hourIndex){
      numIntervalsThisHour++;
    }
    else{
      numIntervalsThisHour=1;
      hourIndex = Integer.parseInt(hourString);
    }
    ////
    while(uniqueUsers.charAt(count) != ':' && count < uniqueUsers.length()){count++;}
    count+=2; // Moves past space
    Integer totalUsers = Integer.parseInt(uniqueUsers.substring(count));
    count = 0;
    while(multipleAP.charAt(count) != ':' && count < multipleAP.length()){count++;}
    count+=2;
    totalUsers -= Integer.parseInt(multipleAP.substring(count));
    //JOptionPane.showConfirmDialog(null, "Unique User String: " + uniqueUsers + "\n" + "Multiple AP String:" + multipleAP, 
        //"Tester", JOptionPane.OK_CANCEL_OPTION);
    

    try {
      while ((line = br.readLine()) != null) {
        //JOptionPane.showConfirmDialog(null, "Line: " + line, 
            //"Tester", JOptionPane.OK_CANCEL_OPTION);
        count = 1;//Skips initial "
        while(line.charAt(count) != '"' && count < line.length()){count++;}
        String name = line.substring(1, count);
        String stat = line.substring(count + 2);
        if(!statMap.containsKey(name)){
          APNames.addElement(name); 
        }
        statMap.put(name, Integer.parseInt(stat));
      }
    } catch (NumberFormatException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    try {
      br.close();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  public void getTextFile(){
    /*
    Message temp = reader.getMessage();
    curAttachment = reader.getAttachment(temp);
    */
    curAttachment = reader.getAttachment();
  }
  public void updateSQLDB(){
    getShapiroStats();
  }
  public static void updateAP(String name, String stat){
    if(!statMap.containsKey(name)){
      //System.out.println("Adding to Vector: " + name);
      APNames.addElement(name);
    }
    statMap.put(name, Integer.parseInt(stat));
  }
  class AutoUpdate extends TimerTask {
    public void run() {
      System.out.println("Performing Update!");
      if(reader.checkUpdateAvailability()){
        getTextFile();
        //curAttachment = new File("C:\\Users\\Clay\\Documents\\Senior Year\\UC 270\\src\\StudySpace\\uglifinal.txt");
        if(curAttachment!=null){
          getData(curAttachment);
          updateSQLDB();
        }
      }
      else{
      }
      //timer.cancel(); //Not necessary because we call System.exit
      //System.exit(0); //Stops the AWT thread (and everything else)
    }
  }
}
