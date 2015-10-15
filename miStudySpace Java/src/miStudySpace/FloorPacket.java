package miStudySpace;

public class FloorPacket {
  String libraryName = null;
  String floorName = null;
  Integer currentOccupancy = 0;
  FloorPacket(String libName, String floor, Integer curOc){
    libraryName = libName;
    floorName = floor;
    currentOccupancy = curOc;
  }
}
