package guiversion;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.MenuDragMouseEvent;
import javax.swing.event.MenuDragMouseListener;

import gamemodel.Board;

public class Cell_Panel extends JPanel implements MouseListener, MouseMotionListener {
	private static boolean isDragged = false;
	private static boolean collected = false;
	private static Board game = null;
	private static Game_Panel view = null;

	int x, y;

	public Cell_Panel(int i, int j) {
		this.setPreferredSize(new Dimension(view.getWidth() / 8, view.getHeight() / 8));
		this.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		JTextArea JTA = new JTextArea();
		JTA.setText(i + " + " + j);
		this.add(JTA);

		this.x = i;
		this.y = j;
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	public static void setBoard(Board b) {
		game = b;
	}

	public static void setGame_Panel(Game_Panel gp) {
		view = gp;
	}

	// Mouse Clicked in panel
	public void mouseClicked(MouseEvent e) {
		int xcoor = (int) e.getX() - this.getWidth() / 2;
		int ycoor = (int) e.getY() - this.getHeight() / 2;
		if (xcoor * xcoor + ycoor * ycoor <= (this.getHeight() / 2) * (this.getWidth() / 2)) {
			System.out.println("in");
		}
	}

	// For Dragged Mode

	@Override
	// Mouse Entered Panel
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	// Mouse Left Panel
	public void mouseExited(MouseEvent e) {
		collected = false;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
		int xcoor = (int) e.getX() - this.getWidth() / 2;
		int ycoor = (int) e.getY() - this.getHeight() / 2;
		if (xcoor * xcoor + ycoor * ycoor <= (this.getHeight() / 2) * (this.getWidth() / 2) && !collected) {
			System.out.println("inDragged");
			collected = true;
		}
	}

	// Mouse Released in Panel
	public void mouseReleased(MouseEvent e) {
	}

	// Mouse Pressed in panel
	public void mousePressed(MouseEvent e) {
	}

	public void mouseMoved(MouseEvent e) {
	}

}
