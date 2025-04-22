package hw4.maze;

public class Cell {
	private CellComponents up;
	private CellComponents bottom;
	private CellComponents left;
	private CellComponents right;
	
	private Cell cell;
	
	/**
	 * This Constructor sets all positions to null
	 */
	public Cell () {
		this.cell.up = null;
		this.cell.bottom = null;
		this.cell.left = null;
		this.cell.right = null;
	}
	
	/**
	 * This Constructor sets each position to the given param
	 * @param up
	 * @param bottom
	 * @param left
	 * @param right
	 */
	public Cell (CellComponents up, CellComponents bottom, CellComponents left, CellComponents right) {
		this.cell.up = up;
		this.cell.bottom = bottom;
		this.cell.left = left;
		this.cell.right = right;
	}
	
	/**
	 * Gets cell component at up position
	 * @return returns cell component at up Position
	 */
	public CellComponents getUp() {
		return cell.up;
	}
	
	/**
	 * Gets cell component at bottom position
	 * @return returns cell component at bottom position
	 */
	public CellComponents getDown() {
		return cell.bottom;
	}
	
	/**
	 * Gets cell component at left position
	 * @return returns cell component at left position
	 */
	public CellComponents getLeft() {
		return cell.left;
	}
	
	/**
	 * Gets cell component at right position
	 * @return returns cell component at right position
	 */
	public CellComponents getRight() {
		return cell.right;
	}
	
	/**
	 * Sets cell component at up position
	 * @param up
	 */
	public void setUp(CellComponents up) {
		this.cell.up = up;
	}
	
	/**
	 * Sets cell component at bottom position
	 * @param bottom
	 */
	public void setDown(CellComponents bottom) {
		this.cell.bottom = bottom;	
	}
	
	/**
	 * Sets cell component at left position
	 * @param left
	 */
	public void setLeft(CellComponents left) {
		this.cell.left = left;
	}

	/**
	 * Sets cell component at right position
	 * @param right
	 */
	public void setRight(CellComponents right) {
		this.cell.right = right;
	}

	/**
	 * To string override for Cell
	 */
	@Override
	public String toString() {
		
		return "Cell [left=" + cell + "]";
	}
	
}
