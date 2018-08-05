
public class Standard_Cell extends Cell{

	public Standard_Cell() {
		this.held = null;
		this.color=0;
	}

	@Override
	public Tile GetTile() {
		// TODO Auto-generated method stub
		return held;
	}

	@Override
	public void RemoveTile() {
		// TODO Auto-generated method stub
		color = 0;
		held = null;
	}

	@Override
	public void PlaceTile(Tile newtile) {
		// TODO Auto-generated method stub
		held = newtile;
	}
	
	
}
