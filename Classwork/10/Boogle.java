
/**
   classwork -- Day 10 | 0b1010 | 0x10

   class: Boogle

   A tester class for code analysis and search exploration.

   USAGE:
   Read through at least once.
   Compile, run.
   Comment/uncomment lines, recompile, run to explore functionality.
   "Lather, rinse, repeat" until comprehension achieved.
   Rename methods to indicate purpose.
   Insert comment preceding each method to summarize functionality.

   T. Mykolyk, F. Dragon
   June 2020
**/

import java.io.*;
import java.util.*;

public class Boogle {

	// return index of first occurrence of target, or -1 if not found
	public static int linSearch(ArrayList al, int target) {
		for (int pos = 0; pos < al.size(); pos++) {
			if (al.get(pos).equals(target))
				return pos;
		}
		return -1;
	}// end linSearch()

	// binSearch without recursion
	public static int binSearch(ArrayList al, int target) {
		// sets the low and high values for the sake of finding midpoint
		int low = 0;
		int high = al.size();
		while (high > low) { // as long as there's something in between
			int index = (low + high) / 2; // sets index to the midpoint between high and low
			int check = (int) al.get(index); // stores value at index
			if (check == target) // if check is target, return the index
				return index;
			else if (check < target) // if check is less than the target, change the low to index+1 to eliminate half
										// the values
				low = index + 1;
			else // if check is higher than the target, change the high to index-1 to eliminate
					// half the values
				high = index - 1;
		}
		// if they never found it, time to admit defeat and return -1
		return -1;
	}

	// return index of target, or -1 if not found
	public static int binSearchRecursive(ArrayList al, int target) {
		// call the recursive method with low value of 0 and high value of size()
		return binSearchRecursive(al, target, 0, al.size());
	}// end binSearch()

	public static int binSearchRecursive(ArrayList al, int target, int low, int high) {
		// base case, if we get to a point where there's nothing in between high and
		// low, we must admit defeat and return -1
		if (high <= low)
			return -1;
		int index = (low + high) / 2; // sets index to the midpoint between high and low
		int check = (int) al.get(index); // stores value at index
		if (check == target) // WE'VE STRUCK GOLD! return the index value!
			return index;
		else if (check < target) // we were too low, eliminate everything below/including index and try again
			// by calling the same method with modified parameters, we are narrowing the
			// search and changing the midpoint/index
			return binSearchRecursive(al, target, index + 1, high);
		else // we were too high, eliminate everything above/including index and try again.
			return binSearchRecursive(al, target, low, index - 1);
	}

	// return ArrayList of random ints on range [lo,lo+hi)
	public static ArrayList prestoArrayListo(int numItems, int lo, int hi) {
		ArrayList retArr = new ArrayList();

		for (int i = 0; i < numItems; i++) {
			// System.out.println(i); //diagnostic under-the-hood view
			// retArr.add( Math.random() ); // [0,1)
			// retArr.add( (int)Math.random() ); // 0
			// retArr.add( (int)(hi * Math.random()) ); // [0,hi)
			retArr.add(lo + (int) (hi * Math.random())); // [lo,lo+hi)
		}
		return retArr;
	}// end prestoArrayListo()

	// return ArrayList of random ints, sorted in ascending order
	public static ArrayList prestoSortedArrayListo(int numItems, int lo, int hi) {
		ArrayList retArr = new ArrayList();

		// if requested, return empty ArrayList
		if (numItems < 1)
			return retArr;

		// populate index 0
		retArr.add((int) (lo * Math.random()));

		// populate rest of indices, each one greater than last
		for (int i = 1; i < numItems; i++) {
			// System.out.println(i); //diagnostic under-the-hood view
			// retArr.add( Math.random() ); // [0,1)
			// retArr.add( (int)Math.random() ); // 0
			// retArr.add( (int)(hi * Math.random()) ); // [0,hi)
			// retArr.add( lo + (int)(hi * Math.random()) ); // [lo,lo+hi)
			// System.out.println(retArr.get(i-1));
			retArr.add((int) retArr.get(i - 1) + lo + (int) (hi * Math.random())); // ["left neighbour",hi)
		}

		return retArr;
	}// end prestoSortedArrayListo()

	public static void main(String[] args) {
		/*
		 * ~~~~v~~~~~~move~me~down~~~1~block~at~a~time~~~~~~~~~~v~~~~
		 * System.out.println("\n"+"al000"+":"); ArrayList al000 =
		 * prestoArrayListo(0,0,0); System.out.println(al000);
		 * System.out.println(linSearch(al000,3));
		 * 
		 * System.out.println("\n"+"al01"+":"); ArrayList al01 =
		 * prestoArrayListo(5,0,100); System.out.println(al01);
		 * System.out.println(linSearch(al01,3));
		 * 
		 * System.out.println("\n"+"al02"+":"); ArrayList al02 =
		 * prestoArrayListo(5,3,10); System.out.println(al02);
		 * System.out.println(linSearch(al02,3));
		 * 
		 * System.out.println("\n"+"al05"+":"); ArrayList al05 =
		 * prestoArrayListo(20,1,5); System.out.println(al05);
		 * System.out.println(linSearch(al05,3));
		 * ~~~~^~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~^~~~~
		 */

		// test battery using sorted ArrayLists as search space

		System.out.println("\n" + "sal000" + ":");
		ArrayList sal000 = prestoSortedArrayListo(0, 0, 0);
		System.out.println(sal000);
		System.out.println(linSearch(sal000, 3));
		System.out.println(binSearch(sal000, 3));

		System.out.println("\n" + "sal00" + ":");
		ArrayList sal00 = prestoSortedArrayListo(5, 0, 100);
		System.out.println(sal00);
		System.out.println(linSearch(sal00, 3));
		System.out.println(binSearch(sal00, 3));

		System.out.println("\n" + "sal01" + ":");
		ArrayList sal01 = prestoSortedArrayListo(5, 0, 100);
		System.out.println(sal01);
		System.out.println(linSearch(sal01, 3));
		System.out.println(binSearch(sal01, 3));

		System.out.println("\n" + "sal02" + ":");
		ArrayList sal02 = prestoSortedArrayListo(5, 3, 100);
		System.out.println(sal02);
		System.out.println(linSearch(sal02, 3));
		System.out.println(binSearch(sal02, 3));

		System.out.println("\n" + "sal03" + ":");
		ArrayList sal03 = prestoSortedArrayListo(5, 0, 100);
		System.out.println(sal03);
		System.out.println(linSearch(sal03, 3));
		System.out.println(binSearch(sal03, 3));

		System.out.println("\n" + "sal04" + ":");
		ArrayList sal04 = prestoSortedArrayListo(20, 0, 3);
		System.out.println(sal04);
		System.out.println(linSearch(sal04, 3));
		System.out.println(binSearch(sal04, 3));

		System.out.println("\n" + "sal05" + ":");
		ArrayList sal05 = prestoSortedArrayListo(20, 1, 5);
		System.out.println(sal05);
		System.out.println(linSearch(sal05, 3));
		System.out.println(binSearch(sal05, 3));

		// batch of commands for easier test case generation:
		/*
		 * System.out.println("\n"+"al"+":"); ArrayList al = prestoArrayListo(,,);
		 * System.out.println(al); System.out.println(linSearch(al, ));
		 * System.out.println(binSearch(al, ));
		 */
	}// end main

}// end class
