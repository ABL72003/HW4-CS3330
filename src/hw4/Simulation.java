package hw4;
import hw4.maze.Cell;
import hw4.maze.CellComponents;
import hw4.maze.Grid;
import hw4.maze.Row;

import java.util.ArrayList;

import hw4.game.Game;
import hw4.player.Player;

public class Simulation {
	
    public static void main(String[] args) {
    	
    	ArrayList<Row> list = new ArrayList<Row>();
    	
        Grid grid = new Grid(list);
        
        Player player = new Player(grid.getPlayerRow(), grid.getPlayerCol());
        
        Game game = new Game(grid);
        
        
        
        
        
	}

}
