
public class Cell_Standard extends Cell{

	public Cell_Standard() {
		this.held = null;
		this.colour=Type.NOTHING;
		this.breadth = new Cell [8];
	}

	@Override
	public void removeTile() {
		// TODO Auto-generated method stub
		if(held != null) {
			this.getTile().getSR().remove(this);
		}
		colour = Type.DELETED;
		held = null;
	}

	

	@Override
	public void setbeardth(int index, Cell c) {
		// TODO Auto-generated method stub
		if((index<0||index>8)){
			return;
			//Should Throw error
		}
		if(index>3) {
			c.setbeardth(index-4, this);
		}
		this.breadth[index]=c;
		return;
	}




}
