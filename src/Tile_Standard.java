
public class Tile_Standard extends Tile{

	public Tile_Standard(int col) {
		if(col < 1 || col > 7) throw new IllegalArgumentException(); 
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
		return Type.STANDARD;
	}
	
}
