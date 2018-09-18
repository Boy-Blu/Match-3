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
public class ShapeHeart extends Shape{

	
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
	public ShapeHeart(Point p, int w, int h, String fill, Color c1, Color c2, int t){
		//super(p, c1, c2, fill,(t+2)/2);// Want to set the thickness to half size, otherwise we get a weird heart
		//this.width = w ;
		//this.height = h;
		xPts = new int[4];
		yPts = new int[4];
		this.setPoints();
	}

	public ShapeHeart(){
		xPts = new int[4];
		yPts = new int[4];
	}

	public void updateShape(int x, int y, int w, int h) {
		this.setAnchorPoint(new Point(x,y));
		this.setHHeight(h);
		this.setHWidth((int) (1.5 * w));
		this.setPoints();
	}



	/**
	 * Creates the the points for the bottom V of the heart
	 */
	public void setPoints() {
		int x = this.anchorPoint.getX();
		int y = this.anchorPoint.getY();
		int s3 = (int) ((getWidth()*(int)Math.sqrt(3))/4)*11/16; //a important value to find the perfect connection
		xPts[0] = x-getWidth()-s3;
		xPts[1]= x;//the tip of the heart
		xPts[2]=x+getWidth()+s3;
		xPts[3] = x;//for filled heart
		
		yPts[0] = y;
		yPts[1]=y+getHeight();//the tip of the heart
		yPts[2]= y;
		yPts[3]= y-getHeight()/3;//for filled heart
	}

	public void setHHeight(int h) {
		this.setHeight(Math.abs(h-this.getAnchorPoint().getY())) ;
	}

	public void setHWidth(int w) {
		this.setWidth(Math.abs(w-this.getAnchorPoint().getX()));
	}

	// This Will Draw The  Shape
	public void execute(Graphics2D graphics) {

		int x = this.anchorPoint.getX();
		int y = this.anchorPoint.getY();
		graphics.setStroke(new BasicStroke(1));

		int s3 = (int) ((getWidth()*(int)Math.sqrt(3))/4);// an important value for finding points
		int j = x-getWidth()-s3; //a refrence point for the top left bump
		int k = y-getHeight()/2-getHeight()/4;// A refrence point for the two bumps
		//bumps are those upsidedown 3's on a heart


		graphics.setColor(Color.decode("#F8333C"));
		//the V
		graphics.fillPolygon(xPts, yPts, 4);
		//the Bumps
		graphics.fillOval(j, k, getWidth()+s3, getHeight());
		graphics.fillOval(x, k, getWidth()+s3, getHeight());


		graphics.setColor(Color.decode("#FFFFFF"));
		//the V
		graphics.drawLine(xPts[0], yPts[0], xPts[1], yPts[1]);
		graphics.drawLine(xPts[2], yPts[2],  xPts[1], yPts[1]);

		//bumps
		graphics.drawArc(j, k,  getWidth()+s3, getHeight(), 0, 210);//left bump
		graphics.drawArc(x, k,  getWidth()+s3, getHeight(), -30, 210);//right bump
	}
}