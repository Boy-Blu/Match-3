
public class Board {
	
	Board Game = null;
	private Board() {
		/*
		 * 	I Dont know whats happening in this m ethod but its private tthis is crazy a private constructor? in sane!!
		 */
	}
	
	public Board GetInstance() {
		if (Game == null) {
			Game = new Board();
		}
		return Game;
	}
}
