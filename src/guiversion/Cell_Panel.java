package guiversion;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class Cell_Panel extends JPanel implements MouseListener{
	private static boolean isDragged;
	int x,y;
	
	public Cell_Panel(int i, int j) {
		addMouseListener(this);
	}
	
	//Mouse Clicked in panel
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	//Mouse Enetered Panel
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	//Mouse Left Panel
	public void mouseExited(MouseEvent e) {
		// Don't Care
	}

	@Override
	// Mouse Pressed in panel
	public void mousePressed(MouseEvent e) {
		// Don't Care
	}

	@Override
	//Mouse Released in Panel
	public void mouseReleased(MouseEvent e) {
		// Don't Care		
	}


}
