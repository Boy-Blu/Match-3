import java.util.Random;

public class Board {
	/**
	 * This is the main Class, Designed to house all 
	 * elements the user will be using
	 */
	static Cell[][] grid;
	public Board() {
		/**
		 * 	Creates a Board with 8, 8 board
		 */
		this(8,8);
	}
	public Board(int m, int n) {
		/**
		 * Creates the Board with m, n dimensions
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

	
	public String toString() {
		String s = "";
		for (int i =grid.length-1; i>=0; i--) {
			s+= "Row "+(i)+": ";
			for(int j =0; j< grid[i].length; j++) {
				s+=  grid[i][j].GetTile().GetColour()  +" ";
			}	
			s += '\n';	
		}
		
		return s;
		
	}
	
	public static void main(String[] args) {
		Board i = new Board();
		System.out.println(i);
		System.out.println(grid[0][0].GetTile().GetColour());
	}
}
