package hw4.player;

import hw4.maze.Cell;
import hw4.maze.Row;

/**
 * File that creates the Player and basically its X and Y coordinates on the playing grid.
 */
public class Player {

    //gitY coordinate
    private Row currentRow;

    //X coordinate
    private Cell currentCell;

    /**
     * Constructor that maps the coordinates of a player given the row and cell.
     * @param row   
     * @param cell
     */
    public Player(Row row, Cell cell) {
        this.currentRow = row;
        this.currentCell = cell;
    }

    /**
     * Returns current row
     * @return
     */
    public Row getCurrentRow() {
        return currentRow;
    }
    
    /**
     * Sets current row
     * @param currentRow
     */
    public void setCurrentRow(Row currentRow) {
        this.currentRow = currentRow;
    }
    
    /**
     * Returns current cell
     * @return
     */
    public Cell getCurrentCell() {
        return currentCell;
    }
    
    /**
     * Sets current cell
     * @param currentCell
     */
    public void setCurrentCell(Cell currentCell) {
        this.currentCell = currentCell;
    }

    /**
     *Overrides toString to return player position.
     */
    @Override
    public String toString() {
        return "Player [currentCell=" + currentCell + ", currentRow=" + currentRow + "]";
    }
}
