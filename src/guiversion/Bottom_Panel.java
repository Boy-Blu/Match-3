package guiversion;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import gamemodel.Board;
import gamemodel.Type;

/*
 * Stores any other data/button we want
 */

public class Bottom_Panel  extends JPanel implements Observer{
	private GuiView view;
	
	public Bottom_Panel(GuiView view) {
		this.view = view;
		this.setBackground(Color.decode("#f46036"));
		this.setPreferredSize(new Dimension(816, 75));
		this.setBorder(BorderFactory.createLineBorder(Color.decode("#191716"), 2));
		view.game.addObserver(this);
	}
	
	//What Happens when Update is called
	public void update(Observable o, Object arg) {
		Board b = (Board)o;
		System.out.println("Hello");
		// The text to display?
//		this.setBackground((b.getGrid()[x][y].getColour()==Type.SELECTED)?
//				ColourFactory.makeColour(b.getGrid()[x][y].getTile().getColour()).darker():
//					ColourFactory.makeColour(b.getGrid()[x][y].getTile().getColour()));
	}
	
	@Override
	public void paint(Graphics g)
	{
	   g.drawString("abc", 25, 25);
	}
	


}
