package guiversion;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;


/**
 * The Heart Class, 
 * Have a Heart...
 * @author AGruskovnjak
 *
 */
public class Heart extends Shape{

	private int width, height;
	private int[] xPts, yPts;
	private final static String SHAPE_TYPE = "Heart";
	/**
	 * Creates an instance of heart
	 * @param p the anchor point
	 * @param w the width
	 * @param h the height
	 * @param fill if it is filled
	 * @param c the color
	 * @param t the thickness
	 */
	public Heart(Point p, int w, int h, String fill, Color c1, Color c2, int t){
		//super(p, c1, c2, fill,(t+2)/2);// Want to set the thickness to half size, otherwise we get a weird heart
		this.width = w;
		this.height = h;
		xPts = new int[4];
		yPts = new int[4];
		this.setPoints();
	}

	public Heart(){
	}

	public void updateShape(int x, int y, int w, int h) {
		this.setHeight(h);
		this.setWidth(w);
		this.setAnchorPoint(new Point(x,y));
		
		this.setPoints();
	}



	/**
	 * Creates the the points for the bottom V of the heart
	 */
	public void setPoints() {
		int x = this.anchorPoint.getX();
		int y = this.anchorPoint.getY();
		int s3 = (int) ((width*(int)Math.sqrt(3))/4)*11/16; //a important value to find the perfect connection
		xPts[0] = x-width-s3;
		xPts[1]= x;//the tip of the heart
		xPts[2]=x+width+s3;
		xPts[3] = x;//for filled heart
		yPts[0] = y;
		yPts[1]=y+height;//the tip of the heart
		yPts[2]= y;
		yPts[3]= y-height/3;//for filled heart
	}

	public void setHeight(int h) {
		this.height = Math.abs(h-this.getAnchorPoint().getY());
		this.setPoints();
	}

	public void setWidth(int w) {
		this.width = Math.abs(w-this.getAnchorPoint().getX());
		this.setPoints();
	}

	// This Will Draw The  Shape
	public void execute(Graphics2D graphics) {

		int x = this.anchorPoint.getX();
		int y = this.anchorPoint.getY();
		graphics.setStroke(new BasicStroke(1));

		int s3 = (int) ((width*(int)Math.sqrt(3))/4);// an important value for finding points
		int j = x-width-s3; //a refrence point for the top left bump
		int k = y-height/2-height/4;// A refrence point for the two bumps
		//bumps are those upsidedown 3's on a heart


		graphics.setColor(Color.decode("#44AF69"));
		//the V
		graphics.fillPolygon(xPts, yPts, 4);
		//the Bumps
		graphics.fillOval(j, k, width+s3, height);
		graphics.fillOval(x, k, width+s3, height);


		graphics.setColor(Color.decode("#FFFFFF"));
		//the V
		graphics.drawLine(xPts[0], yPts[0], xPts[1], yPts[1]);
		graphics.drawLine(xPts[2], yPts[2],  xPts[1], yPts[1]);

		//bumps
		graphics.drawArc(j, k, width+s3, height, 0, 210);//left bump
		graphics.drawArc(x, k, width+s3, height, -30, 210);//right bump
	}
}