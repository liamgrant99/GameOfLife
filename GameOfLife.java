package life6visitor;

import java.util.ArrayList;
import java.util.List;

public class GameOfLife {
	
	private int rows;
    private int cols;
    private Cell grid[][]; 
    
    // lifeObservers contains all the observers. 
    private List<LifeObserver> lifeObservers;
    
    public GameOfLife(int rows, int cols) {
    	//Rows, columns, and grids are instantiated.
    	this.rows = rows;
		this.cols = cols;
		this.grid = new Cell[rows][cols];
		
		//lifeObservers is instantiated as an ArrayList
		this.lifeObservers = new ArrayList<LifeObserver>();
        
		//Grid is initially set up
        setupGrid(this.grid); 
    }
    
    
    public void advance() {
    	//Adding all the commands we want to do to a cell to a list, and then executing them once all computations are completed, instead of creating new list. 
        //All computations must be done before modifying the grid. 
    	List<LifeCommand> cellCommandList = new ArrayList<LifeCommand>();
        StandardLifeVisitor SLV = new StandardLifeVisitor(grid);
    	
        for (int i = 0;i<rows;i++) {
			for(int j = 0;j<cols;j++) {
				SLV.visit(grid[i][j], cellCommandList);
			}	
		}
 
        //All commands are executed. 
        for (LifeCommand lifeCommand:cellCommandList) {
        	lifeCommand.execute();
        }
        
        notifyObservers();
    }
    
    private void setupGrid(Cell[][] grid) {
    	for (int i = 0; i < rows; i++) {
        	for (int j = 0; j < cols; j++) {
        		//Create new cell at the location
        		grid[i][j] = new Cell();
            }
        }
    	
    	
    	//Adds neighbors to each cell.
    	for (int r=0;r<rows;r++) {
    		for (int c=0;c<cols;c++) {
    			int n = 0;
    	        int x = 0;
    	        int y = r - 1;
    	        if (y < 0) {
    	            y = rows - 1;
    	        }
    	        for (int rCt = 1; rCt <= 3; rCt++) {
    	            x = c - 1;
    	            if (x < 0) {
    	                x = cols - 1;
    	            }
    	            for (int cCt = 1; cCt <= 3; cCt++) {
    	                if (x != c || y != r) {
    	                    grid[c][r].addNeighbor(grid[x][y]);
    	                }
    	                x = (x + 1) % cols;
    	            }
    	            y = (y + 1) % rows;
    	        }
    		}
    	}	
    }
    
    public void attachObserver(LifeObserver LO) {
    	//Attaches the inputted observer to the observers. 
    	this.lifeObservers.add(LO);
    }
	
    public void detachObserver(LifeObserver LO) {
    	//Detaches the inputted observer from the observers. 
    	this.lifeObservers.remove(LO);
    }
    
    public void notifyObservers() {
    	//Update is called on each observer. 
    	for (LifeObserver LO: lifeObservers) {
    		LO.update();
    	}
    }
    
    //Returns the number of rows. 
	public int getRows() {
		return this.rows;
	}
	
	//Returns the number of columns. 
	public int getCols() {
		return this.cols;
	}
	
	//Returns the cell at the grid location. 
	public Cell getCell(int row, int col) {
		return this.grid[row][col];
	}
	
}
