package guiversion;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class ShapeCircle extends Shape{
	// the radius of the circle
	private int radius;
	private static final String SHAPE_TYPE = "Circle";
	/**
	 * 
	 * @param centre
	 * 			a Point being the centre of the circle
	 * @param radius
	 * 			an int being the radius of the circle
	 * @param fill
	 * 			string of whether or not to fill or outline
	 * @param c
	 * 			string of desired colour
	 */
	public ShapeCircle(Point centre, int radius, String fill, Color c1, Color c2, int t){
		//super(centre, c1, c2, fill , t);
		this.radius = radius;
	}
	
	public ShapeCircle() {
		
	}

	public void updateShape(int x, int y, int w, int h) {
		this.setHeight(h);
		this.setWidth(h);
		this.setAnchorPoint(new Point(x,y));
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public void execute(Graphics2D graphics) {
		graphics.setStroke(new BasicStroke(1));
		int x = anchorPoint.getX();
		int y = anchorPoint.getY();


		graphics.setColor(Color.decode("#F8333C"));
		graphics.fillOval(x-radius, y-radius, radius*2, radius*2);
		graphics.setColor(Color.black);

		graphics.setColor(Color.black);
		if(radius>=1/2) {
			graphics.drawOval(x-radius, y-radius, radius*2, radius*2);
		}else {
			//We get a weird donut without this
			graphics.fillOval(x-radius-1/2,
					y-radius-1/2, radius*2+1,
					radius*2+1);
		}
	}

}
