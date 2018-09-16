package gamemodel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Match_Strat_Click implements Strategy_Match{

	@Override
	public void move(int i, int j, Board b) {	
		// Find all the cells with matching colours to the given cell on the board in position i,j
		Cell cur = b.getGrid()[i][j];

		// Fix thing
		if(b.getMCI().getSize() != 0 && !b.getMCI().hasCell(cur)){
			System.out.println(b.getMCI().getSize());
			b.getMCI().removeAll();
		}
		else if(b.getMCI().hasCell(cur)){ // Confirm the previously made move's selection
			b.getMCI().execute();
			b.dropAndFill();
			b.makeMove();
			return;
		}
		
		// List of visited cells (matching cells) and queue for breadth first search
		LinkedList<Cell> queue = new LinkedList<Cell>();
		ArrayList<Cell> visited = new ArrayList<Cell>();
		queue.add(cur);

		// Perform BFS and only add neighbours with matching colour tiles to the visited list
		while(queue.size() != 0){
			cur = queue.poll();

			Cell[] breadth = cur.getBreadth();

			for(int n = 0; n < breadth.length; n = n+2){
				Cell next = breadth[n];
				// cur.getColour() != Type.DELETED && next.getColour() != Type.DELETED condition ONLY for testing!!
				if(next != null && cur.getColour() != Type.DELETED && next.getColour() != Type.DELETED && !visited.contains(next) && next.getTile().getColour() == cur.getTile().getColour()){
					visited.add(next);
					queue.add(next);
				}
			}
		}

		// If no neighbors match the given cell's tile colour then terminate move
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

		Cell[][] grid = b.getGrid();

		// Iterate through entire grid checking every other cell if it has a neighbouring cell with a matching tile colour
		for(int i = 0; i < grid.length * grid[0].length; i = i+2){
			//			System.out.print("g" + i + " ");
			Cell cur = grid[i/grid.length][i%grid.length];

			// Remove this conditional, testing only! No cell at ALL should be of Type deleted when we're running checkForMove! Purely for testing!
			if(cur.getColour() != Type.DELETED){
				Cell[] breadth = cur.getBreadth();
				//				System.out.print(cur.getTile().getColour() + " ");

				// Check the Cells in the 4 cardinal directions around the current Cell if they have a matching tile colour.
				// If there exists any pair that matches then a move is still available.
				for(int n = 0; n < breadth.length; n = n+2){
					//					System.out.print("b" + n + " ");
					Cell next = breadth[n];
					// next.getColour() != Type.DELETED conidition ONLY for testing!!
					if(next != null && next.getColour() != Type.DELETED && cur.getTile().getColour() == next.getTile().getColour()){
						//						System.out.print(","+breadth[n].getTile().getColour() + " ");
						//						System.out.println();
						return true;
					}
				}
			}
		}
		return false;
	}


}
