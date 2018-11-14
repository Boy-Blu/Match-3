package guiversion;

import gamemodel.Board;

public class Gui_Game {
	Board model;
	GuiView view;
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Gui_Game();
			}
		});
	}
	
	public Gui_Game(){
		this.model = new Board();
		this.view = new GuiView(model);
	}

}
