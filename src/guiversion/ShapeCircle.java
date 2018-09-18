package guiversion;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class ShapeCircle extends Shape{
	// the radius of the circle

	public ShapeCircle() {

	}
	public void updateShape(int x, int y, int w, int h) {
		this.setAnchorPoint(new Point(x,y));
		this.setHeight(h);
		this.setWidth(w);

	}

	public void execute(Graphics2D graphics) {
		graphics.setStroke(new BasicStroke(1));
		graphics.setColor(Color.decode("#44AF69"));
		graphics.fillOval(0,0, this.getWidth()*16, this.getHeight()*16);
		graphics.setColor(Color.black);
		graphics.drawOval(0, 0 , this.getWidth()*16, this.getHeight()*16);

	}

}
