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
	var floorStats = db.libraries.find( { Library : this.curLibrary , Floor : floor } );
	this.floorTotal = floorStats.
}
FloorOutput.prototype.setLibrary = function(library) {
	this.curLibrary = library;
	var library = db.libraries.find({ Library : library} );
	
}
Game.prototype.Play_Game = function() {
	console.log("play_game");
	var end = this.Check_End_Game();
	if (end){
		alert("the game is over. you're drunk. go home.");
	}
	if (this.players[this.curPlayer].done){
		this.curPlayer++;
		this.curPlayer%4;
		this.Play_Game();
	}
	console.log("player " + this.curPlayer.toString() + "'s turn");
	this.turn_summary = "";
	this.Get_Spin();
};


{% for c in careers %}
<script>
	var salary='{{ c.salary }}';
	var title='{{ c.title }}';
	var img_path='{{ c.img_path }}';
	var career=new Career(title, salary, img_path);
	this_game.careers.push(career);
</script>
{% endfor %}