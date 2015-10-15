package miStudySpace;

public class LibraryPacket {
  String libraryName = null;
  Integer currentOccupancy = 0;
  LibraryPacket(String libName, Integer curOc){
    libraryName = libName;
    currentOccupancy = curOc;
  }
}
