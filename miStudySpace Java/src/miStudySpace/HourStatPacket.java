package miStudySpace;

public class HourStatPacket {
    String floorName = null;
    String libraryName = null;
    Double floorFillPercentage = 0.0;
    Integer hourIndex = 0;
    Integer numIntervals = 1;
    HourStatPacket(String libName, String floor, Double floorPercentageIn, Integer hourIn, Integer numIntervalsIn){
      libraryName = libName;
      floorName = floor;
      floorFillPercentage = floorPercentageIn;
      hourIndex = hourIn;
      numIntervals = numIntervalsIn;
    }
  }

