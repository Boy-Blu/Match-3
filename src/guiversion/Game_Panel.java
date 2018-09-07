package guiversion;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
/*
 * Shows the actual Board
 * This is where the user mainly interacts
 */

public class Game_Panel  extends JPanel {
	private GuiView view;
	
	public Game_Panel(GuiView view) {
		
		this.view = view;
		
		this.setBackground(Color.blue.darker().darker());
		this.setPreferredSize(new Dimension(300, 300));
		this.setBorder(BorderFactory.createLineBorder(Color.black, 2));

	}
}
