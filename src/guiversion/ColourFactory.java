package guiversion;

import java.awt.Color;

public class ColourFactory {
	/**
	 * Generates a color based of a input between 1-7 
	 * @param i the value of colour
	 * @return A Colour
	 */
	public static Color makeColour(int i){
		if (i ==1) {
			return Color.decode("#44AF69");
		}
		if (i ==2) {
			return Color.decode("#F8333C");
		}
		if (i ==3) {
			return Color.decode("#FCAB10");
		}
		if (i ==4) {
			return Color.decode("#2B9EB3");
		}
		if (i ==5) {
			return Color.decode("#DBD5B5");
		}
		if (i ==6) {
			return Color.decode("#331832");
		}
		if (i ==7) {
			return Color.decode("#0A2463");
		}
		return Color.decode("#FFFFFF");
	}

}
