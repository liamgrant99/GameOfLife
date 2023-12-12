package life6visitor;

import java.util.List;

public interface CellState {
	//All cell states must live, die, and have an isAlive variable. They must also all be able to accept a visitor. 
	abstract public CellState live();
	abstract public CellState die();
	abstract public boolean isAlive();
	abstract public void accept(LifeVisitor LV, Cell c, List<LifeCommand> cellCommandList);
}
