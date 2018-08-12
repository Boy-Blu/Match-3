
public class Tile_Line extends Tile{

	public Tile_Line(int col) {
		if(col < 0 || col > 7) throw new IllegalArgumentException(); 
		this.color = col;
	}

	@Override
	public int getColour() {
		// TODO Auto-generated method stub
		return this.color;
	}

	@Override
	public Type getType() {
		// TODO Auto-generated method stub
		return Type.LINE;
	}
	
}
