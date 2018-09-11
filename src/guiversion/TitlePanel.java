package guiversion;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
/*
 * Creates a Title 'Buffer', show score, moves, etc
 */

public class TitlePanel extends JPanel {
	private GuiView view;
	public TitlePanel(GuiView view) {
		
		this.view = view;
		this.setBackground(Color.decode("#f46036"));
		this.setPreferredSize(new Dimension(816, 75));
		this.setBorder(BorderFactory.createLineBorder(Color.decode("#191716"), 2));
	}

}
