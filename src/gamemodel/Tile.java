package gamemodel;

public abstract class Tile {
	protected int color;
	protected Strategy_Remove sr;//How does it pop
	public abstract int getColour();
	public abstract Type getType();
	
	/**
	 * Pops from Cell c
	 * @param c
	 */
	public void remove(Cell c){
		this.sr.remove(c);
	}
	
	/**
	 * Returns the remove Strategy
	 * @return
	 */
	public Strategy_Remove getSR() {
		return sr;
	}
	
	// omri added a comment
	// this shouldn not be in master
	// third comment PLS HELP
}
