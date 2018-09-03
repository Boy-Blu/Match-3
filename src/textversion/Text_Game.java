package textversion;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import gamemodel.Board;

public class Text_Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Text_Game();
	}
	Board model;
	//View view;
	Text_Controller view; 

	public Text_Game() {


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
		// model
		this.model = new Board(m,n); 
		
		//view
		this.view = new Text_Controller(this.model);
		
		//initiate
		this.view.run();
	}

}
