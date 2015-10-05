package sudoku;
import sudoku.SudokuUtil;
import sudoku.SudokuSolver;


public class SudokuApp {

	public static void main(String[] args) {
		int[][] myPuzzle = {
			{0, 5, 0, 1, 0, 6, 0, 2, 0},
			{6, 0, 0, 0, 7, 0, 0, 0, 1},
			{0, 0, 8, 0, 0, 0, 7, 0, 0},
			{2, 0, 0, 0, 0, 0, 0, 0, 8},
			{0, 6, 0, 0, 2, 0, 0, 4, 0},
			{9, 0, 0, 0, 0, 0, 0, 0, 5},
			{0, 0, 9, 0, 0, 0, 8, 0, 0},
			{4, 0, 0, 0, 1, 0, 0, 0, 2},
			{0, 3, 0, 5, 0, 2, 0, 1, 0}
		};
		
		System.out.println(SudokuUtil.array2dString(myPuzzle));
		myPuzzle = SudokuSolver.solve(myPuzzle);
		System.out.println(SudokuUtil.array2dString(myPuzzle));

	}

}
