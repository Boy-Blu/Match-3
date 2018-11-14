package gamemodel;
public abstract class Cell {
	/**
	 * This contains the tile that is to be matched
	 * Abstract in case we plan to expand with more tiles with different rules
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

	/**
	 * Removes the tile in the cell
	 */

	public void removeTile() {
		// TODO Auto-generated method stub
		if(held != null) {
			this.getTile().getSR().remove(this);
		}
		colour = Type.DELETED;
		held = null;
	}

	/**
	 * Designed to link up two cells together 
	 * @param index
	 * @param c
	 */
	public void setbeardth(int index, Cell c) {
		// TODO Auto-generated method stub
		if((index<0||index>8)){
			return;
			//Should Throw error
		}
		if(index>3) {
			c.setbeardth(index-4, this);
		}
		this.breadth[index]=c;
		return;
	}

	/**
	 * Gets the shared board
	 * @return
	 */
	public Board getBoard() {
		// TODO Auto-generated method stub
		return grid;
	}

	/**
	 * Gets the stored tile
	 * @return
	 */
	public Tile getTile() {
		// TODO Auto-generated method stub
		return held;
	}

	/**
	 * Setter for tile
	 * @param newtile
	 */
	public void setTile(Tile newtile) {
		// TODO Auto-generated method stub
		held = newtile;
	}

	/**
	 * Getter for breadth
	 * @return
	 */
	public Cell[] getBreadth(){
		return this.breadth;
	}

	/**
	 * Gets Status, "Colour", of cell
	 * @return
	 */
	public Type getColour(){
		return this.colour;
	}

	/**
	 * Sets Status, "Colour", of cell
	 * @param c the new Colour
	 */
	public void setColour(Type c) {
		this.colour = c;
	}

}