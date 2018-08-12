import java.util.Random;

public class Board {
	/**
	 * This is the main Class, Designed to house all 
	 * elements the user will be using
	 */
	private Cell[][] grid;
	
	/**
	 * 	Creates a Board with 8, 8 board
	 */
	public Board() {
		this(8,8);
	}
	/**
	 * Creates the Board with m, n dimensions
	 * @param: m, How wide the board is
	 * @param: n, How tall the boards is
	 * 
	 */
	public Board(int m, int n) {
		Random rn = new Random();

		grid = new Cell[m][n];
		for (int i =0; i<m; i++) {
			for (int j=0; j<n; j++) {
				grid[i][j]=new Cell_Standard();
				grid[i][j].setTile(new Tile_Standard(rn.nextInt(7)+1));
			}
		}
	}
	
	
	// Make a board designed By a custom load pattern, 
	// stored in some special save file or something
	public String toString() {
		String s = "";
		
		for (int i =grid.length-1; i>=0; i--) {
			s += "Row "+(i)+": ";

			for(int j =0; j< grid[i].length; j++) {
				char c = (char) grid[i][j].getTile().getColour();
				if(grid[i][j].getColour()==Type.NOTHING) c = (char) (c + 96);
				else c = (char) (c + 64);
				s += c +" ";
			}	
			s += '\n';	
		}
		return s;
	}
}
