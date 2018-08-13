
public class Strat_Chain implements Strategy_Match{

	@Override
	public void move(int i, int j, Board b) {
		// TODO Auto-generated method stub
		int m = b.getGrid()[0].length;
		int n = b.getGrid().length;
		
		if (((i<0||i>=m)&&(j<0||j>=n))&&(i!=-1&&j!=-1)) {
			//Move invalid
			return;
		} else if (i==-1&&j==-1){
			//move clears selection
			
			//Add something to remove current status
			b.getMovelist().clear();
		}
		
		if(b.getMovelist().size()<=0) {
			//Empty List
			b.getMovelist().add(b.getGrid()[i][j]);
			
			//Update the tile
			
			
		}else if(b.getGrid()[i][j] == b.getMovelist().get(b.getMovelist().size())) {
			//Last move is made move, Remove everything on Board
			if (b.getMovelist().size()>2) {
				//Valid Clearing move
				//Update all tile
				b.getMovelist().clear();
			}else {
				
				
		
			}
		}
		b.getMovelist().get(b.getMovelist().size());
		
		
		
	}

	@Override
	public boolean checkForMove(Board b) {
		// TODO Auto-generated method stub
		return false;
	}

}
