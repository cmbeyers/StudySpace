package miStudySpace;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

import javax.mail.Message;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;


public class HomeScreen extends JFrame {
  public JComboBox buildingSelector;
  public JComboBox floorSelector;
  public JLabel floorImage;
  public JMenu fileMenu;
  public JMenu editMenu;
  public JMenuItem EXIT;
  public JButton suggestion;
  public JButton updateButton;
  public JLabel suggestionLabel;
  //Table Headers
  public JLabel totalLabel;
  public JLabel statusLabel;
  public JLabel intLabel;
  ///Total People in region
  public JLabel libraryTotalLabel;
  public JLabel floorTotalLabel;
  public JLabel northTotalLabel;
  public JLabel southTotalLabel;
  public JLabel centerTotalLabel;
  ////Status color box
  public JLabel libraryStatus;
  public JLabel floorStatus;
  public JLabel northStatus;
  public JLabel southStatus;
  public JLabel centerStatus;
  ///Integer representation of occupancy level
  public JLabel libraryStatusInt;
  public JLabel floorStatusInt;
  public JLabel northStatusInt;
  public JLabel southStatusInt;
  public JLabel centerStatusInt;
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
  //Integers values updated for display, pair with integer labels
  public Integer libraryTotal;
  public Integer floorTotal;
  public Integer northTotal;
  public Integer centerTotal;
  public Integer southTotal;
  public String[] floors;
  public Integer hourIndex; //This keeps the hour you are currently grabbing from in the attachment
  public Integer numIntervalsThisHour; //This is the number of 5 minute intervals you have grabbed for this hour, use for avg
  //Listener primarily used for floor selection
  private Listener hush;
  

