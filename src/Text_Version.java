import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Text_Version {

	public static void run() {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] tokens;
		int m=0;
		int n=0;
		System.out.println("Enter grid size mxn");
		while(m<5 && n<5) {
			try {
				tokens = in.readLine().split(" ");
				m = Integer.parseInt(tokens[0]);
				n = Integer.parseInt(tokens[1]);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NumberFormatException v) {
			}catch (ArrayIndexOutOfBoundsException e) {
				m=0;
				n=0;
			}
		}

		Board game =  new Board(m,n);
		System.out.println(game);

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

			System.out.println(game);

			// get move
			if(!game.checkForMove()){
				System.out.println("\nNo more moves.");
				return;
			}
		}

	}
	
	//This is for mvc later on
	public void run(Board game) {
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

			System.out.println(game);

			// get move
			if(!game.checkForMove()){
				System.out.println("\nNo more moves.");
				return;
			}
		}

	}

	public static void main(String[] args) {
		run();
	}
}
