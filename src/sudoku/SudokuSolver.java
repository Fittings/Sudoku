package sudoku;
/* Cameron Milsom - August 2015 
 * Sudoku Solver, takes in a Sudoku array and solves it using a backtracking algorithm
 * This is designed to work on any NxN Sudoku problem. Likely to be slow on large scale problems.
 */
public class SudokuSolver {	
		
	/* Takes sudoku input and sets-up the backtracking solver */
	public static int[][] solve(int[][] sudoku) {
		int n = sudoku.length;
		if (sudoku[0].length != n) return null; //Not NxN sudoku puzzle
		
		int[][] solution = sudoku.clone();
		
		if (trySolve(solution, n, 0, 0)) return solution;
		return null;
		
	}
	
	/* Back-tracking solver algorithm for Sudoku puzzle of NxN size
	 * Can be sped-up by using some heuristic logic. Fast enough for puzzles of standard size
	 */
	private static boolean trySolve(int[][] puzzle, int n, int py, int px) {
		if (py >= n) return true; //SOLVED - We have been through every cell
		
		while (puzzle[py][px] != 0) { //while value already existing, go to next position
			px++;
			if (px >= n) {
				px = 0;
				py++;
			}
			if (py >= n) return true; //SOLVED - We have been through every cell
		}

		for (int v = 1; v <= n; v++) {
			//If the value is valid, insert and solve the updated sudoku
			if (isValueValid(puzzle, py, px, v)) {
				puzzle[py][px] = v;
				int newPy = py, newPx = px;
				newPx += 1; //Update px and py
				if (newPx == n) {
					newPx = 0;
					newPy += 1;
				}
				if (trySolve(puzzle, n, newPy, newPx)) return true; //SOLVED
				puzzle[py][px] = 0; //Updated sudoku invalid, reset and try with new value
			}
		}
		return false; //No solutions for this sudoku iteration
	}
	
	/* Checks if the value is valid for the index x,y values by checking horizontally, vertically and inside the box */
	private static boolean isValueValid(int[][] puzzle, int py, int px, int value) {
		//xx//System.err.println("Checking py: " + py + " and px: " + px + " with value: " + value);
		
		if (checkHorizontalContains(puzzle, py, px, value)) return false;
		if (checkVerticalContains(puzzle, py, px, value)) return false;
		if (checkBoxContains(puzzle, py, px, value)) return false;
		return true;
	}
	
	/* Checks if the value already exists horizontally */
	private static boolean checkHorizontalContains(int[][] puzzle, int py, int px, int value) {
		for (int i=0; i < puzzle[0].length; i++) {
			if (px == i) continue;
			if (puzzle[py][i] == value) return true;
		}
		return false;
	}
	
	/* Checks if the value already exists vertically */
	private static boolean checkVerticalContains(int[][] puzzle, int py, int px, int value) {
		for (int i=0; i < puzzle[0].length; i++) {
			if (py == i) continue;
			if (puzzle[i][px] == value) return true;
		}
		return false;
	}
	
	/* Checks if the value exists within the local square
	 * This works for any size NxN sudoku */
	private static boolean checkBoxContains(int[][] puzzle, int py, int px, int value) {
		int smallSize = (int) Math.pow((double) puzzle[0].length, 0.5); //Calculate the size of the smallBox
		int xBoxStart = py - (py % smallSize);
		int yBoxStart = px - (px % smallSize);	
		for (int x = xBoxStart; x < xBoxStart+smallSize; x++) {
			for (int y = yBoxStart; y < yBoxStart+smallSize; y++) {	
				if (x == py && y == px) continue; //Ignore starting location
				if (puzzle[x][y] == value) return true; 
			}
		}	
		return false;
	}
	

}
