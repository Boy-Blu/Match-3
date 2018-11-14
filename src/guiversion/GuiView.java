package guiversion;

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import gamemodel.Board;

/*
 * Creates the Jframe
 */
public class GuiView extends JFrame implements Observer {
	
	Board game;
	private Game_Panel gp;
	private Bottom_Panel bp;
	private TitlePanel tp;
	private Nav_Bar nb;
	
	
	public GuiView(Board b) {
		this.game = b;
		this.setVisible(true);
		tp = new TitlePanel(this);
		gp = new Game_Panel(this);
		bp = new Bottom_Panel(this);
		nb = new Nav_Bar(this);
		
		
		this.setLayout(new BorderLayout());
		this.add(tp, BorderLayout.NORTH);
		this.add(gp, BorderLayout.CENTER);
		this.add(bp, BorderLayout.SOUTH);
		this.pack();
		

		this.setJMenuBar(nb);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		game.addObserver(this);
	}
	
	public Board getBoard() {
		return game;
	}

	//What Happens when Update is called
	public void update(Observable o, Object arg) {
		Board b = (Board)o;
		if(!b.checkForMove()){
			JOptionPane end = new JOptionPane();
			JOptionPane.showMessageDialog(this,
				    "Game over! No more moves!");
		}
	}
}
