public abstract class Cell {
	/**
	 * This contains the tile that is to be matched
	 */
	Tile held;
	int color;
	Cell[][] breadth;
	
	public abstract Tile GetTile();
	public abstract void RemoveTile();
	public abstract void PlaceTile(Tile newtile);
	
}
