package hw4.maze;

import java.util.Random;

public class Grid {
	
	private int size;
	private Cell[][] cells;
	
	
	
	Grid(){
		generateRand(this.size, 3, 7);
		cells = new Cell[size][size];
		int exitCell = 0; generateRand(exitCell, 0, size);
		
		
		
		
	}
	
	private void generateRand(int size, int min, int max) {
		Random random = new Random();
		size = random.nextInt(max - min + 1) + min;
		return;
	}
	

	
	
	
}