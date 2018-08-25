
public class Tile_Bomb extends Tile{

	public Tile_Bomb(int col) {
		if(col < 0 || col > 7) throw new IllegalArgumentException(); 
		this.color = col;
		this.sr = new Remove_Strat_Bomb();
	}

	@Override
	public int getColour() {
		return this.color;
	}

	@Override
	public Type getType() {
		// TODO Auto-generated method stub
		return Type.BOMB;
	}
}
