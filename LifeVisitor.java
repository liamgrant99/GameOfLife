package life6visitor;

import java.util.List;

public abstract class LifeVisitor {
	//Visitors must have access to all the cells.
	protected Cell[][] cells;

	public LifeVisitor(Cell[][] cells){
		this.cells = cells;
	}
	
	//Abstract methods for visitors. Each vistor must visit the cells, and have specific methods for visiting dead cells and alive cells. 
	public abstract void visit(Cell c, List<LifeCommand> cellCommandList);
	public abstract void visitDeadCell(Cell c, List<LifeCommand> cellCommandList);
	public abstract void visitAliveCell(Cell c, List<LifeCommand> cellCommandList);
	
}
