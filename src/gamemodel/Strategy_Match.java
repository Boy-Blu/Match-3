package gamemodel;
public interface Strategy_Match {
	
	/**
	 * Attempts to make a move with given specifications
	 * @param i The x position on the board
	 * @param j The Y position on the board
	 * @param b The Board
	 */
	public abstract void  move(int i, int j, Board b);
	
	/**
	 * Checks for valid move
	 * @param b Board to Check if valid move exists
	 * @return True if move is available
	 */
	public abstract boolean checkForMove(Board b);
}
