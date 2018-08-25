public abstract class Cell {
	/**
	 * This contains the tile that is to be matched
	 */
	protected static Board grid;
	protected Tile held;
	protected Type colour;
	protected Cell[] breadth;
	/* 	1	2	3	
	 * 
	 *  0	c	4
	 * 
	 * 	7	6	5
	 * 
	 * ^Layout of breadth in terms of
	 * array index
	 */

	public abstract void removeTile();
	public abstract void setbeardth(int index, Cell c);
	public Board getBoard() {
		// TODO Auto-generated method stub
		return grid;
	}
	
	public Tile getTile() {
		// TODO Auto-generated method stub
		return held;
	}

	public void setTile(Tile newtile) {
		// TODO Auto-generated method stub
		held = newtile;
	}
	
	public Cell[] getBreadth(){
		return this.breadth;
	}

	public Type getColour(){
		return this.colour;
	}


	public void setColour(Type c) {
		this.colour = c;
	}

}