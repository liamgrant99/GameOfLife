package life6visitor;

import java.awt.Color;

import edu.du.dudraw.DrawListener;

public abstract class LifeObserver implements DrawListener{
	protected GameOfLife GOL;
	
	//Holds an instance variable for the gameOfLife
	public LifeObserver(GameOfLife GOL) {
		this.GOL = GOL;
	}
	
	//Subclasses must drawGrid, DrawLives, and Update.
	protected abstract void drawGrid();
	
	protected abstract void drawLives();
	
	public abstract void update();
	
	//Key event handlings methods are included in concrete implementation. 
}
