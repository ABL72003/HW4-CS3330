package hw4;

import hw4.game.Game;
import hw4.maze.Grid;


public class Simulation {
	
    public static void main(String[] args) {
    	 
    	// Create a new game
    	Grid grid = new Grid();
        Game game = new Game(grid);
        
        //creates game 2
        Grid grid2 = new Grid();
        Game game2 = new Game(grid2);
        
        // Print the initial game state
        System.out.println("Initial game state:");
        System.out.println(game.getGrid()); 
        game.getGrid().printGrid();
        
        // Start the game
        System.out.println("Game started...");
        
        //prints the next game state
        System.out.println("Initial game state:");
        System.out.println(game2.getGrid()); 
        game2.getGrid().printGrid();
        
        // Start the game
        System.out.println("Game 2 started...");
        
	}

}
