package gamemodel;
import java.util.ArrayList;
import java.util.Random;
import java.util.Observable;

public class Board extends Observable{
	/**
	 * This is the main Class, Designed to house all 
	 * elements the user will be using
	 */

	private Strategy_Match sm;
	private Cell[][] grid;
	private ArrayList<Cell> movelist ;
	private MoveCommandInvoker mci;
	private int move;

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

		sm = new Match_Strat_Click(); //Change this to test, we can work on a better way do it later

		move =0;

		grid = new Cell[m][n];
		mci = new MoveCommandInvoker();
		for (int i =0; i<m; i++) {
			for (int j=0; j<n; j++) {
				grid[i][j] = new Cell_Standard();
				grid[i][j].setTile(new Tile_Standard(rn.nextInt(7)+1));
				connect(i,j);
			}
		}
		Cell.grid = this; //All Cells reference this board, Static Value
		this.setChanged();
		this.notifyObservers();
	}


	/**
	 * Helper for the constructor, links all cells together 
	 * @param i reference on i
	 * @param j reference on j
	 */
	private void connect(int i, int j) {
		int[] temp = {i, j-1, i-1, j-1, i-1, j, i-1, j+1};
		for(int k =0; k<8; k+=2) {	
			try {
				grid[temp[k]][temp[k+1]].setbeardth(4+(k/2), grid[i][j]);
			} catch (ArrayIndexOutOfBoundsException e) {
				// TODO: handle exception

			} catch (NullPointerException npe) {
				System.out.println(i+":i  "+j+":j  "+temp[k]+":k1 "+temp[k+1]+ "   ~K:"+k);
			}
		}

	}

	/**
	 * Makes the move on the board
	 * @param i x coordinate
	 * @param j y coordinate
	 */
	public void move(int i, int j) {
		sm.move(i, j, this);
		this.setChanged();
		this.notifyObservers();
	}

	/**
	 * Checks if a move exists
	 * @return true if a move exists
	 */
	public boolean checkForMove() {
		return sm.checkForMove(this);
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
	 * Makes a string representation of the board
	 */
	public String toString() {
		String s = "";



		for (int i =grid.length-1; i>=0; i--) {
			s += "Row "+(i)+":  ";

			for(int j =0; j< grid[i].length; j++) {

				if (grid[i][j].getTile() == null) {
					s += "~ ";
				}
				else {
					char c = (char) grid[i][j].getTile().getColour();
					if(grid[i][j].getColour()==Type.NOTHING) c = (char) (c + 96);
					else c = (char) (c + 64);
					s += c +" ";
				}
			}	
			s += '\n';	
		}

		s += "\n        ";
		for(int i = 0; i < grid[0].length; i++){
			s += i + " ";
		}

		s += '\n';
		return s;
	}

	/**
	 * 	Drop method: removes all deleted cells, drops the tiles above them and fills the remaining deleted cells with new tiles
	 */
	public void dropAndFill(){
		int height = this.grid.length;
		int width = this.grid[0].length;

		// "drop" the cells in each column, then fill each column
		for(int x = 0; x < width; x++){

			// Create temp array for column
			Cell[] col = new Cell[height];

			int y = 0;
			int k = 0;

			while(y < height){
				if(grid[y][x].getColour() == Type.SELECTED) return;	// If any cells are selected just return!

				col[y] = grid[y][x];	

				if(grid[y][x].getColour() == Type.NOTHING){
					col[k].setColour(Type.NOTHING);
					col[k].setTile(grid[y][x].getTile());
					k++;
				}
				y++;
			}
			while(k < height){
				col[k].setColour(Type.DELETED);
				col[k].removeTile();
				k++;
			}
			replaceDeletedInColumn(col);
		}
	}

	/**
	 * Replaces all Cells of Type DELETED in the column with randomly generated cells
	 * @param col
	 */
	private void replaceDeletedInColumn(Cell[] col){
		Random rn = new Random();
		int height = col.length;

		for(int i = 0; i < height; i++){
			if(col[i].getColour() == Type.DELETED){

				// Replace this with TileFactory?
				col[i].setTile(new Tile_Standard(rn.nextInt(7)+1));
				col[i].setColour(Type.NOTHING);
			}
		}
	}

	/**
	 * Getter for the MCI
	 * @return mci
	 */
	public MoveCommandInvoker getMCI(){
		return this.mci;
	}

	/**
	 * Increments move to show user amount of moves made
	 * Reference to move here is when user has 
	 * dropped tiles
	 */
	public void makeMove() {
		move ++;

	}

	/**
	 * Gets Value of move
	 * @return
	 */
	public int getMove() {
		return move;

	}
}
