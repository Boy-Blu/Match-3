package textversion;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import gamemodel.Board;

public class Text_Controller {
	private Board game;

	private Text_View tv;
	public Text_Controller(Board b) {
		// TODO Auto-generated constructor stub
		game = b;
		tv = new Text_View();
		game.addObserver(tv);
	}
	
	//This is for mvc later on
	public void run() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(game);
		String[] tokens;
		int m=0;
		int n=0;
		while(true) {
			try {
				tokens = in.readLine().split(" ");
				m = Integer.parseInt(tokens[0]);
				n = Integer.parseInt(tokens[1]);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NumberFormatException v) {
			}
			catch (java.lang.ArrayIndexOutOfBoundsException z) {

			}
			game.move(n, m);	// These are flipped!!!! 

			// get move
			if(!game.checkForMove()){
				System.out.println("\nNo more moves.");
				return;
			}
		}

	}
}
