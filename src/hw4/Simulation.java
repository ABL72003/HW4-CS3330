package hw4;

import hw4.game.Game;

public class Simulation {
	
    public static void main(String[] args) {
    	 // Create a new game
        Game game = new Game(5);
        
        // Print the initial game state
        System.out.println("Initial game state:");
        System.out.println(game.getGrid()); 
        game.getGrid().printGrid();
        
        // Start the game
        System.out.println("Game started...");
        
	}

}
