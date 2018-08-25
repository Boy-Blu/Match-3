import java.util.ArrayList;

public class Remove_Strat_Line implements Strategy_Remove {	
	private ArrayList<Cell> visted = new ArrayList<Cell>();
	private MoveCommandInvoker ref;
	@Override
	public void remove(Cell c) {
		if(c==null)throw new IllegalArgumentException();
		ref = c.getBoard().getMCI();
		remove(c, ((Tile_Line)c.getTile()).getDirection());
		
	}
	
	public void remove(Cell c, boolean d) {
		if (c == null||visted.contains(c))return;
		visted.add(c);
		if(!ref.hasCell(c)) ref.add(new MoveCommandCell(c));
		
		if (d) {// Go horizontal -> 0,4
			remove(c.getBreadth()[0],d);
			remove(c.getBreadth()[4],d);

		}else { // Go vertical -> 2, 6
			remove(c.getBreadth()[2],d);
			remove(c.getBreadth()[6],d);
		}
	}
}
