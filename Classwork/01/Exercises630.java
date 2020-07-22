import java.io.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Exercises630 {
	public static void main(String[] args) {
		int[][] array = new int[20][20];
		diagonal(array, 19, 19, 0, 999);
		print2d(array);
	}// end main

	public static void rowPop(int[][] d2, int r, int value) {
		for (int j = 0; j < d2[0].length; j++) {
			d2[r][j] = value;
		} // end for j
	}// end rowPop

	public static void colPop(int[][] d2, int c, int value) {
		for (int j = 0; j < d2[0].length; j++) {
			d2[j][c] = value;
		} // end for j
	}// end colPop

	public static void invert(int[][] d2) {
		for (int i = 0; i < d2.length; i++) {
			for (int j = 0; j < d2[0].length; j++) {
				if (d2[i][j] == 0)
					d2[i][j] = 255;
				else
					d2[i][j] = 0;
			} // end for j
		} // end for i
	}// end invert

	public static void diagonal(int[][] d2, int r, int c, int direction, int value) {
		int rchange = 1;
		int cchange = 1;
		if (direction < 2) {
			rchange = -1;
		}
		if (direction == 0 || direction == 2) {
			cchange = -1;
		}
		for (int i = r, j = c; i >= 0 && i < d2.length && j >= 0 && j < d2[0].length; i += rchange, j += cchange) {
			d2[i][j] = value;
		}
		
		//alternate for loop 
		for (; r >= 0 && c < d2.length && r >= 0 && c < d2[0].length; r+=rchange,c+=cchange) 
		{ 
			d2[r][c] = value; 
		}
	}

	public static void print2d(int[][] d2) {
		for (int r = 0; r < d2.length; r++) {
			for (int c = 0; c < d2[r].length; c++) {
				System.out.printf("%03d ", d2[r][c]);
			} // end c for
			System.out.println();
		} // end r for
	}// end print2d
}// end class