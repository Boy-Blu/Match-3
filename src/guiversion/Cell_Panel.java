package guiversion;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import gamemodel.Board;
import gamemodel.Type;

public class Cell_Panel extends JPanel implements MouseListener, Observer, MouseMotionListener, ComponentListener{
	private static boolean isDragged = false; //If we are dragging or clicking
	private static Board game = null; //The Game the Cells are attached to
	private static Game_Panel view = null; // the View Cells are a part of

	private static int xth_panel, yth_panel =0; //The accesssed Panel
	private static int xCurr, yCurr =0; // The Previous Panel, For Button debounce
	
	private int x, y;// 
	private boolean selected;//If the cell was a selected button debounce

	/**
	 * Constructor
	 * @param i The I Position of the Cell
	 * @param j The J position of the Cell
	 */
	public Cell_Panel(int i, int j) {
		this.setPreferredSize(new Dimension(view.getWidth() / 8, view.getHeight() / 8));
		this.setBorder(BorderFactory.createLineBorder(Color.decode("#191716"), 2));
		selected = false;

		this.x = i;
		this.y = j;
		
		this.setBackground(ColourFactory.makeColour(game.getGrid()[x][y].getTile().getColour()));
		
		//Add listener + observer
		addMouseListener(this);
		addMouseMotionListener(this);
		addComponentListener(this);
		game.addObserver(this);
	}
	
	/**
	 * Sets the board
	 * @param b - the board
	 */
	public static void setBoard(Board b) {
		game = b;
	}
	
	/**
	 * Gets the board
	 * @return the board
	 */
	public static Board getBoard() {
		return game;
	}
	
	/**
	 * Sets the Static GamePanel 
	 * @param gp - the Board
	 */
	public static void setGame_Panel(Game_Panel gp) {
		view = gp;
	}
	public static int getx() {
		return xth_panel;
	}

	public static int gety() {
		return yth_panel;
	}

	// Mouse Clicked in panel
	public void mouseClicked(MouseEvent e) {
		//System.out.println(game);
		game.move(x,y);
	}

	//What Happens when Update is called
	public void update(Observable o, Object arg) {
		Board b = (Board)o;
		this.setBackground((b.getGrid()[x][y].getColour()==Type.SELECTED)?
				ColourFactory.makeColour(b.getGrid()[x][y].getTile().getColour()).darker():
					ColourFactory.makeColour(b.getGrid()[x][y].getTile().getColour()));
	}

	/**
	 * What Happens when Dragged
	 */
	public void mouseDragged(MouseEvent e) {
		int xcoor = (int) e.getX()%this.getWidth() - this.getWidth()/2;
		int ycoor = (int) e.getY()%this.getHeight() - this.getHeight()/2;
		if (xcoor * xcoor + ycoor * ycoor <= (this.getHeight() / 2) * (this.getWidth() / 2)&&!view.getSelected(xth_panel, yth_panel)) {
			//If we are in within a Circle, And Circle was Previously not Selected, ie We left the Cell
			isDragged=true;//Set dragging to be true
			game.move(xth_panel, yth_panel);
			view.setSelected(xth_panel, yth_panel, true);
			xCurr = xth_panel; 
			yCurr = yth_panel;
			System.out.println("P:"+ xth_panel+" "+ yth_panel);//Some Test Statement
		}
		else if(xCurr!=xth_panel&&yth_panel!=yCurr) {//Update debounce
			System.out.println("C:"+ xCurr+" "+ yCurr);
			view.setSelected(xCurr, yCurr, false);
			xCurr = xth_panel; 
			yCurr = yth_panel;
		}
	}

	//Dont Need
	public void mouseMoved(MouseEvent e) {}
	
	@Override
	// Mouse Entered Panel
	public void mouseEntered(MouseEvent e) {
		//Update Posistion
		xth_panel = x;
		yth_panel = y;
		//System.out.println("x:"+ xth_panel+ " y:"+ yth_panel);

	}

	@Override
	// Mouse Left Panel
	public void mouseExited(MouseEvent e) {
		selected=false;
		//System.out.println("x:"+ xth_panel+ " y:"+ yth_panel);

	}

	// Mouse Released in Panel
	public void mouseReleased(MouseEvent e) {
		if(isDragged) {
			//If We are Dragging, Make The Move at the end
			if(!(x==xth_panel&&y==yth_panel)) {
				game.move(xth_panel, yth_panel);
			}
			isDragged=false;
		}
	}

	// Mouse Pressed in panel, Don't Care
	public void mousePressed(MouseEvent e) {}

	/**
	 * Getter for Selected
	 * @return
	 */
	public boolean getSelected() {
		return selected;
	}
	
	/**
	 * Setter for selected
	 * @param k
	 */
	public void setSelected(Boolean k) {
		// TODO Auto-generated method stub
		selected = k;
	}

	@Override
	public void componentResized(ComponentEvent e) {
		// TODO Auto-generated method stub
	}

	public void componentMoved(ComponentEvent e) {}
	public void componentShown(ComponentEvent e) {}
	public void componentHidden(ComponentEvent e) {}

}
