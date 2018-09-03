package gamemodel;

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
				b.dropAndFill();
				b.makeMove();
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
		if (b.getMovelist().size()==0) { // Movelist is empty, Store new values in it
			for (int i = 0; i < b.getGrid().length; i++) {
				for (int j = 0; j < b.getGrid()[0].length; j++) {
					Cell c = b.getGrid()[i][j];
					int count =0;
					valid_move: for(Cell p: c.getBreadth()) {
						if (p!= null&& p.getTile()!=null&&p.getTile().getColour()==c.getTile().getColour()) {
							count ++;
						}
						if (count >=2) {
							b.getMovelist().add(c);
							break valid_move;
						}
					}
				}
			}
		}else { //Check moves in move_list
			for(int i =0; 0< b.getMovelist().size(); i++) {
				int count =0;
				Cell c = b.getMovelist().get(i);
				for(Cell p: c.getBreadth()) {
					if (p!= null&& p.getTile()!=null&&p.getTile().getColour()==c.getTile().getColour()) {
						count ++;
					}
					if (count >=2) {
						return true;
					}
				}
				//We are decreasing the move list size, 
				//so we have to decrease our counter
				i--;
				b.getMovelist().remove(c);
			}
		return checkForMove(b);//We removed all prev existing values, so we check for new values
		}
		return b.getMovelist().size()>0;
	}

}
