
public class Cell_Standard extends Cell{

	public Cell_Standard() {
		this.held = null;
		this.colour=Type.NOTHING;
		this.breadth = new Cell [8];
	}

	@Override
	public Tile getTile() {
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
	public void removeTile() {
		// TODO Auto-generated method stub
		colour = Type.DELETED;
		held = null;
	}

	@Override
	public void setTile(Tile newtile) {
		// TODO Auto-generated method stub
		held = newtile;
	}

	@Override
	public void setbeardth(int index, Cell c) {
		// TODO Auto-generated method stub
		if((index<0||index>8)){
			return;
		}
		if(index>3) {
			c.setbeardth(index-4, this);
		}
		this.breadth[index]=c;
		return;
	}
	

	
	
}
