package sudoku;

public class SudokuSolver {
private int[][] grid;
	
	/**
	 * Creates a SudokuSolver
	 */
	public SudokuSolver() {
		grid = new int[9][9];
	}
	
	/**
	 * Inserts a value into the specified element
	 * @param row The row of the specified element
	 * @param col The column of the specified element
	 * @param num The number you wish to add
	 * @return The old value in the element 
	 */
	public int setValue(int row, int col, int num) {
		int old = grid[row][col];
		grid[row][col] = num;
		return old;
	}
	
	/**
	 * Returns the value of the specified element
	 * @param row The row of the specified element
	 * @param col The column of the specified element
	 * @return The current value in the element
	 */
	public int getValue(int row, int col){
		return grid[row][col];
	}
	
	/**
	 * Returns the value of the specified element as a String
	 * @param row The row of the specified element
	 * @param col The column of the specified element
	 * @return The current value in the element as a String
	 */
	public String printValue(int row, int col) {
		return Integer.toString(grid[row][col]);
	}
	
	/**
	 * Returns the whole grid as a String
	 * @return The whole grid as a String
	 */
	public String printGrid() {
		String temp = "";
		for(int row = 0; row < 9; row++) {
			for(int col = 0; col < 9; col++) {
				temp = temp +  grid[row][col] + " ";
			}
			temp = temp + "\n";
		}
		return temp;
	}
	
	/**
	 * Solves the entire Sudoku and fills all elements in the grid with a value, if true
	 * @return true if the sudoku is solvable and false if it isn't
	 */
	public boolean solve() { //Solve starts at 0,0 and then proceeds to solve the entire Sudoku
		return solve(0,0);
	}
	
	private boolean solve(int row, int col) {
		if(col > 8) { //Checks if we finish the final column
			return true;
		}
		
		if(row > 8) { //Checks when we finish a row
			return solve(0, col+1);
		}
		
		if(grid[row][col] != 0) { //Evaluates if the current value in grid[row][col] needs to be replaced.
			int temp = grid[row][col];
			grid[row][col] = 0;
			
			if(isSafe(row, col, temp)) {
				grid[row][col] = temp;
				return solve(row+1, col);
			}
			return false;
		}
		else {
			for(int num = 1; num <= 9; num++) { // Otherwise takes the lowest available number and adds it to grid[row][col] 
				if(isSafe(row, col, num)) {
					grid[row][col] = num;
					
					if(solve(row+1, col)) {
						return true;
					}
					
					grid[row][col] = 0;
				}
			}
			return false;
		}
	}
	
	private boolean isSafe(int row, int col, int num) { //Checks if the code is used in the row, col or box (3x3)
		return (usedInRow(row, num) && usedInCol(col, num) && usedInBox(row - (row % 3) , col - (col % 3), num));
	}
	
	private boolean usedInRow(int row, int num) {
		for(int col = 0; col < 9; col++) {
			if(grid[row][col] == num) {
				return false;
			}
		}
		return true;
	}
	
	private boolean usedInCol(int col, int num) {
		for(int row = 0; row < 9; row++) {
			if(grid[row][col] == num) {
				return false;
			}
		}
		return true;
	}
	
	private boolean usedInBox(int boxStartRow, int boxStartCol, int num) {
		for(int row = 0; row < 3; row++) {
			for(int col = 0; col < 3; col++) {
				if(grid[row+boxStartRow][col+boxStartCol] == num) {
					return false;
				}
			}
		}
		return true;
	}
}
