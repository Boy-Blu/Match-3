package guiversion;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class ShapeDiamond extends Shape{
	public ShapeDiamond() {	
	}

	public void updateShape(int x, int y, int w, int h) {
		this.setHeight(h);
		this.setWidth(w);
		this.setAnchorPoint(new Point(x,y));
	}

	public void execute(Graphics2D graphics) {
		
		int[] xPts = {this.getAnchorPoint().getX(),0,this.getAnchorPoint().getX(),this.getAnchorPoint().getX()*2};
		int[] yPts = {0,this.getAnchorPoint().getY(),this.getAnchorPoint().getY()*2,this.getAnchorPoint().getY()};
		
		graphics.setStroke(new BasicStroke(1));
		graphics.setColor(Color.decode("#FCAB10"));
		graphics.fillPolygon(xPts, yPts, 4);
		graphics.setColor(Color.decode("#000000"));
		graphics.drawPolygon(xPts, yPts, 4);
	}

}