  /**
   * Create the applet.
   */
  public HomeScreen() {
    JPanel screenPanel = new JPanel(new FlowLayout());
    //screenPanel.setBackground(new Color(120,135,171));
    hush = new Listener();
    hourIndex = 0;
    numIntervalsThisHour = 0;
    
    
    //Vector<String> AP_names;
    APNames = new Vector<String>();
    statMap = new HashMap<String, Integer>();
    regionPackets = new Vector<RegionPacket>();
    floorPackets = new Vector<FloorPacket>();
    libraryPackets = new Vector<LibraryPacket>();
    hourStatPackets = new Vector<HourStatPacket>();
    reader = new MailReader();
    
    String[] buildings = { "Shapiro Undergrad Library", "Hatcher Graduate Library", "Duderstadt" };
    //String[] floors = { "Select your building First"};
    String[] floors = { "Basement", "First Floor", "Second Floor", "Third Floor", "Fourth Floor" };

    buildingSelector = new JComboBox(buildings); //If selected, add item to vehicleList
    floorSelector = new JComboBox(floors);
    buildingSelector.setSelectedIndex(0);
    floorSelector.setSelectedIndex(0);
    floorSelector.addActionListener(hush);
    buildingSelector.addActionListener(hush);
    
    JPanel guidePane = new JPanel(new GridLayout(4,2));
    JLabel colorLabel = new JLabel("Color");
    colorLabel.setHorizontalAlignment(JLabel.CENTER);
    JLabel rep = new JLabel("Status");
    rep.setHorizontalAlignment(JLabel.CENTER);
    guidePane.add(colorLabel);
    guidePane.add(rep);
    JLabel greenLabel = new JLabel(" ");
    greenLabel.setOpaque(true);
    greenLabel.setBackground(Color.GREEN);
    JLabel greenRep = new JLabel("Available");
    greenRep.setHorizontalAlignment(JLabel.CENTER);
    guidePane.add(greenLabel);
    guidePane.add(greenRep);
    JLabel yellowLabel = new JLabel(" ");
    yellowLabel.setOpaque(true);
    yellowLabel.setBackground(Color.YELLOW);
    JLabel yellowRep = new JLabel("Moderate");
    yellowRep.setHorizontalAlignment(JLabel.CENTER);
    guidePane.add(yellowLabel);
    guidePane.add(yellowRep);
    JLabel redLabel = new JLabel(" ");
    redLabel.setOpaque(true);
    redLabel.setBackground(Color.RED);
    JLabel redRep = new JLabel("Stay Away");
    redRep.setHorizontalAlignment(JLabel.CENTER);
    guidePane.add(redLabel);
    guidePane.add(redRep);
    JPanel leftFlow = new JPanel(new GridLayout(2,1));
    
    JPanel selectionPane = new JPanel(new GridLayout(3,0));
    JPanel updatePane = new JPanel(new GridLayout(1,0));
    //selectionPane.add(guidePane);
    selectionPane.add(new JLabel("Choose Your Building"));
    selectionPane.add(buildingSelector);
    selectionPane.add(new JLabel("Choose Your Floor"));
    selectionPane.add(floorSelector);
    suggestion = new JButton("Send Suggestion");
    suggestionLabel = new JLabel("Don't see your desired location?");
    JPanel suggestionPanel = new JPanel(new GridLayout(2,1));
    suggestionPanel.add(suggestionLabel);
    suggestionPanel.add(suggestion);
    suggestion.addActionListener(hush);
    //updateButton = new JButton("Update Statistics");
    //updateButton.addActionListener(hush);
    //updatePane.add(updateButton);
    //suggestionPanel.add(updateButton);
    //Set up the status bar for the floor
    JPanel statusPanel = new JPanel(new GridLayout(6,3));
    totalLabel = new JLabel("Area");
    totalLabel.setHorizontalAlignment(JLabel.CENTER);
    //statusLabel = new JLabel("Status: Green(Open), Yellow(Moderate), Red(Stay Away)");
    statusLabel = new JLabel("Status");
    statusLabel.setHorizontalAlignment(JLabel.CENTER);
    intLabel = new JLabel("Current People / Max Capacity");
    intLabel.setHorizontalAlignment(JLabel.CENTER);
    statusPanel.add(totalLabel);
    statusPanel.add(intLabel);
    statusPanel.add(statusLabel);
    libraryTotalLabel = new JLabel("People in Ugli Currently");
    libraryTotalLabel.setHorizontalAlignment(JLabel.CENTER);
    libraryStatus = new JLabel(" ");
    libraryStatus.setOpaque(true);
    libraryStatus.setBackground(Color.GREEN);
    libraryStatusInt = new JLabel("Unavailable");
    libraryStatusInt.setHorizontalAlignment(JLabel.CENTER);
    statusPanel.add(libraryTotalLabel);
    statusPanel.add(libraryStatusInt);
    statusPanel.add(libraryStatus);
    floorTotalLabel = new JLabel("People on Floor");
    floorTotalLabel.setHorizontalAlignment(JLabel.CENTER);
    floorStatus = new JLabel(" ");
    floorStatus.setOpaque(true);
    floorStatus.setBackground(Color.LIGHT_GRAY);
    floorStatusInt = new JLabel("Unavailable");
    floorStatusInt.setHorizontalAlignment(JLabel.CENTER);
    statusPanel.add(floorTotalLabel);
    statusPanel.add(floorStatusInt);
    statusPanel.add(floorStatus);
    northTotalLabel = new JLabel("People in north region");
    northTotalLabel.setHorizontalAlignment(JLabel.CENTER);
    northStatus = new JLabel(" ");
    northStatus.setOpaque(true);
    northStatus.setBackground(Color.LIGHT_GRAY);
    northStatusInt = new JLabel("Unavailable");
    northStatusInt.setHorizontalAlignment(JLabel.CENTER);
    statusPanel.add(northTotalLabel);
    statusPanel.add(northStatusInt);
    statusPanel.add(northStatus);
    centerTotalLabel = new JLabel("People in center region");
    centerTotalLabel.setHorizontalAlignment(JLabel.CENTER);
    centerStatus = new JLabel(" ");
    centerStatus.setOpaque(true);
    centerStatus.setBackground(Color.LIGHT_GRAY);
    centerStatusInt = new JLabel("Unavailable");
    centerStatusInt.setHorizontalAlignment(JLabel.CENTER);
    statusPanel.add(centerTotalLabel);
    statusPanel.add(centerStatusInt);
    statusPanel.add(centerStatus);
    southTotalLabel = new JLabel("People in south region");
    southTotalLabel.setHorizontalAlignment(JLabel.CENTER);
    southStatus = new JLabel(" ");
    southStatus.setOpaque(true);
    southStatus.setBackground(Color.LIGHT_GRAY);
    southStatusInt = new JLabel("Unavailable");
    southStatusInt.setHorizontalAlignment(JLabel.CENTER);
    statusPanel.add(southTotalLabel);
    statusPanel.add(southStatusInt);
    statusPanel.add(southStatus);
    
    
    Border border = LineBorder.createBlackLineBorder();
    floorStatus.setBorder(border);
    centerStatus.setBorder(border);
    northStatus.setBorder(border);
    southStatus.setBorder(border);
    libraryStatus.setBorder(border);
    
    //Timer For AutoUpdate
    timer = new Timer();
    //timer.schedule(new AutoUpdate(), 900000); //900000 milliseconds = 15 mins
    //timer.schedule(new AutoUpdate(), 5000); //900000 milliseconds = 15 mins
    timer.scheduleAtFixedRate(new AutoUpdate(),(long) 0.1 ,30000 );
    
    
    ///Set up the main panel for the window
    JLabel title = new JLabel("Welcome to StudySpace!");

    title.setFont(new Font("Serif", Font.BOLD, 72));
    title.setBackground(Color.YELLOW);
    title.setOpaque(true);
    title.setSize(600, 600);
    screenPanel.add(title);
    screenPanel.add(suggestionPanel, "South");
    screenPanel.add(statusPanel, "East");
    
    
    //floorImage = new JLabel("Choose Your Parameters");
    //floorImage.setSize(750, 750);
    
    ClassLoader image_load = getClass().getClassLoader();
    URL imageURL = image_load.getResource("StudySpace/Ugli_Bsmall.png");
    //URL imageURL = image_load.getResource("https://www.osha.gov/doc/engineering/images/2012_r_03/2012_r_03_fig02.jpg");
    
    ImageIcon wizard = new ImageIcon(imageURL);
    //int imageColor = 0; //0 = red 1 = yellow 2 = green
    //changeColor(wizard, imageColor);
    //floorImage = new JLabel(wizard);
    floorImage = new JLabel();
    floorImage.setIcon(wizard);
    //For Clicking On Image
    floorImage.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
         JFrame jf=new JFrame("Floor Image");
      jf.setBackground(Color.BLACK);
      jf.setSize(new Dimension(500,700));
      ClassLoader image_load = getClass().getClassLoader();
      URL imageURL = image_load.getResource("StudySpace/Ugli_Bsmall.png");
      ImageIcon temp = (ImageIcon) floorImage.getIcon();
      Image img = temp.getImage();
      Image newimg = img.getScaledInstance(375, 600,  java.awt.Image.SCALE_SMOOTH);
      ImageIcon newIcon = new ImageIcon(newimg);
      //floorImage.setIcon(wizard);
      //floorImage.setSize(400, 600);
      JLabel temp1 = new JLabel();
      temp1.setIcon(newIcon);
      jf.add(temp1);
      jf.setVisible(true);
      //jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
      }
  });
    
    leftFlow.add(guidePane);
    leftFlow.add(selectionPane);
    //screenPanel.add(selectionPane, "East");
    screenPanel.add(leftFlow, "East");
    screenPanel.add(floorImage, "West");

    screenPanel.setBorder(new EmptyBorder(40, 40, 40, 40));
    screenPanel.setBackground(new Color(120,135,171));

    //this.add(new JLabel(wizard), "North");
    
    
    /////MENU///////////
    JMenuBar menu = new JMenuBar();
    
    // build the File menu
    fileMenu = new JMenu("File");
    JMenuItem fill1 = new JMenuItem("Fill 1");
    JMenuItem fill2 = new JMenuItem("Fill 2");
    JMenuItem fill3 = new JMenuItem("Fill 3");
    JMenuItem fill4 = new JMenuItem("Fill 4");
    JMenuItem fill5 = new JMenuItem("Fill 5");
    JMenuItem EXIT = new JMenuItem("Exit Interface");
    fill1.addActionListener(hush);
    fill2.addActionListener(hush);
    fill3.addActionListener(hush);
    fill4.addActionListener(hush);
    fill5.addActionListener(hush);
    EXIT.addActionListener(hush);
    fileMenu.add(fill1);
    fileMenu.add(fill2);
    fileMenu.add(fill3);
    fileMenu.add(fill4);
    fileMenu.add(fill5);
    fileMenu.add(EXIT);

 
    // build the Edit menu
    editMenu = new JMenu("Edit");
    //addVehicle = new JMenuItem("Add Vehicle");
    //addParcel = new JMenuItem("Add Parcel");
    
    editMenu.add(fill1);
    editMenu.add(EXIT);
    menu.add(fileMenu);
    menu.add(editMenu);
    setJMenuBar(menu);
    screenPanel.setBackground(Color.BLUE);
    //floorSelector.setEnabled(false);
    getContentPane().add(screenPanel);
    
    
    this.setSize(1000,800);
    updateGUI();
    //getTextFile();
    //curAttachment = new File("C:\\Users\\Clay\\Documents\\Senior Year\\UC 270\\src\\StudySpace\\uglifinal.txt");
    //if(curAttachment!=null)
      //getData(curAttachment);
    //performUpdate();
 
  }
  public void setStatusColor(Integer capacity, Integer floor, String region){
    Double fillRatio =0.0;
    Double floorFillRatio =0.0;
    switch (floor){
    case 0:
      switch (region){
      case "All":
        floorFillRatio = capacity/219.0;//Random
        if(floorFillRatio <= .33){floorStatus.setBackground(Color.GREEN);}
        else if(floorFillRatio <= .66){floorStatus.setBackground(Color.YELLOW);}
        else if(floorFillRatio <= 1 && floorFillRatio > .66){floorStatus.setBackground(Color.RED);}
        else{floorStatus.setBackground(Color.RED);}
        break;
      case "North":
        fillRatio = capacity/59.0;//Random
        if(fillRatio <= .33){northStatus.setBackground(Color.GREEN);}
        else if(fillRatio <= .66){northStatus.setBackground(Color.YELLOW);}
        else if(fillRatio <= 1 && fillRatio > .66){northStatus.setBackground(Color.RED);}
        else{northStatus.setBackground(Color.RED);}
        break;
      case "South":
        fillRatio = capacity/49.0;//Random
        if(fillRatio <= .33){southStatus.setBackground(Color.GREEN);}
        else if(fillRatio <= .66){southStatus.setBackground(Color.YELLOW);}
        else if(fillRatio <= 1 && fillRatio > .66){southStatus.setBackground(Color.RED);}
        else{southStatus.setBackground(Color.RED);}
        break;
      case "Center":
        fillRatio = capacity/110.0;//Random
        centerStatus.setText(" ");
        if(fillRatio <= .33){centerStatus.setBackground(Color.GREEN);}
        else if(fillRatio <= .66){centerStatus.setBackground(Color.YELLOW);}
        else if(fillRatio <= 1 && fillRatio > .66){centerStatus.setBackground(Color.RED);}
        else{centerStatus.setBackground(Color.RED);}
        break;
      }
      break; ///Basement
      case 1:
        switch (region){
        case "All":
          floorFillRatio = capacity/404.0;//Random
          if(floorFillRatio <= .33){floorStatus.setBackground(Color.GREEN);}
          else if(floorFillRatio <= .66){floorStatus.setBackground(Color.YELLOW);}
          else if(floorFillRatio <= 1 && floorFillRatio > .66){floorStatus.setBackground(Color.RED);}
          else{floorStatus.setBackground(Color.RED);}
          break;
        case "North":
          fillRatio = capacity/156.0;//Random
          if(fillRatio <= .33){northStatus.setBackground(Color.GREEN);}
          else if(fillRatio <= .66  && fillRatio > .33){northStatus.setBackground(Color.YELLOW);}
          else if(fillRatio <= 1 && fillRatio > .66){northStatus.setBackground(Color.RED);}
          else{northStatus.setBackground(Color.RED);}
          break;
        case "South":
          fillRatio = capacity/90.0;//Random
          if(fillRatio <= .33){southStatus.setBackground(Color.GREEN);}
          else if(fillRatio <= .66){southStatus.setBackground(Color.YELLOW);}
          else if(fillRatio <= 1 && fillRatio > .66){southStatus.setBackground(Color.RED);}
          else{southStatus.setBackground(Color.RED);}
          break;
        case "Center":
          fillRatio = capacity/158.0;//Random
          centerStatus.setText(" ");
          if(fillRatio <= .33){centerStatus.setBackground(Color.GREEN);}
          else if(fillRatio <= .66){centerStatus.setBackground(Color.YELLOW);}
          else if(fillRatio <= 1 && fillRatio > .66){centerStatus.setBackground(Color.RED);}
          else{centerStatus.setBackground(Color.RED);}
          break;
        }
        break;//First Floor End
        case 2:
          switch (region){
          case "All":
            floorFillRatio = capacity/342.0;//Random
            if(floorFillRatio <= .33){floorStatus.setBackground(Color.GREEN);}
            else if(floorFillRatio <= .66){floorStatus.setBackground(Color.YELLOW);}
            else if(floorFillRatio <= 1 && floorFillRatio > .66){floorStatus.setBackground(Color.RED);}
            else{floorStatus.setBackground(Color.RED);}
            break;
          case "North":
            fillRatio = capacity/79.0;//Random
            if(fillRatio <= .33){northStatus.setBackground(Color.GREEN);}
            else if(fillRatio <= .66){northStatus.setBackground(Color.YELLOW);}
            else if(fillRatio <= 1 && fillRatio > .66){northStatus.setBackground(Color.RED);}
            else{northStatus.setBackground(Color.RED);}
            break;
          case "South":
            fillRatio = capacity/125.0;//Random
            if(fillRatio <= .33){southStatus.setBackground(Color.GREEN);}
            else if(fillRatio <= .66){southStatus.setBackground(Color.YELLOW);}
            else if(fillRatio <= 1 && fillRatio > .66){southStatus.setBackground(Color.RED);}
            else{southStatus.setBackground(Color.RED);}
            break;
          case "Center":
            fillRatio = capacity/138.0;//Random
            centerStatus.setText(" ");
            if(fillRatio <= .33){centerStatus.setBackground(Color.GREEN);}
            else if(fillRatio <= .66){centerStatus.setBackground(Color.YELLOW);}
            else if(fillRatio <= 1 && fillRatio > .66){centerStatus.setBackground(Color.RED);}
            else{centerStatus.setBackground(Color.RED);}
            break;
          }
          break;//Second Floor End
          case 3:
            switch (region){
            case "All":
              floorFillRatio = capacity/206.0;//Random
              if(floorFillRatio <= .33){floorStatus.setBackground(Color.GREEN);}
              else if(floorFillRatio <= .66){floorStatus.setBackground(Color.YELLOW);}
              else if(floorFillRatio <= 1 && floorFillRatio > .66){floorStatus.setBackground(Color.RED);}
              else{floorStatus.setBackground(Color.RED);}
              break;
            case "North":
              fillRatio = capacity/139.0;//Random
              if(fillRatio <= .33){northStatus.setBackground(Color.GREEN);}
              else if(fillRatio <= .66){northStatus.setBackground(Color.YELLOW);}
              else if(fillRatio <= 1 && fillRatio > .66){northStatus.setBackground(Color.RED);}
              else{northStatus.setBackground(Color.RED);}
              break;
            case "South":
              fillRatio = capacity/67.0;//Random
              if(fillRatio <= .33){southStatus.setBackground(Color.GREEN);}
              else if(fillRatio <= .66){southStatus.setBackground(Color.YELLOW);}
              else if(fillRatio <= 1 && fillRatio > .66){southStatus.setBackground(Color.RED);}
              else{southStatus.setBackground(Color.RED);}
              break;
            case "Center":
              centerStatus.setText("No Center Region");
              centerStatus.setBackground(Color.LIGHT_GRAY);
              break;
            }
            break; //Third Floor
            case 4:
              switch (region){
              case "All":
                floorFillRatio = capacity/228.0;//Random
                if(floorFillRatio <= .33){floorStatus.setBackground(Color.GREEN);}
                else if(floorFillRatio <= .66){floorStatus.setBackground(Color.YELLOW);}
                else if(floorFillRatio <= 1 && floorFillRatio > .66){floorStatus.setBackground(Color.RED);}
                else{floorStatus.setBackground(Color.RED);}
                break;
              case "North":
                fillRatio = capacity/74.0;//Random
                if(fillRatio <= .33){northStatus.setBackground(Color.GREEN);}
                else if(fillRatio <= .66 && fillRatio > .33){northStatus.setBackground(Color.YELLOW);}
                else if(fillRatio <= 1 && fillRatio > .66){northStatus.setBackground(Color.RED);}
                else{northStatus.setBackground(Color.RED);}
                break;
              case "South":
                fillRatio = capacity/75.0;//Random
                if(fillRatio <= .33){southStatus.setBackground(Color.GREEN);}
                else if(fillRatio <= .66){southStatus.setBackground(Color.YELLOW);}
                else if(fillRatio <= 1 && fillRatio > .66){southStatus.setBackground(Color.RED);}
                else{southStatus.setBackground(Color.RED);}
                break;
              case "Center":
                fillRatio = capacity/79.0;//Random
                centerStatus.setText(" ");
                if(fillRatio <= .33){centerStatus.setBackground(Color.GREEN);}
                else if(fillRatio <= .66){centerStatus.setBackground(Color.YELLOW);}
                else if(fillRatio <= 1 && fillRatio > .66){centerStatus.setBackground(Color.RED);}
                else{centerStatus.setBackground(Color.RED);}
                break;
              }
              break; //All Floor
              case 5:
                floorStatus.setBackground(Color.LIGHT_GRAY);
                northStatus.setBackground(Color.LIGHT_GRAY);
                southStatus.setBackground(Color.LIGHT_GRAY);
                centerStatus.setBackground(Color.LIGHT_GRAY);
                break;
              }
    }
  public void resetStatusBar(){
    libraryStatus.setBackground(Color.LIGHT_GRAY);
    floorStatus.setBackground(Color.LIGHT_GRAY);
    northStatus.setBackground(Color.LIGHT_GRAY);
    southStatus.setBackground(Color.LIGHT_GRAY);
    centerStatus.setBackground(Color.LIGHT_GRAY);
    libraryStatusInt.setText("Unavailable");
    floorStatusInt.setText("Unavailable");
    northStatusInt.setText("Unavailable");
    southStatusInt.setText("Unavailable");
    centerStatusInt.setText("Unavailable");
  }

