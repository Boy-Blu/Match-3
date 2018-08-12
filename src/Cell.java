public abstract class Cell {
	/**
	 * This contains the tile that is to be matched
	 */
	Tile held;
	Type colour;
	Cell[][] breadth;
	
	public abstract Tile GetTile();
	public abstract Type getColour();
	public abstract void setColour(Type c);
	public abstract void RemoveTile();
	public abstract void PlaceTile(Tile newtile);
	
}
