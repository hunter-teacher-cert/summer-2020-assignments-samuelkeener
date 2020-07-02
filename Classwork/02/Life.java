import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Life {
	public static void main(String[] args) {
		char[][] board = createNewBoard(250, 250);

		for (int x = 0; x < 1000; x++) { // run 1000 generations
			drawBoard(board);
			generateNextBoard(board);
		}

	} // end main

	/* Draws the board using ImageTest class */
	public static void drawBoard(char[][] board) {
		int[][] intboard = new int[board.length][board[0].length]; // drawImage requires 2d int array
		for (int r = 0; r < intboard.length; r++) {
			for (int c = 0; c < intboard[0].length; c++) {
				if (board[r][c] == 'O')
					intboard[r][c] = 255; // converts 'O' to 255
			}
		}
		ImageTest.drawImage(intboard);
	}

	/* Randomly populates middle of 250x250 grid with 20% 'O' cells */
	public static char[][] createNewBoard(int rows, int cols) {
		char[][] board = new char[rows][cols];
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				if (Math.random() >= .8 && r > 75 && r < 175 && c > 75 && c < 175)
					board[r][c] = 'O';
				else
					board[r][c] = ' ';
			}
		}
		return board;
	}

	/* Animateboard method copied from Topher 
	public static void animateBoard(char[][] board) {
		System.out.print("[0;0H\n");
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				System.out.print(board[row][col]);
			}
			System.out.println();
		}
		delay(1000);
	}*/

	// Set the cell (r,c) to value
	public static void setCell(char[][] board, int r, int c, char val) {
		board[r][c] = val;
	}

	/* Creates new board after one generation. */
	public static void generateNextBoard(char[][] board) {
		char[][] temp = new char[board.length][board[0].length]; // will store next generation board
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[r].length; c++) {
				temp[r][c] = getNextGenCell(board, r, c);
			}
		}
		// copies temp array to board
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[r].length; c++) {
				setCell(board, r, c, temp[r][c]);
			}
		}
	}

	/* Determines what the cell will be in the next generation */
	public static char getNextGenCell(char[][] board, int r, int c) {
		int count = countNeighbors(board, r, c); // counts neighbors for current cell
		if (board[r][c] == 'O' && (count == 2 || count == 3)) // Will survive
			return 'O';
		else if (board[r][c] == ' ' && count == 3) // Will change from dead to alive
			return 'O';
		else // Will die or will stay dead
			return ' ';
	}

	public static void printBoard(char[][] board) {
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[r].length; c++) {
				System.out.printf("%c", board[r][c]);
			}
			System.out.println();
		}
		System.out.println("\n\n-----------------\n\n");
	}

	/* Determines number of live neighbors for a particular cell */
	public static int countNeighbors(char[][] board, int r, int c) {
		int count = 0;
		for (int i = r - 1; i <= r + 1; i++) {
			for (int j = c - 1; j <= c + 1; j++) {
				if (i >= 0 && j >= 0 && i < board.length && j < board[0].length) { // prevents out of bounds errors
					if (!(i == r && j == c) && board[i][j] == 'O') { // skips the target cell
						count++;
					}
				}
			}
		}
		return count;
	}
} // end class
