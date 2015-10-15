package miStudySpace;

public class RegionPacket {
  String libraryName = null;
  String floorName = null;
  String regionName = null;
  Integer currentOccupancy = 0;
  RegionPacket(String libName, String floor, String region, Integer curOc){
    libraryName = libName;
    floorName = floor;
    regionName = region;
    currentOccupancy = curOc;
  }
}
