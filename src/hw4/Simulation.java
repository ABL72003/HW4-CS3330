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

    	 //Create game 3
	      int randomSize = 3 + (int)(Math.random() * 5); // Random int from 3 to 7
        Game game3 = new Game(randomSize);

        
        //Print game 1 initial state
        System.out.println("Initial game state:");
        System.out.println(game.getGrid()); 
        game.getGrid().printGrid();
        
        //Starts game 1
        System.out.println("Game started...");
        
        //prints game 2 initial state
        System.out.println("Initial game state:");
        System.out.println(game2.getGrid()); 
        game2.getGrid().printGrid();
        
        // Starts game 2
        System.out.println("Game 2 started...");
      
       //Prints game 3 initial state
        System.out.println("Initial game state:");
        System.out.println(game3.getGrid()); 
        game3.getGrid().printGrid();
        
        //Starts game 3
        System.out.println("Game started...");
        
	}

}
