package hw4.maze;

import java.util.Random;

/**
 * Represents the NxN maze grid with cells containing directions and an exit
 */
public class Grid {

    private int size;
    private Cell[][] cells;
    private int agentRow;
    private int agentCol;

    /**
     * Constructs a Grid with a random size (3-7), initializes cell
     * 
     */
    public Grid() {
        this.size = generateRand(3, 7);  // Grid size between 3 and 7
        this.cells = new Cell[size][size];

        initializeGrid(); // Fill grid with cells and at least one APERTURE each

        placeExit(); // Put exactly one EXIT
        placeAgent(); // Random agent start position
    }

    private int generateRand(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    private void initializeGrid() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                Cell cell = new Cell();

                // Create a component array: [up, down, left, right]
                CellComponents[] components = new CellComponents[4];

                // Ensure at least one APERTURE
                int apertureIndex = generateRand(0, 3);

                for (int i = 0; i < 4; i++) {
                    if (i == apertureIndex) {
                        components[i] = CellComponents.APERTURE;
                    } else {
                        components[i] = Math.random() < 0.5 ? CellComponents.WALL : CellComponents.APERTURE;
                    }
                }

                // Set components: up, down, left, right
                cell.setComponents(components[0], components[1], components[2], components[3]);

                cells[row][col] = cell;
            }
        }
    }

    private void placeExit() {
        int exitRow = generateRand(0, size - 1);
        cells[exitRow][0].setLeftComponent(CellComponents.EXIT);
    }

    private void placeAgent() {
        Random random = new Random();
        agentRow = generateRand(0, size - 1);
        agentCol = generateRand(0, size - 1);
        cells[agentRow][agentCol].setAgent(true);
    }

    public Cell[][] getCells() {
        return cells;
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

    public void updateAgentPosition(int newRow, int newCol) {
        // Clear old position
        cells[agentRow][agentCol].setAgent(false);
        // Set new position
        cells[newRow][newCol].setAgent(true);
        agentRow = newRow;
        agentCol = newCol;
    }

    /**
     * Prints the grid using:
     * - 'A' for agent
     * - 'E' for cell with EXIT on left
     * - 'S' for a regular space
     */
    public void printGrid() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                Cell cell = cells[row][col];
                if (cell.hasAgent()) {
                    System.out.print("A ");
                } else if (cell.getLeftComponent() == CellComponents.EXIT) {
                    System.out.print("E ");
                } else {
                    System.out.print("S ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}