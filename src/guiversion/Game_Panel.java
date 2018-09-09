package guiversion;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
/*
 * Shows the actual Board
 * This is where the user mainly interacts
 */

public class Game_Panel  extends JPanel {
	private GuiView view;
	private Cell_Panel[] cp;
	
	public Game_Panel(GuiView view) {
		Cell_Panel.setGame_Panel(this);
		this.view = view;
		Cell_Panel.setBoard(view.getBoard());
		cp= new Cell_Panel[64];
		int count =0;
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				cp[count] = new Cell_Panel(i, j);
				this.add(cp[count]);
				count++;
			}
		}
		
		
		this.setBackground(Color.blue.darker().darker());
		this.setPreferredSize(new Dimension(816, 816));
		this.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		
		this.setLayout(new GridLayout(8, 8));
	}
}
