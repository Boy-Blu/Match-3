package guiversion;

import javax.swing.JFrame;

import gamemodel.Board;

public class GuiView extends JFrame{
	Board game;
	public GuiView(Board b) {

		this.game = b;
		
		this.setVisible(true);
	}

}
