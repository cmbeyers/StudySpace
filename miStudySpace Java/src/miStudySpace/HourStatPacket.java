package miStudySpace;

public class HourStatPacket {
    String floorName = null;
    String libraryName = null;
    Double floorFillPercentage = 0.0;
    Integer hourIndex = 0;
    Integer numIntervals = 1;
    String dayOfWeek = "";
    Integer dayIndex = 0;
    HourStatPacket(String libName, String floor, Double floorPercentageIn, Integer hourIn, Integer numIntervalsIn, Integer dayIndexIn){
      libraryName = libName;
      floorName = floor;
      floorFillPercentage = floorPercentageIn;
      hourIndex = hourIn;
      numIntervals = numIntervalsIn;
      //Java index has sunday 1, account for this to make monday 1
      switch(dayIndexIn){
      case 1:
        dayOfWeek = "Sunday";
        dayIndex = 7;
        break;
      case 2:
        dayOfWeek = "Monday";
        dayIndex = 1;
        break;
      case 3:
        dayOfWeek = "Tuesday";
        dayIndex = 2;
        break;
      case 4:
        dayOfWeek = "Wednesday";
        dayIndex = 3;
        break;
      case 5:
        dayOfWeek = "Thursday";
        dayIndex = 4;
        break;
      case 6:
        dayOfWeek = "Friday";
        dayIndex = 5;
        break;
      case 7:
        dayOfWeek = "Saturday";
        dayIndex = 6;
        break;
      default:
        dayOfWeek = "Unavailable";
        dayIndex = 0;
        break;
      }
    }
  }

