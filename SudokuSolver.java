public class SudokuSolver {
	/*
		Basic idea of this algorithm:
		Search for an empty cell and fill it with a number that fits (going from 1 to 9).
		Go further and try to fill else cells in the same way.
		If you find a cell for which no numbers are fit go one step back.
		Fill cell (previous cell, because you went step back) with the next number that fits.
		Again try to go further.
	 */

	private static final char EMPTY_CELL = '.';

	public static void solveSudoku(char[][] board) {
		solve(board);
	}

	private static boolean solve(char[][] board) {
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				// go to empty cell
				if (board[row][col] != EMPTY_CELL) {
					continue;
				}

				for (char k = '1'; k <= '9'; k++) {
					// search for a number that can be placed to this cell
					if (isValid(board, row, col, k)) {
						board[row][col] = k;
						if (solve(board)) { // try to solve board with a found number
							return true;
						}
						// if you found a cell that cannot be filled, clear the current cell and try the next number that fits
						board[row][col] = EMPTY_CELL;
					}
				}
				// Return false means that you are unable to solve board with the current set of numbers
				// and need to go back and change placed numbers
				return false;
			}
		}

		return true; // return true if all cells are checked
	}

	// Check numbers in the square, as well as in vertical and horizontal lines to be different from the candidate number
	private static boolean isValid(char[][] board, int row, int col, char candidateNumber) {
		for (int i = 0; i < 9; i++) {
			char numberFromVerticalLine = board[i][col];
			if (numberFromVerticalLine != EMPTY_CELL && numberFromVerticalLine == candidateNumber) {
				return false;
			}

			char numberFromHorizontalLine = board[row][i];
			if (numberFromHorizontalLine != EMPTY_CELL && numberFromHorizontalLine == candidateNumber) {
				return false;
			}

			char numberFromSquare = board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3];
			if (numberFromSquare != EMPTY_CELL && numberFromSquare == candidateNumber) {
				return false;
			}
		}
		return true;
	}

	// ------- Test code -------

	public static void main(String... args) {
		char[][] board = new char[][]{
				{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
				{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
				{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
				{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
				{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
				{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
				{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
				{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
				{'.', '.', '.', '.', '8', '.', '.', '7', '9'}
		};
		printBoard(board, "Initial board:");
		solveSudoku(board);
		printBoard(board, "Solved board:");
	}

	private static void printBoard(char[][] board, String title) {
		System.out.println(title);
		for(char[] row : board) {
			for(char cell : row) {
				System.out.print(cell);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
}
