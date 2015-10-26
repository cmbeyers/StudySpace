function LibraryDisplay() {
	this.curLibrary = "";
	this.basementFloorTotal = 0;
	this.firstFloorTotal = 0;
	this.secondFloorTotal = 0;
	this.thirdloorTotal = 0;
	this.fourthFloorTotal = 0;
	this.floorMax = 0;
	this.floorColor = "Grey"
	this.southTotal = 0;
	this.southMax = 0;
	this.southColor = "Grey"
	this.centralTotal = 0;
	this.centralMax = 0;
	this.centralColor = "Grey"
}
LibraryDisplay.prototype.setLibrary = function(library) {
	console.log("Library " + library + " selected");
	this.curLibrary = library;
	//Start to find floor stats for this library, open a floor display window
	
}
LibraryDisplay.prototype.displayLibraryInfo = function(library) {
	console.log("Library Info for " + library + " selected");
	this.curLibrary = library;
	//Fill the values for hours, days open, outlets
	
}
