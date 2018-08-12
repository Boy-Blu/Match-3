public abstract class Cell {
	/**
	 * This contains the tile that is to be matched
	 */
	protected Tile held;
	protected Type colour;
	protected Cell[][] breadth;
	
	public abstract Tile getTile();
	public abstract Type getColour();
	public abstract void setColour(Type c);
	public abstract void removeTile();
	public abstract void setTile(Tile newtile);
}