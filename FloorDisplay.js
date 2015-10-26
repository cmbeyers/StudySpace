
function FloorOutput() {
	this.players = [];
	for(i=0; i < 4; i++){
		var player = new Player((i+1).toString());
		this.players.push(player);
	}
	this.board = new Board();
	this.spin = 0;
	this.curLibrary = "";
	this.curFloor = "";
	this.floorTotal = 0;
	this.floorMax = 0;
	this.floorColor = "Grey"
	this.southTotal = 0;
	this.southMax = 0;
	this.southColor = "Grey"
	this.centralTotal = 0;
	this.centralMax = 0;
	this.centralColor = "Grey"
}
FloorOutput.prototype.setFloor = function(floor) {
	console.log("Floor " + floor + " selected");
	var floorStats = db.libraries.find( { Library : this.curLibrary , Floor : floor } );
	this.floorTotal = floorStats.
}

