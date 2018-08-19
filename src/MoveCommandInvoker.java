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
	 * including cell m
	 * @param m Cell to be removed
	 * @return If Cell in the list or not
	 */
	public boolean remove(MoveCommand m) {

		for(int i =0; i<mc.size(); i++) {
			if(mc.get(i).getCell()==m.getCell()) {
				for(int j=i;i<mc.size();j++) {
					mc.get(j).removeCell();
					mc.remove(j);
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
}
