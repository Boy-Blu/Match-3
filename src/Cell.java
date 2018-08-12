public abstract class Cell {
	/**
	 * This contains the tile that is to be matched
	 */
	private Tile held;
	private Type colour;
	private Cell[][] breadth;
	
	public abstract Tile GetTile();
	public abstract Type getColour();
	public abstract void setColour(Type c);
	public abstract void RemoveTile();
	public abstract void PlaceTile(Tile newtile);
}