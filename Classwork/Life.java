import java.io.*;
import java.util.*;;

public class Life {
	public static void main(String[] args) {
		System.out.println("Hello");
		char[][] board = createNewBoard(25, 25);

		for (int x = 0; x < 100; x++) {
			oneGeneration(board);
			printBoard(board);
		}

	} // end main

	// Create a new 2-d array, fill it with ' ' representing that the board is
	// empty.

	public static char[][] createNewBoard(int rows, int cols) {
		char[][] board = new char[rows][cols];
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				if (Math.random() < .5)
					board[r][c] = ' ';
				else
					board[r][c] = 'O';
			}
		}
		return board;
	}

	// Set the cell (r,c) to value
	public static void setCell(char[][] board, int r, int c, char val) {
		board[r][c] = val;
	}

	/*
	 * Determines if each cell in board will be alive or dead in the next generation
	 */
	public static void oneGeneration(char[][] board) {
		char[][] temp = new char[board.length][board[0].length]; // stores results for next generation without changing
																	// board
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[r].length; c++) {
				int count = countNeighbors(board, r, c);
				if (count < 2)
					temp[r][c] = ' ';
				else if (board[r][c] == 'O' && count < 4)
					temp[r][c] = 'O';
				else if (board[r][c] == ' ' && count == 3)
					temp[r][c] = 'O';
				else
					temp[r][c] = ' ';
			}
		}
		// copies temp array to board
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[r].length; c++) {
				setCell(board, r, c, temp[r][c]);
			}
		}
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
		char check = 'O';
		for (int i = r - 1; i <= r + 1; i++) {
			for (int j = c - 1; j <= c + 1; j++) {
				if (i >= 0 && j >= 0 && i < board.length && j < board[0].length) { // prevents out of bounds errors
					if (!(i == r && j == c) && board[i][j] == check) {
						count++;
					}
				}
			}
		}
		return count;
	}
} // end class
