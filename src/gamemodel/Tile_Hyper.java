package gamemodel;

public class Tile_Hyper extends Tile{

	public Tile_Hyper() {
		this.color = 0;
		this.sr = new Remove_Strat_Hyper();
	}

	@Override
	public int getColour() {
		// TODO Auto-generated method stub
		return this.color;
	}

	@Override
	public Type getType() {
		// TODO Auto-generated method stub
		return Type.HYPER;
	}
}
