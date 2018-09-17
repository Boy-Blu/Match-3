package guiversion;


public class ShapeFactory {
	/**
	 * Generates a color based of a input between 1-7 
	 * @param i the value of colour
	 * @return A shape
	 */
	public static Shape makeShape(int i){
		switch(i){
		case 1: return (Shape) new ShapeHeart();
		case 2: return (Shape) new ShapeCircle();
		case 3: return (Shape) new ShapeHeart();
		case 4: return (Shape) new ShapeCircle();
		case 5: return (Shape) new ShapeHeart();
		case 6: return (Shape) new ShapeCircle();
		case 7: return (Shape) new ShapeHeart();
		default: return (Shape) new ShapeHeart();
		}
	}

}
