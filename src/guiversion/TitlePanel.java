package guiversion;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
/*
 * Creates a Title 'Buffer', show score, moves, etc
 */

import gamemodel.Board;

public class TitlePanel extends JPanel implements Observer{
	private GuiView view;
	public TitlePanel(GuiView view) {
		
		this.view = view;
		this.setBackground(Color.decode("#f46036"));
		this.setPreferredSize(new Dimension(816, 75));
		this.setBorder(BorderFactory.createLineBorder(Color.decode("#191716"), 2));
		view.game.addObserver(this);
	}
	
	//What Happens when Update is called
	public void update(Observable o, Object arg) {
		Board b = (Board)o;
		this.repaint();
	}
	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);			
        drawCenteredString(g, "Score: " + (int) view.game.getScore(), new Rectangle(816, 75), new Font("Arial", Font.PLAIN, 25));
    }
	
	/**
	 * Draw a String centered in the middle of a Rectangle.
	 *
	 * @param g The Graphics instance.
	 * @param text The String to draw.
	 * @param rect The Rectangle to center the text in.
	 */
	public void drawCenteredString(Graphics g, String text, Rectangle rect, Font font) {
	    // Get the FontMetrics
	    FontMetrics metrics = g.getFontMetrics(font);
	    // Determine the X coordinate for the text
	    int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
	    // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
	    int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
	    // Set the font
	    g.setFont(font);
	    // Draw the String
	    g.drawString(text, x, y);
	}

}
