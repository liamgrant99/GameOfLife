package life6visitor;

// The main program used to invoke the game of life system.
 
public class Main {

    public static void main(String[] args) {
        // Create an instance of the game with a 20x20 life grid
    	
    	GameOfLife GOL = new GameOfLife(20, 20);
    	
    	//Shown in a 500x500 window. GOLUI is the UI for the game. 
    	LifeObserver GOLUI = new GameOfLifeUI("The Game of Life", GOL, 500, 500);
    }
}

