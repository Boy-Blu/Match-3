package guiversion;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
/*
 * Shows the actual Board
 * This is where the user mainly interacts
 */

public class Game_Panel  extends JPanel{
	private GuiView view;
	private Cell_Panel[] cp;

	public Game_Panel(GuiView view) {
		Cell_Panel.setGame_Panel(this);
		this.view = view;
		Cell_Panel.setBoard(view.getBoard());
		cp= new Cell_Panel[64];
		int count =0;
		
		//Generate the 64 Tiles
		this.setLayout(new GridLayout(8, 8));
		for(int i=7; i>=0; i--) {
			for(int j=0; j<8; j++) {
				cp[count] = new Cell_Panel(i, j);
				this.add(cp[count]);
				count++;
			}
		}
		this.setBackground(Color.decode("#191716"));
		this.setPreferredSize(new Dimension(816, 816));
		this.setBorder(BorderFactory.createLineBorder(Color.decode("#191716"), 2));
	}
	
	/**
	 * Gets The Selected At i,j
	 * @param i
	 * @param j
	 * @return
	 */
	public boolean getSelected(int i, int j) {
		try {
			return cp[i*8+j].getSelected();
		}catch(ArrayIndexOutOfBoundsException e) {
			return true;
		}
	}
	
	/**
	 * Sets The Selected At i,j
	 * @param i
	 * @param j
	 * @return
	 */
	public  void setSelected(int i, int j, Boolean k) {
		try {
			cp[i*8+j].setSelected(k);
		}catch(ArrayIndexOutOfBoundsException e) {}
	}

}
