package test;

import static org.junit.Assert.*;

import org.junit.After;

import sudoku.SudokuSolver;
import org.junit.Before;
import org.junit.Test;

public class testSudokuSolver {
	SudokuSolver solver;

	@Before
	public void setUp() throws Exception {
		solver = new SudokuSolver();
	}
	
	@After
	public void tearDown() throws Exception {
		solver = null;
	}

	@Test
	public void testEmptySudoku() {
		assertTrue("Sudoku is solvable when empty:", solver.solve());
	}
	
	@Test
	public void testFilledSudoku() {
		solver.setValue(0, 2, 8);
		solver.setValue(0, 5, 9);
		solver.setValue(0, 7, 6);
		solver.setValue(0, 8, 2);
		solver.setValue(1, 8, 5);
		solver.setValue(2, 0, 1);
		solver.setValue(2, 2, 2);
		solver.setValue(2, 3, 5);
		solver.setValue(3, 3, 2);
		solver.setValue(3, 4, 1);
		solver.setValue(3, 7, 9);
		solver.setValue(4, 1, 5);
		solver.setValue(4, 6, 6);
		solver.setValue(5, 0, 6);
		solver.setValue(5, 7, 2);
		solver.setValue(5, 8, 8);
		solver.setValue(6, 0, 4);
		solver.setValue(6, 1, 1);
		solver.setValue(6, 3, 6);
		solver.setValue(6, 5, 8);
		solver.setValue(7, 0, 8);
		solver.setValue(7, 1, 6);
		solver.setValue(7, 4, 3);
		solver.setValue(7, 6, 1);
		solver.setValue(8, 6, 4);
		assertTrue("Sudoku is solvable :", solver.solve());
	}
	
	@Test
	public void testUnsolvableSudoku() {
		solver.setValue(0, 0, 5);
		solver.setValue(0, 1, 1);
		solver.setValue(0, 2, 6);
		solver.setValue(0, 3, 8);
		solver.setValue(0, 4, 4);
		solver.setValue(0, 5, 9);
		solver.setValue(0, 6, 7);
		solver.setValue(0, 7, 3);
		solver.setValue(0, 8, 2);
		solver.setValue(1, 0, 3);
		solver.setValue(1, 2, 7);
		solver.setValue(1, 3, 6);
		solver.setValue(1, 5, 5);
		solver.setValue(2, 0, 8);
		solver.setValue(2, 2, 9);
		solver.setValue(2, 3, 7);
		solver.setValue(2, 7, 6);
		solver.setValue(2, 8, 5);
		solver.setValue(3, 0, 1);
		solver.setValue(3, 1, 3);
		solver.setValue(3, 2, 5);
		solver.setValue(3, 4, 6);
		solver.setValue(3, 6, 9);
		solver.setValue(3, 8, 7);
		solver.setValue(4, 0, 4);
		solver.setValue(4, 1, 7);
		solver.setValue(4, 2, 2);
		solver.setValue(4, 3, 5);
		solver.setValue(4, 4, 9);
		solver.setValue(4, 5, 1);
		solver.setValue(4, 8, 6);
		solver.setValue(5, 0, 9);
		solver.setValue(5, 1, 6);
		solver.setValue(5, 2, 8);
		solver.setValue(5, 3, 3);
		solver.setValue(5, 4, 7);
		solver.setValue(5, 7, 5);
		solver.setValue(6, 0, 2);
		solver.setValue(6, 1, 5);
		solver.setValue(6, 2, 3);
		solver.setValue(6, 3, 1);
		solver.setValue(6, 4, 8);
		solver.setValue(6, 5, 6);
		solver.setValue(6, 7, 7);
		solver.setValue(6, 8, 4);
		solver.setValue(7, 0, 6);
		solver.setValue(7, 1, 8);
		solver.setValue(7, 2, 4);
		solver.setValue(7, 3, 2);
		solver.setValue(7, 5, 7);
		solver.setValue(7, 6, 5);
		solver.setValue(8, 0, 7);
		solver.setValue(8, 1, 9);
		solver.setValue(8, 2, 1);
		solver.setValue(8, 4, 5);
		solver.setValue(8, 6, 6);
		solver.setValue(8, 8, 8);
		assertFalse("Sudoku is unsolvable :", solver.solve());
	}
	
	@Test
	public void testRow() {
		solver.setValue(0, 0, 1);
		solver.setValue(0, 1, 1);
		assertFalse("Sudoku is unsolvable :", solver.solve());
	}
	
	@Test
	public void testCol() {
		solver.setValue(0, 0, 1);
		solver.setValue(1, 0, 1);
		assertFalse("Sudoku is unsolvable :", solver.solve());
	}
	@Test
	public void testBox() {
		solver.setValue(0, 0, 1);
		solver.setValue(2, 2, 1);
		assertFalse("Sudoku is unsolvable :", solver.solve());
	}
	
}
