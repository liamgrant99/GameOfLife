package life6visitor;

import java.awt.Color;

import edu.du.dudraw.Draw;
import edu.du.dudraw.DrawListener;

public class GameOfLifeUI extends LifeObserver implements DrawListener {
	private int width;
    private int height;
    private Draw window;
	
	public GameOfLifeUI(String title, GameOfLife GOL,int width, int height) {
		super(GOL);
		this.width = width;
		this.height = height;
		
		this.width = width;
		this.height = height;
	
	    
        // Setup the DuDraw board
        window = new Draw(title);
        window.setCanvasSize(width, height);
        window.setXscale(0, width);
		window.setYscale(0, height);
       
		// Add the mouse/key listeners
        window.addListener(this);
        
        //Attaches as an observer to the gameOfLife
        this.GOL.attachObserver(this);
        
        // Draw the initial board
	    update();
	}
	
	
	public void keyPressed(int key) {
		// This is the advance button
		// Only advance for spacebar (ascii 32)
		if (key==32) {
			GOL.advance();
		}
	}

	@Override
	public void keyReleased(int key) {
		// Do nothing
	}

	@Override
	public void keyTyped(char key) {
		// Do nothing
	}

	@Override
	public void mouseClicked(double arg0, double arg1) {
		// Do nothing
	}

	@Override
	public void mouseDragged(double x, double y) {
		// Do nothing
	}

	@Override
	public void mousePressed(double x, double y) {
		// This is the toggle of grid locations
		int cellWidth = width / GOL.getCols();
        int cellHeight = height / GOL.getRows();
        
        int cellLocRow = (int)(y / cellHeight);
        int cellLocCol = (int)(x / cellWidth);
        
        //If the cell clicked on is alive, it is told to die. 
        if (GOL.getCell(cellLocRow, cellLocCol).isAlive()) {
        	GOL.getCell(cellLocRow, cellLocCol).die();
        }else {
        	//If the cell clicked on is dead, it is told to live. 
        	GOL.getCell(cellLocRow, cellLocCol).live();
        }
       
		update();        
	}

	@Override
	public void mouseReleased(double x, double y) {
		// Do nothing
	}
	
	protected void drawLives() {
		//Draws the red squares that are alive. 
    	int cellWidth = width / GOL.getCols();
        int cellHeight = height / GOL.getRows();
        
    	window.setPenColor(Color.red);
        for (int i = 0; i < GOL.getRows(); i++) {
        	for (int j = 0; j < GOL.getCols(); j++) {
        		if (GOL.getCell(i, j).isAlive()) {
        			// This is the center and half width/height
        			window.filledRectangle((j * cellWidth)+(cellWidth/2), (i * cellHeight)+(cellHeight/2), cellWidth/2, cellHeight/2);
                }
            }
        }
    }

	//Below needs to become update observers
	@Override
	public void update() {
		// Redraw the entire board
		window.clear(Color.white);  // Clear in white
	 	drawGrid();
		drawLives();
	}

	@Override
	protected void drawGrid() {
        
		//Black is set as the pen color. 
    	window.setPenColor(Color.black);
 		
    	//Each cell is the width of the grid divided by the number of rows. 
        int cellWidth = width / GOL.getCols();
        int cellHeight = height / GOL.getRows();
     
        //The row lines are drawn.
        for (int i = 0; i <= GOL.getRows(); i++) {
        	window.line(0, i * cellHeight, this.width, i * cellHeight);
        }
        
        //The column lines are drawn. 
        for (int i = 0; i <= GOL.getCols(); i++) {
        	window.line(i * cellWidth, 0, i * cellWidth, this.height);
        }
    }
}
