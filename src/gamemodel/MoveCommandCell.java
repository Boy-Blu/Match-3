package gamemodel;

public class MoveCommandCell implements MoveCommand {

	Cell c;
	
	/**
	 * Create the Move Command Object
	 * @param temp
	 */
	public MoveCommandCell(Cell c) {
		// TODO Auto-generated constructor stub
		this.c = c;
		c.setColour(Type.SELECTED);
	}

	/**
	 * What to do when invoker calls
	 */
	public void invoke() {
		c.removeTile();
	}

	/**
	 * Getter for Cell
	 */
	public Cell getCell() {
		// TODO Auto-generated method stub
		return c;
	}

	/**
	 * Remove Cell from invoker
	 */
	public void removeCell(){
		c.setColour(Type.NOTHING);
	}

}
