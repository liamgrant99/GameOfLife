package life6visitor;

import java.util.ArrayList;
import java.util.List;

public class Cell {
	private CellState cellState;
	private List<Cell> neighbors;
	
	//Cell is automatically instantiated to be dead. 
	public Cell(){
		this.cellState = DeadStateSingleton.create();
		this.neighbors = new ArrayList<Cell>();
	}
	
	//Below three functions change the state of the cell. 
	public void live() {
		cellState = cellState.live();
	}
	
	public void die() {
		cellState = cellState.die();
	}
	
	public boolean isAlive() {
		return cellState.isAlive();
	}
	
	//Adds a neighbor to the ArrayList neighbors.
	public void addNeighbor(Cell c) {
		neighbors.add(c);
	}
	
	//Accepts the visitor method. 
	public void accept(LifeVisitor LV,  List<LifeCommand> cellCommandList) {
		cellState.accept(LV, this, cellCommandList);
	}
	
	//Returns the number of alive neighbors the cell has.
	public int nbrAliveNeighbors() {
		int count = 0;
		for(Cell c:neighbors) {
			if (c.isAlive()) {
				count++;
			}
		}
		return count;
	}
}
