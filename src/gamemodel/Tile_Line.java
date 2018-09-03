package gamemodel;

public class Tile_Line extends Tile{
	
	boolean direction;// Going Vertically or Horizontal
	public Tile_Line(int col, boolean direction) {
		if(col < 0 || col > 7) throw new IllegalArgumentException(); 
		this.color = col;
		this.direction = direction;
		this.sr = new Remove_Strat_Line();
	}	

	@Override
	public int getColour() {
		// TODO Auto-generated method stub
		return this.color;
	}

	@Override
	public Type getType() {
		// TODO Auto-generated method stub
		return Type.LINE;
	}
	
	/**
	 * Get the direction of the line, True for vertical 
	 * @return direction
	 */
	public boolean getDirection() { 
		return direction;
	}
	
}
