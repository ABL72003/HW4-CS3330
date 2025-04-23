package hw4;
import hw4.maze.Cell;
import hw4.maze.Grid;
import hw4.maze.Row;
import hw4.game.Game;
import hw4.player.Player;

public class Simulation {

    public static void main(String[] args) {
    	
        Grid grid = new Grid();
        
        Player player = new Player(new Row(), new Cell());
        
        // Create the game using the grid and start playing
        Game game = new Game(grid); // Game can be initialized with the grid
       
        
        game.play(grid, player);

	}

}
