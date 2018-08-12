
public class Standard_Cell extends Cell{

	public Standard_Cell() {
		this.held = null;
		this.colour=Type.NOTHING;
	}

	@Override
	public Tile GetTile() {
		// TODO Auto-generated method stub
		return held;
	}

	@Override
	public Type getColour(){
		return this.colour;
	}
	
	@Override
	public void setColour(Type c) {
		this.colour = c;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	@Override
	public void RemoveTile() {
		// TODO Auto-generated method stub
		colour = Type.NOTHING;
		held = null;
	}

	@Override
	public void PlaceTile(Tile newtile) {
		// TODO Auto-generated method stub
		held = newtile;
	}


	
	
}