public class Listener implements ActionListener 
{
  public int advNum = 0;
  private boolean dumpStats = false;
  public void actionPerformed(ActionEvent e)
  {
  if (e.getSource() == buildingSelector)//Selecting vehicle types
  {
    //delete all elements that are not the selected type
    
    String str = buildingSelector.getSelectedItem().toString();
    if(str == "Shapiro Undergrad Library"){
      //System.out.println("Selected Shapiro");
      String[] floorsTemp = { "Basement", "First Floor", "Second Floor", "Third Floor", "Fourth Floor" };
      floors = floorsTemp;
    }
    else{
      String[] floorsTemp = { "Unavailable" };
      floors = floorsTemp;
      resetStatusBar();
    }
    //String[] floors = { "Basement", "First Floor", "Second Floor", "Third Floor", "Fourth Floor" };
    //floorSelector = new JComboBox(floors);
    //floorSelector.updateUI();
    floorSelector.removeAllItems();
    for(String s:floors){
        floorSelector.addItem(s);
    }
    //floorSelector.setSelectedIndex(0);
    //floorSelector.setEnabled(false);
    //JOptionPane.showConfirmDialog(null, "In Building Selector Listener", 
    //    "Tester", JOptionPane.OK_CANCEL_OPTION);
  }
  else if (e.getSource() == floorSelector){

    //JOptionPane.showConfirmDialog(null, "In Floor Selector Listener", 
        //"Tester", JOptionPane.OK_CANCEL_OPTION);
    String temp = (String) floorSelector.getSelectedItem();
    System.out.println(temp);
    if(temp == "Unavailable"){ resetStatusBar();}
    else{ updateGUI(); }
    
  }
  else if (e.getSource() == EXIT){
    System.exit(0);
  }
  else if (e.getSource() == suggestion){
    JOptionPane.showConfirmDialog(null, "Tech Support Not Live Yet", 
        "Hold Your Horses", JOptionPane.OK_CANCEL_OPTION);
    //emailSender es = new emailSender("Suggestion Box Test");
  }
  else if (e.getSource() == updateButton){
    if(reader.checkUpdateAvailability()){
      getTextFile();
      //curAttachment = new File("C:\\Users\\Clay\\Documents\\Senior Year\\UC 270\\src\\StudySpace\\uglifinal.txt");
      if(curAttachment!=null)
        getData(curAttachment);
      updateGUI();
    }
    else{
      JOptionPane.showConfirmDialog(null, "Statistics Are Already Up-to-Date", 
          "Hold Your Horses", JOptionPane.OK_CANCEL_OPTION);
    }
      
  }
}
}
public void updateSQLDB(){
  getShapiroStats();
}
public void updateGUI(){
  //URL imageURL = image_load.getResource("https://www.osha.gov/doc/engineering/images/2012_r_03/2012_r_03_fig02.jpg");
  Integer floorMax, northMax, southMax, centerMax;
  floorMax=northMax=southMax=centerMax=0;
  ClassLoader image_load = getClass().getClassLoader();
  URL imageURL = null;
  Integer floor = floorSelector.getSelectedIndex();
  switch(floor){
  case 0:// Basement
    floorMax = 219;
    northMax = 59;
    southMax = 49;
    centerMax = 110;
    imageURL = image_load.getResource("StudySpace/Ugli_Bsmall.png");
    break;
  case 1:// First
    floorMax = 404;
    northMax = 156;
    southMax = 90;
    centerMax = 158;
    imageURL = image_load.getResource("StudySpace/Ugli_1small.png");
    break;  
  case 2://
    floorMax = 342;
    northMax = 79;
    southMax = 125;
    centerMax = 138;
    imageURL = image_load.getResource("StudySpace/Ugli_2small.png");
    break;
  case 3://
    floorMax = 206;
    northMax = 139;
    southMax = 67;
    centerMax = 1;
    imageURL = image_load.getResource("StudySpace/Ugli_3small.png");
    break;
  case 4://
    floorMax = 228;
    northMax = 74;
    southMax = 75;
    centerMax = 79;
    imageURL = image_load.getResource("StudySpace/Ugli_4small.png");
    break;
  }
  if(imageURL != null){
    ImageIcon wizard = new ImageIcon(imageURL);
    floorImage.setIcon(wizard);
    floorImage.setSize(400, 600);
  }
  if(floor != -1){
    //getFloorStats(floor);
    setStatusColor(floorTotal, floor, "All");
    floorStatusInt.setText("<html><div style=\"text-align: center;\">" + floorTotal.toString() + 
        " of "+ floorMax + "</html>" );
    setStatusColor(northTotal, floor, "North");
    if(floor == 3){centerMax = 0;}
    centerStatusInt.setText("<html><div style=\"text-align: center;\">" + centerTotal.toString() + 
        " of "+ centerMax + "</html>");
    setStatusColor(southTotal, floor, "South");
    northStatusInt.setText("<html><div style=\"text-align: center;\">" + northTotal.toString() + 
        " of "+ northMax + "</html>");
    setStatusColor(centerTotal, floor, "Center");
    southStatusInt.setText("<html><div style=\"text-align: center;\">" + southTotal.toString() + 
        " of "+ southMax + "</html>");
    
  }
}
public void getTextFile(){
  /*
  Message temp = reader.getMessage();
  curAttachment = reader.getAttachment(temp);
  */
  curAttachment = reader.getAttachment();
}

