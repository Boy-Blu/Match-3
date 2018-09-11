package guiversion;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

/*
 * Stores any other data/button we want
 */

public class Bottom_Panel  extends JPanel {
	private GuiView view;
	
	public Bottom_Panel(GuiView view) {
		
		this.view = view;
		
		this.setBackground(Color.decode("#f46036"));
		this.setPreferredSize(new Dimension(816, 75));
		this.setBorder(BorderFactory.createLineBorder(Color.decode("#191716"), 2));

	}


}