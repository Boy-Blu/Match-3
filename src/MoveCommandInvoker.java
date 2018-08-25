import java.util.ArrayList;

public class MoveCommandInvoker {
	private ArrayList<MoveCommand> mc = new ArrayList<MoveCommand>();

	/**
	 * Executes all move commands
	 */
	public void execute() {
		for(int i =0; i<mc.size(); i++) {
			(mc.get(i)).invoke();
		}
		mc.clear();
	}

	/**
	 * Adds a new MoveCommand
	 * @param m - the move command
	 */
	public void add(MoveCommand m) {
		mc.add(m);
	}

	/**
	 * Removes all Cell Commands up to &
	 * including cell c
	 * @param m Cell to be removed
	 * @return If Cell in the list or not
	 */
	public boolean remove(Cell c) {

		for(int i =0; i<mc.size(); i++) {
			if(mc.get(i).getCell()==c) {
				int s = mc.size();
				for(int j=i;j<s;j++) {
					mc.get(i).removeCell();
					mc.remove(i);
					
				}
				return true;
			}
		}
		return false;
	}

	public boolean hasCell(Cell c) {
		for(int i =0; i<mc.size(); i++) {
			if(mc.get(i).getCell()==c) {
				return true;
			}
		}
		return false;
	}


	/**
	 * Gets the Colour of what occupies the move Command list
	 * @return Colour of the Cell in mc or -1 if list is empty
	 */
	public int getColor() {
		int col = -1;
		for(MoveCommand i: mc) {
			col=i.getCell().getTile().getColour();
			if(col>0) {
				return col;
			}
		}
		return col;
	}

	/**
	 * Gets the last Cell in the mc list
	 * @return The last Cell or Null if the list is empty
	 */
	public Cell getLastCell() {
		if( mc.size()==0) {
			return null;
		}

		return mc.get(mc.size()-1).getCell();
	}

	/**
	 * get the size of mc
	 * @return mc size
	 */
	public int getSize() {
		return mc.size();
	}
}
