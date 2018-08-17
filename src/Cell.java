public abstract class Cell {
	/**
	 * This contains the tile that is to be matched
	 */
	protected Tile held;
	protected Type colour;
	protected Cell[] breadth;
	/* 	1	2	3	
	 * 
	 * 
	 * 	7	6	5
	 * 
	 * ^Layout of breadth in terms of
	 * array index
	 */
	
	public abstract Tile getTile();
	public abstract Type getColour();
	public abstract void setColour(Type c);
	public abstract void removeTile();
	public abstract void setTile(Tile newtile);
	public abstract void setbeardth(int index, Cell c);
}