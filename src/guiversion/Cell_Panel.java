package guiversion;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class Cell_Panel extends JPanel implements MouseListener{
	private static boolean isDragged = false;
	private static boolean isMove = false;
	int x,y;
	
	public Cell_Panel(int i, int j) {
		this.x = i;
		this.y = j;
		
		
		addMouseListener(this);
	}
	
	//Mouse Clicked in panel
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	//Mouse Entered Panel
	public void mouseEntered(MouseEvent e) {
		if(isDragged) {
			
		}
	}

	@Override
	//Mouse Left Panel
	public void mouseExited(MouseEvent e) {
		if(isDragged) {
			
		}
	}

	@Override
	// Mouse Pressed in panel
	public void mousePressed(MouseEvent e) {
		// Don't Care, I lied
	}

	@Override
	//Mouse Released in Panel
	public void mouseReleased(MouseEvent e) {
		// Don't Care		
	}


}
