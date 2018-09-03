package gamemodel;

public class Cell_Standard extends Cell{

	public Cell_Standard() {
		// initialize with nothing
		this.held = null;
		this.colour=Type.NOTHING; 
		this.breadth = new Cell [8];
	}
}
