package guiversion;


public class ShapeFactory {
	/**
	 * Generates a color based of a input between 1-7 
	 * @param i the value of colour
	 * @return A shape
	 */
	public static Shape makeShape(int i){
		switch(i){
		case 1: return (Shape) new Heart();
		case 2: return null;
		case 3: return null;
		case 4: return null;
		case 5: return null;
		case 6: return null;
		case 7: return null;
		default: return null;
		}
	}

}
