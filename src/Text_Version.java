import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Text_Version {

	public static void run() {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] tokens;
		int m=0;
		int n=0;
		while(m<5 && n<5) {
			try {
				tokens = in.readLine().split(" ");
				m = Integer.parseInt(tokens[0]);
				n = Integer.parseInt(tokens[1]);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NumberFormatException v) {
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
			 
			// make move
			
			// get move
		}
		
	}




	public static void main(String[] args) {
		run();
	}
}
