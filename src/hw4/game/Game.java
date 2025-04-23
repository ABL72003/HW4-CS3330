package hw4.game;

import java.util.Random;

import hw4.maze.Cell;
import hw4.maze.CellComponents;
import hw4.maze.Grid;
import hw4.maze.Row;
import hw4.player.Movement;
import hw4.player.Player;

public class Game {
	private Game game;
	private Grid grid;
	
	
	
	/**
	 * Constructor that takes a grid already made to start the game
	 * @param grid
	 */
	public Game(Grid grid) {
		this.game.grid = grid;
	}
	
	/**
	 * Constructor that takes an int variable to create a random grid
	 * @param i
	 */
	public Game(int i) {
		this.game.grid = createRandomGrid(i);
	}
	
	/**
	 * Returns the grid 
	 * @return
	 */
	public Grid getGrid() {
		return game.grid;
	}
	
	/**
	 * Set the game grid equal to the param grid
	 * @param grid
	 */
	public void setGrid(Grid grid) {
		this.game.grid = grid;
	}
	
	private int randWallOrAperture() {
		Random random = new Random();
		int movement;
		
		movement = random.ints(0, 1).findFirst().getAsInt(); //0 is wall 1 is aperture
		
		return movement;
		
	}
	
	private CellComponents wallOrAperture(int randNum) {
        switch (randNum) {
        case 0:
        	return CellComponents.WALL;
       	 
        case 1:
        	return CellComponents.APERTURE;
       
            }
		return CellComponents.WALL ;
    }	
	
	/**
	 * Creates a randomly generated NXN grid between 3 and 7
	 * @param i
	 * @return
	 */
	public Grid createRandomGrid(int i) {
		// TODO Auto-generated method stub
		if (i < 3 || i > 7) {
			return null;
		}
		Grid grid = new Grid();
		Row row;
		
		
		
		for (int j = 0; j < i; j++) {//each row
			
			row = new Row();
			
			for(int k = 0; k < i; k++) {//each cell
				Cell cell = new Cell();
				
				int up;
				int down;
				int left;
				int right;
				
				int count = 0; //if count is 0 after for loop, there were no apertures
				while (count == 0) {
					
					up = randWallOrAperture();
					if (up == 1) {
						count ++;
					}
					
					down = randWallOrAperture();
					if (down == 1) {
						count ++;
					}
					
					left = randWallOrAperture();
					if (left == 1) {
						count ++;
					}
					
					right = randWallOrAperture();
					if (right == 1) {
						count ++;
					}	
					
					cell.setUp(wallOrAperture(up));
					cell.setDown(wallOrAperture(down));
					cell.setLeft(wallOrAperture(left));
					cell.setRight(wallOrAperture(right));
				}
				
				row.addCell(cell);
				
			}
			grid.addRow(row); 
		}
		
		

		return null;
	}
		
	/**
	 * If components is Aperture or Exit, returns true. If wall returns false.
	 * @param cell
	 * @param components
	 * @return Returns true or false
	 */
	 private boolean cellComponent(Cell cell, CellComponents components) {
         switch (components) {
         case APERTURE:
        	 return true;
         case WALL:
        	 return false;
         case EXIT:
        	 return true;
             }
		return false;
     }	
	
	 /**
	  * If movement is Up, Down, left, or Right, calls cellComponent. If something else, returns false. 
	  * @param movement
	  * @param cell
	  * @return returns true or false
	  */
     private boolean movement(Movement movement, Cell cell) {
    	CellComponents components;
    	boolean move;
        switch (movement) {
        
        case UP:
           components = cell.getUp();
           move = cellComponent(cell, components);
           return move;
           
        case DOWN:
        	components = cell.getDown();
            move = cellComponent(cell, components);
            return move;
            
        case LEFT:
        	components = cell.getLeft();
            move = cellComponent(cell, components);
            return move;
            
        case RIGHT:
        	components = cell.getRight();
            move = cellComponent(cell, components);
            return move;
            
        default:
            System.out.println("Not a correct movement.");
            return false;
            }
    }
    
    /**
     * Returns true if the player goes through the exit or an aperture. Returns false if player runs into a wall.
     * @param movement
     * @param player
     * @return returns true or false. 
     */
	public boolean play(Movement movement, Player player) {
		Cell cell = player.getCurrentRow().getCurrentCell();
		boolean move = movement(movement, cell);
		
		return move;
	}

	/**
	 * To string override for the Game
	 */
	@Override
	public String toString() {
		return "Game [grid="+ game + "]";
	}
}
