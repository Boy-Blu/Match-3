
public abstract class Tile {
	protected int color;
	protected Strategy_Remove sr;
	public abstract int getColour();
	public abstract Type getType();
	
	
	public void remove(Cell c){
		this.sr.remove(c);
	}
	
	// omri added a comment
	// this shouldn not be in master
	// third comment PLS HELP
}
