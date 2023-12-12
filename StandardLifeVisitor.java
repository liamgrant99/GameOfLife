package life6visitor;

import java.util.List;

public class StandardLifeVisitor extends LifeVisitor{
	
	public StandardLifeVisitor(Cell[][] cells) {
		super(cells);
	}
	
	
	//Calls the cell's accept method.
	@Override
	public void visit(Cell c, List<LifeCommand> cellCommandList) {
		c.accept(this, cellCommandList);
	}
	
	//If the dead cell has three neighbors, an alive command is called on the cell. 
	@Override
	public void visitDeadCell(Cell c,  List<LifeCommand> cellCommandList) {
		int n;
		
		n = c.nbrAliveNeighbors();
		
		if (n == 3) {
        	cellCommandList.add(new LiveCommand(c));
        } 
	}
	
	//If the alive cell does not have two or three neighbors, a die command is called on the cell. 
	@Override
	public void visitAliveCell(Cell c,  List<LifeCommand> cellCommandList) {
		int n;
		n = c.nbrAliveNeighbors();
		
		if (!(n == 2 || n == 3)) {
        	cellCommandList.add(new DieCommand(c));
        } 
	}


}
