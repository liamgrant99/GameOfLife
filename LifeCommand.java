package life6visitor;

public abstract class LifeCommand {
	protected Cell theCell;
	
	//Holds a cell as the instance variable. 
	public LifeCommand(Cell theCell) {
		this.theCell = theCell;
	}
	
	//Each command class must have an execute method. 
	public abstract void execute();

}
