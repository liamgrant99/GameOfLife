package life6visitor;

public class DieCommand extends LifeCommand{
	public DieCommand(Cell theCell) {
		super(theCell);
	}
	
	@Override
	public void execute() {
		//Die command kills the cell. 
		theCell.die();
	}

}
