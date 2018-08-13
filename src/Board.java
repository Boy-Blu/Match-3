import java.util.ArrayList;
import java.util.Random;

public class Board {
	/**
	 * This is the main Class, Designed to house all 
	 * elements the user will be using
	 */
	
	private Strategy_Match sm;
	private Cell[][] grid;
	private ArrayList<Cell> movelist ;
	
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
		movelist = new ArrayList<Cell>();
		sm = new Strat_Chain(); //Change this to test, we can work on a better way do it later
		grid = new Cell[m][n];
		for (int i =0; i<m; i++) {
			for (int j=0; j<n; j++) {
				grid[i][j]=new Cell_Standard();
				grid[i][j].setTile(new Tile_Standard(rn.nextInt(7)+1));
			}
		}
	}
	
	/**
	 * 
	 * @param i
	 * @param j
	 */
	public void move(int i, int j) {
		sm.move(i, j, this);
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean checkForMove() {
		return sm.checkForMove(this);
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
	
	/**
	 * @return the grid
	 */
	public Cell[][] getGrid() {
		return grid;
	}
	
	/**
	 * @return the movelist
	 */
	public ArrayList<Cell> getMovelist() {
		return movelist;
	}
	
	/**
	 * @param grid the grid to set
	 */
	public void setGrid(Cell[][] grid) {
		this.grid = grid;
	}
	
	/**
	 * @param movelist the movelist to set
	 */
	public void setMovelist(ArrayList<Cell> movelist) {
		this.movelist = movelist;
	}
}
