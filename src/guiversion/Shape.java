package guiversion;

import java.awt.Graphics2D;

public abstract class Shape {
	protected Point anchorPoint;
	private int Width;
	private int Height;
	
	/**
	 * @return the width
	 */
	public int getWidth() {
		return Width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return Height;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		Width = width;
	}
	
	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		Height = height;
	}

	public void setAnchorPoint(Point p) {
		this.anchorPoint =p;
	}
	
	public  Point getAnchorPoint() {
		return anchorPoint;
	}
	
	public abstract void updateShape(int x, int y, int w, int h);

	public abstract void execute(Graphics2D graphics);
}
