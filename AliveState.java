package life6visitor;

import java.util.List;

public class AliveState implements CellState{
	
	public AliveState() {
	}
	
	//Alive state is returned if asked for alive state. 
	public CellState live(){
		return this;
	}
	
	//Returns deadstate if asked to die. 
	public CellState die() {
		return DeadStateSingleton.create();
	}

	//True is returned if the cell is alive. 
	@Override
	public boolean isAlive() {
		return true;
	}

	//Calls visit alive cell on the LifeVisitor. 
	@Override
	public void accept(LifeVisitor LV, Cell c,  List<LifeCommand> cellCommandList) {
		LV.visitAliveCell(c, cellCommandList);
	}

}
