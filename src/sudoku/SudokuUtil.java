package sudoku;

public class SudokuUtil {
	
	public static String array2dString(int[][] array) {
		if (array == null) return "no sol";
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
