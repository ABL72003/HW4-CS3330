package hw4.maze;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 */
public class Grid {

    private int size;
    private ArrayList<Row> rows;
    private int playerRow;
    private int playerCol;

    /**
     * Constructs the Grid with a random size and sets up the maze.
     * @param row 
     */
    public Grid() {
    	this.rows = new ArrayList<>();
        this.size = generateRand(3, 7);
        initializeGrid();
        placeExit();
        placePlayer();
    }
    
    /**
     * Constructor that takes an int between 3 and 7 to create a NXN randomly generated grid
     * @param i
     */
    public Grid(int i) {
    	this.size = i;
    	this.rows = new ArrayList<>();
    	
    	initializeGrid();
    	placeExit();
    	placePlayer();
    }
    
    /**
     * Constructor that takes rows to create the grid
     * @param rows2
     */
    public Grid(ArrayList<Row> rows2) {
		this.rows = rows2;
	}

	/**
     * helper function for random gen
     */
    private int generateRand(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
    
    /**
     * Initializes grid.
     */
    private void initializeGrid() {
        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            Row row = new Row();

            for (int j = 0; j < size; j++) {
                Cell cell = new Cell();

                // Ensure one aperture in the cell
                int apertureIndex = generateRand(0, 3);
                CellComponents[] sides = new CellComponents[4]; // up, down, left, right

                for (int k = 0; k < 4; k++) {
                    if (k == apertureIndex) {
                        sides[k] = CellComponents.APERTURE;
                    } else {
                        sides[k] = rand.nextBoolean() ? CellComponents.WALL : CellComponents.APERTURE;
                    }
                }

                cell.setComponents(sides[0], sides[1], sides[2], sides[3]);
                row.addCell(cell);
            }

            this.rows.add(row);
        }
    }
    
    /**
     * places exit location.
     */
    private void placeExit() {
        Cell exitCell = rows.get(0).getCellAt(0);
        exitCell.setLeft(CellComponents.EXIT);
    }
    
    /**
     * places agent cell.
     * @param newRow
     * @param newCol
     */
    private void placePlayer() {
        this.playerRow = size-1;
        this.playerCol = size-1;
        rows.get(playerRow).getCellAt(playerCol).setPlayer(true);
    }
    
    /**
     * updates agent location
     * @param newRow
     * @param newCol
     */
    public void updateAgentPosition(int newRow, int newCol) {
        rows.get(playerRow).getCellAt(playerCol).setPlayer(false);
        rows.get(newRow).getCellAt(newCol).setPlayer(true);
        playerRow = newRow;
        playerCol = newCol;
    }

    
    /**
     * prints grid 
     */
    public void printGrid() {
        for (int i = 0; i < size; i++) {
            Row row = rows.get(i);
            for (int j = 0; j < size; j++) {
                Cell cell = row.getCellAt(j);
                if (cell.hasPlayer()) {
                    System.out.print("A ");
                } else if (cell.getLeft() == CellComponents.EXIT) {
                    System.out.print("E ");
                } else {
                    System.out.print("S ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    
    /**
     * Returns rows
     * @return
     */
    public List<Row> getRows() {
        return rows;
    }
    
    /**
     * Returns size
     * @return
     */
    public int getSize() {
        return size;
    }
    
    /**
     * Returns what row the player is in
     * @return
     */
    public Row getPlayerRow() {
        return rows.get(playerRow);
    }
    
    /**
     * Returns what column the player is in
     * @return
     */
    public Cell getPlayerCol() {
        return rows.get(playerRow).getCellAt(playerCol);
    }
    
    /**
     * Sets the rows 
     * @param row
     */
	public void setRows(ArrayList<Row> row) {
		this.rows = row;
		
	}

	/**
	 * Adds a row to the list of rows
	 * @param row
	 */
	public void addRow(Row row) {
		this.rows.add(row);
		
	}
}