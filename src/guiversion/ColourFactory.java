package guiversion;

import java.awt.Color;

public class ColourFactory {
	public static Color makeColour(int i){
		if (i ==1) {
			return Color.BLUE;
		}
		if (i ==2) {
			return Color.RED;
		}
		if (i ==3) {
			return Color.PINK;
		}
		if (i ==4) {
			return Color.ORANGE;
		}
		if (i ==5) {
			return Color.MAGENTA;
		}
		if (i ==6) {
			return Color.GREEN;
		}
		if (i ==7) {
			return Color.YELLOW;
		}
		return Color.WHITE;
	}

}
