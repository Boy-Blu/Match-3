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

import gamemodel.Board;
import gamemodel.Type;

/*
 * Stores any other data/button we want
 */

public class Bottom_Panel  extends JPanel implements Observer{
	private GuiView view;
	
	public Bottom_Panel(GuiView view) {
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
        Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setFont(new Font("Arial", Font.PLAIN, 25)); 
        g2.drawString("Moves Made: " + view.game.getMove(), 25, 75/2 + 8);
    }
}