public static void updateAP(String name, String stat){
  if(!statMap.containsKey(name)){
    //System.out.println("Adding to Vector: " + name);
    APNames.addElement(name);
  }
  statMap.put(name, Integer.parseInt(stat));
}
public void getShapiroStats(){
  regionPackets = new Vector<RegionPacket>();
  floorPackets = new Vector<FloorPacket>();
  libraryPackets = new Vector<LibraryPacket>();
  hourStatPackets = new Vector<HourStatPacket>();
  //System.out.println("Getting Stats for Floor:" + floor);
  String floorStr = null;
  floorTotal = northTotal = southTotal = centerTotal = 0;
  for(Integer floor = 0; floor < 5; floor++){
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
  libraryStatusInt.setText(libraryTotal.toString() + " of " + 1400);
  Double fillRatio = libraryTotal/1400.0;//Random
  if(fillRatio <= .33){libraryStatus.setBackground(Color.GREEN);}
  else if(fillRatio <= .66 && fillRatio > .33){libraryStatus.setBackground(Color.YELLOW);}
  else if(fillRatio <= 1 && fillRatio > .66){libraryStatus.setBackground(Color.RED);}
  else{libraryStatus.setBackground(Color.RED);}
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
  }
  libraryPackets.addElement(new LibraryPacket("Shapiro", libraryTotal));
  MainFile.db.updateFloors(floorPackets);
  MainFile.db.updateLibraries(libraryPackets);
  MainFile.db.updateRegions(regionPackets);
  MainFile.db.updateHourlyStats(hourStatPackets);
  
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
  libraryTotal = totalUsers;
  libraryStatusInt.setText(libraryTotal.toString());
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
class AutoUpdate extends TimerTask {
  public void run() {
    System.out.println("Performing Update!");
    if(reader.checkUpdateAvailability()){
      getTextFile();
      //curAttachment = new File("C:\\Users\\Clay\\Documents\\Senior Year\\UC 270\\src\\StudySpace\\uglifinal.txt");
      if(curAttachment!=null){
        getData(curAttachment);
        updateSQLDB();
        updateGUI();
      }
    }
    else{
      updateGUI();
    }
    //timer.cancel(); //Not necessary because we call System.exit
    //System.exit(0); //Stops the AWT thread (and everything else)
  }
}
}