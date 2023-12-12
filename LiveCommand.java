package life6visitor;

public class LiveCommand extends LifeCommand{

	public LiveCommand(Cell theCell) {
		super(theCell);
	}

	//Execute causes the current cell to live. 
	@Override
	public void execute() {
		theCell.live();
	}
	
}
