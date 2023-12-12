package life6visitor;

import java.util.List;

public class DeadState implements CellState {
	
	public DeadState() {
	}
	
	//Live returns the aliveState singleton. 
	public CellState live() {
		return AliveStateSingleton.create();
	}
	
	//Returns DeadState
	public CellState die(){
		return this;
	}

	//The cell is dead, so isAlive returns false. 
	@Override
	public boolean isAlive() {
		return false;
	}
	
	//Calls visitDeadCell on the lifeVisitor and the inputted cell. 
	public void accept(LifeVisitor LV, Cell c,  List<LifeCommand> cellCommandList) {
		LV.visitDeadCell(c, cellCommandList);
	}
	
}
