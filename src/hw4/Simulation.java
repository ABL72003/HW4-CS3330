package hw4;

import hw4.game.Game;

public class Simulation {
	
    public static void main(String[] args) {
    	 //Create a new game
	int randomSize = 3 + (int)(Math.random() * 5); // Random int from 3 to 7
        Game game = new Game(randomSize);
        
        //Print the initial game state
        System.out.println("Initial game state:");
        System.out.println(game.getGrid()); 
        game.getGrid().printGrid();
        
        //Start the game
        System.out.println("Game started...");
        
	}

}
