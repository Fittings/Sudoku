package sudoku;

public class SudokuUtil {
	
	public static String Array2dString(int[][] array) {
		StringBuilder myString = new StringBuilder();
		for (int x = 0; x < array[0].length; x++) {
			String divider = "";
			for (int y = 0; y < array.length; y++) {
				myString.append(divider);
				myString.append(array[y][x]);
				divider = " ";
			}
			myString.append("\n");
		}
		return myString.toString();
	}

}
