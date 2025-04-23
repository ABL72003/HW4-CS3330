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
    public Grid(ArrayList<Row> row) {
        this.size = generateRand(3, 7);
        setRows(row);

        initializeGrid();
        placeExit();
        placePlayer();
    }
    
    public Grid(int i) {
    	this.size = i;
    	this.rows = new ArrayList<>();
    	
    	initializeGrid();
    	placeExit();
    	placePlayer();
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

            rows.add(row);
        }
    }
    /**
     * places exit location.
     */

    private void placeExit() {
        int exitRow = 0;
        Cell exitCell = rows.get(exitRow).getCellAt(0);
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

    public List<Row> getRows() {
        return rows;
    }

    public int getSize() {
        return size;
    }

    public Row getPlayerRow() {
        return rows.get(playerRow);
    }

    public Cell getPlayerCol() {
        return rows.get(playerRow).getCellAt(playerCol);
    }

	public void setRows(ArrayList<Row> row) {
		this.rows = row;
		
	}

	public void addRow(Row row) {
		this.rows.add(row);
		
	}
}