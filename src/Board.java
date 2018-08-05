import java.util.Random;

public class Board {
	/**
	 * This is the main Class, Designed to house all 
	 * elements the user will be using
	 */
	Cell[][] grid;
	public Board() {
		/**
		 * 	Creates a Board with 8, 8 board
		 */
		this(8,8);
	}
	public Board(int m, int n) {
		/**
		 * 	Creates the Board with m, n dimensions
		 * @param: m, How wide the board is
		 * @param: n, How tall the boards is
		 * 
		 */
		Random rn = new Random();

		grid = new Cell[m][n];
		for (int i =0; i<m; i++) {
			for (int j=0; j<n; j++) {
				grid[i][j]=new Standard_Cell();
				grid[i][j].PlaceTile(new Standard_Tile(rn.nextInt(7)+1));
			}
		}
	}
	// Make a board designed By a custom load pattern, 
	// stored in some special save file or something
}
