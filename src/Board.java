
public class Board {
	/**
	 * 
	 */
	
	Board Game = null;
	private Board() {
		/*
		 * 	
		 */
	}
	 
	public Board GetInstance() {
		/**
		 * 
		 */
		
		if (Game == null) {
			Game = new Board();
		}
		return Game;
	}
}
