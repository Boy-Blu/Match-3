
public abstract interface MoveCommand {
	public abstract void invoke();
	public abstract Cell getCell();
	public abstract void removeCell();
}
