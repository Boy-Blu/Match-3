import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Strat_Click implements Strategy_Match{

	@Override
	public void move(int i, int j, Board b) {	
		// Find all the cells with matching colours to the given cell on the board in position i,j
		ArrayList<Cell> moveList = new ArrayList<Cell>();
		Cell cur = b.getGrid()[i][j];
		
		if(b.getMCI().hasCell(cur)){
			b.getMCI().execute();
			return;
		}
		
		LinkedList<Cell> queue = new LinkedList<Cell>();
		ArrayList<Cell> visited = new ArrayList<Cell>();
		queue.add(cur);
		
		while(queue.size() != 0){
			cur = queue.poll();
			
			Cell[] breadth = cur.getBreadth();
			
			for(int n = 0; n < breadth.length; n = n+2){
				Cell next = breadth[n];
				if(next != null && !visited.contains(next) && next.getTile().getColour() == cur.getTile().getColour()){
					visited.add(next);
					queue.add(next);
				}
			}
		}
		
		// If no neighbors match the given cell then terminate move
		if(visited.size() < 2){
			visited.clear();
			return;
		}
		// Add all the matching neighbors to the MCI
		for(Cell c : visited){
			b.getMCI().add(new MoveCommandCell(c));
		}
	}

	@Override
	public boolean checkForMove(Board b) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
