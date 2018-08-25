
public class Match_Strat_Chain implements Strategy_Match{

	@Override
	public void move(int i, int j, Board b) {
		// TODO Auto-generated method stub
		int m = b.getGrid()[0].length;
		int n = b.getGrid().length;
		
		
		if ((i<0||i>=m)&&(j<0||j>=n)) {
			//reject move
			return;
		} 
		Cell insert = b.getGrid()[i][j];
		if(b.getMCI().getColor()==-1) {
			// Move list is empty
			b.getMCI().add(new MoveCommandCell(insert));
		}else if(b.getMCI().hasCell(insert)){
			//a Move is repeated
			if(b.getMCI().getLastCell()==insert&&b.getMCI().getSize()>2) {
				//want to make move
				b.getMCI().execute();
			}else {
				//want to remove everything
				b.getMCI().remove(insert);
			}	
		}else if(b.getMCI().getColor() ==0 || 
				b.getMCI().getColor() == insert.getTile().getColour() ||
				insert.getTile().getColour()==0) {
			// Same Colour as the other Cells, or list is filled with 
			// colour 0 tiles or added Tile is 0
			
			
			//Checks if right beside each other
			for(Cell c: b.getMCI().getLastCell().getBreadth()) {
				if(c != null && c == insert) {
					b.getMCI().add(new MoveCommandCell(insert));
					break;
				}
			}
		}else {
			//reject move
			return;
		}
		return;
	}

	@Override
	public boolean checkForMove(Board b) {
		// TODO Auto-generated method stub
		return true;
	}

}
