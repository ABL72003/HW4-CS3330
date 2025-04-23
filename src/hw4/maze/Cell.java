package hw4.maze;
/**
 * 
 */
public class Cell {
	private CellComponents up;
	private CellComponents bottom;
	private CellComponents left;
	private CellComponents right;
	private boolean hasPlayer;
	
	
	/**
	 * This Constructor sets all positions to null
	 */
	public Cell () {
		this.up = null;
		this.bottom = null;
		this.left = null;
		this.right = null;
		this.hasPlayer = false;
	}		
	
	
	/**
	 * This Constructor sets each position to the given param
	 * @param up
	 * @param bottom
	 * @param left
	 * @param right
	 */
	public Cell (CellComponents up, CellComponents bottom, CellComponents left, CellComponents right) {
		this.up = up;
		this.bottom = bottom;
		this.left = left;
		this.right = right;
	}
	
	/**
	 * Gets cell component at up position
	 * @return returns cell component at up Position
	 */
	public CellComponents getUp() {
		return this.up;
	}
	
	/**
	 * Gets cell component at bottom position
	 * @return returns cell component at bottom position
	 */
	public CellComponents getDown() {
		return this.bottom;
	}
	
	/**
	 * Gets cell component at left position
	 * @return returns cell component at left position
	 */
	public CellComponents getLeft() {
		return this.left;
	}
	
	/**
	 * Gets cell component at right position
	 * @return returns cell component at right position
	 */
	public CellComponents getRight() {
		return this.right;
	}
	
	/**
	 * Sets cell component at up position
	 * @param up
	 */
	public void setUp(CellComponents up) {
		this.up = up;
	}
	
	/**
	 * Sets cell component at bottom position
	 * @param bottom
	 */
	public void setDown(CellComponents bottom) {
		this.bottom = bottom;	
	}
	
	/**
	 * Sets cell component at left position
	 * @param left
	 */
	public void setLeft(CellComponents left) {
		this.left = left;
	}

	/**
	 * Sets cell component at right position
	 * @param right
	 */
	public void setRight(CellComponents right) {
		this.right = right;
	}

	/**
	 * To string override for Cell
	 */
	@Override
	public String toString() {
	    return "Cell [left=" + left + ", right=" + right + ", up=" + up + ", down=" + bottom + "]";
	}

	public void setComponents(CellComponents cellComponents, CellComponents cellComponents2,
			CellComponents cellComponents3, CellComponents cellComponents4) {
		
	    this.up = cellComponents;
	    this.bottom = cellComponents2;
	    this.left = cellComponents3;
	    this.right = cellComponents4;
	}
	
	public void setPlayer(boolean hasPlayer) {
	    this.hasPlayer = hasPlayer;
	}

	public boolean hasPlayer() {
	    return this.hasPlayer;
	}
	
}
