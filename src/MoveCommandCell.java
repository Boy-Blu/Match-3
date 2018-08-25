
public class MoveCommandCell implements MoveCommand {

	Cell c;

	public MoveCommandCell(Cell temp) {
		// TODO Auto-generated constructor stub
		this.c = temp;
		c.setColour(Type.SELECTED);
	}

	@Override
	public void invoke() {
		c.removeTile();
	}

	@Override
	public Cell getCell() {
		// TODO Auto-generated method stub
		return c;
	}


	public void removeCell(){
		c.setColour(Type.NOTHING);
	}

}
