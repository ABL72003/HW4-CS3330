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
	public Cell (CellComponents left, CellComponents right, CellComponents up, CellComponents bottom) {
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
		
		if (up == null) {
			this.up = CellComponents.WALL;
		}
	}
	
	/**
	 * Sets cell component at bottom position
	 * @param bottom
	 */
	public void setDown(CellComponents bottom) {
		this.bottom = bottom;	
		
		if (bottom == null) {
			this.bottom = CellComponents.WALL;
		}
	}
	
	/**
	 * Sets cell component at left position
	 * @param left
	 */
	public void setLeft(CellComponents left) {
		this.left = left;
		
		if (left == null) {
			this.left = CellComponents.WALL;
		}
	}

	/**
	 * Sets cell component at right position
	 * @param right
	 */
	public void setRight(CellComponents right) {
		this.right = right;
		
		if (right == null) {
			this.right = CellComponents.WALL;
		}
	}

	/**
	 * To string override for Cell
	 */
	@Override
	public String toString() {
	    return "Cell [left=" + left + ", right=" + right + ", up=" + up + ", down=" + bottom + "]";
	}

	/**
	 * sets components to given cell
	 * @param cellComponents
	 * @param cellComponents2
	 * @param cellComponents3
	 * @param cellComponents4
	 */
	public void setComponents(CellComponents cellComponents, CellComponents cellComponents2,
			CellComponents cellComponents3, CellComponents cellComponents4) {//left right up bottom
		
	    this.left = cellComponents;
	    this.right = cellComponents2;
	    this.up = cellComponents3;
	    this.bottom = cellComponents4;
	}
	
	/**
	 * sets player
	 * @param hasPlayer
	 */
	public void setPlayer(boolean hasPlayer) {
	    this.hasPlayer = hasPlayer;
	}
	
	/**
	 * returns player
	 * @return
	 */
	public boolean hasPlayer() {
	    return this.hasPlayer;
	}
	
}
