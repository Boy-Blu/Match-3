package textversion;
import java.util.Observable;
import java.util.Observer;

import gamemodel.Board;

public class Text_View implements Observer{

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		Board b = (Board)o;
		System.out.println(b);
	}

}
