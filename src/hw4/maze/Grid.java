package hw4.maze;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 */
public class Grid {

    private int size;
    private List<Row> rows;
    private int agentRow;
    private int agentCol;

    /**
     * Constructs the Grid with a random size and sets up the maze.
     * @param rows2 
     */
    public Grid(ArrayList<Row> rows2) {
        this.size = generateRand(3, 7);
        setRows(rows2);

        initializeGrid();
        placeExit();
        placeAgent();
    }
    
    public Grid(int i) {
    	this.size = i;
    	this.rows = new ArrayList<>();
    	
    	initializeGrid();
    	placeExit();
    	placeAgent();
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
    private void placeAgent() {
        this.agentRow = generateRand(0, size - 1);
        this.agentCol = generateRand(0, size - 1);
        rows.get(agentRow).getCellAt(agentCol).setAgent(true);
    }
    
    /**
     * updates agent location
     * @param newRow
     * @param newCol
     */

    public void updateAgentPosition(int newRow, int newCol) {
        rows.get(agentRow).getCellAt(agentCol).setAgent(false);
        rows.get(newRow).getCellAt(newCol).setAgent(true);
        agentRow = newRow;
        agentCol = newCol;
    }

    
    /**
     * prints grid 
     */
    public void printGrid() {
        for (int i = 0; i < size; i++) {
            Row row = rows.get(i);
            for (int j = 0; j < size; j++) {
                Cell cell = row.getCellAt(j);
                if (cell.hasAgent()) {
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

    public int getAgentRow() {
        return agentRow;
    }

    public int getAgentCol() {
        return agentCol;
    }

	public void setRows(List<Row> row) {
		this.rows = row;
		
	}

	public void addRow(Row row) {
		this.rows.add(row);
		
	}
}