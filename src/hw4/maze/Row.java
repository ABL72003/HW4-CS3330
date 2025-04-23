package hw4.maze;


import java.util.ArrayList;


public class Row {
/**
 * Private instance variable list of Cell
 */
	private ArrayList<Cell> cells;
	
	/*
	 * constructor to declare a empty array list of cells
	 */
	public Row() {
		this.cells = new ArrayList<Cell>();
	}
	
	/**
	 *  Constructor with Parameter
	 * @param cells array list
	 */
	public Row(ArrayList<Cell> cells) {
		this.cells = cells;
	}
/**
 * Gets the cells in a given row 
 * @returns a cell
 */
	public ArrayList<Cell> getCells() {
		
		return (ArrayList<Cell>)cells; 
	}
	
	/**
	 * replaces list with new list of cells
	 * @param cells
	 */
	public void setCells(ArrayList<Cell> cells) {
		this.cells = cells;
	}
	/**
	 * Add cells to a given row
	 * @param cell
	 */
	public void addCell(Cell cell) {
		cells.add(cell);
	}


	/**
	 * Gives a int index to locate a certain index of cell
	 * @param index
	 * @return cell at given index
	 */
	public Cell getCellAt(int index) {
		
		return cells.get(index);
	}
	/**
	 * To string override for the Row
	 */
	@Override
	public String toString() {
		
		return "Row [cells=" + cells + "]";
	}
	
}
