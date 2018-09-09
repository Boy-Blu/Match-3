package guiversion;

import java.awt.BorderLayout;
import javax.swing.JFrame;

import gamemodel.Board;

/*
 * Creates the Jframe
 */
public class GuiView extends JFrame{
	
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
	}

}
