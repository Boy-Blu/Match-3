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
		
		this.setBackground(Color.yellow.darker().darker());
		this.setPreferredSize(new Dimension(300, 300));
		this.setBorder(BorderFactory.createLineBorder(Color.black, 2));
	}

}
