import java.io.*;
import java.util.*;

public class Boogle2 {

	// Sorts ArrayList least to greatest
	public static void sortArrayList(ArrayList al) {
		// store size of ArrayList
		int high = al.size();
		// loop over al
		for (int low = 0; low < high - 1; low++) {
			// find smallest index
			int index = findSmallest(al, low, high);
			// swap elements in index and low
			swap(al, low, index);
		}
	}

	// swaps elements at given indexes in passed ArrayList
	public static void swap(ArrayList al, int index1, int index2) {
		int temp = (int) al.get(index1);
		al.set(index1, al.get(index2));
		al.set(index2, temp);
	}

	// return index of minimum value
	public static int findSmallest(ArrayList al, int low, int high) {
		// accounts for user error/silly client
		if (low > high) {
			throw new IndexOutOfBoundsException("Invalid range: do better");
		}
		if (low < 0) // fixes range issue if low TOO low
			low = 0;
		if (low >= al.size() || high < 0) // checks to make sure at least part of range is in bounds
			throw new IndexOutOfBoundsException("Entire range out of bounds");
		// set initial values for minIndex and minValue
		int minValue = (int) al.get(low);
		int minIndex = low;
		for (int i = low + 1; i <= high && i < al.size(); i++) { // loops from low+1 to high (stops if high out of
																	// bounds)
			int num = (int) al.get(i);
			if (num < minValue) { // winner, winner! change minValue and minIndex
				minValue = num;
				minIndex = i;
			}
		}
		return minIndex; // once loop is done, this should contain the index of the smallest value
	}

	// return index of first occurrence of target, or -1 if not found
	public static int linSearch(ArrayList al, int target) {
		for (int pos = 0; pos < al.size(); pos++) {
			if (al.get(pos).equals(target))
				return pos;
		}
		return -1;
	}// end linSearch()

	// binSearch without recursion
	public static int binSearchIterative(ArrayList al, int target) {
		if (al.size() == 0)
			return -1;
		// sets the low and high values for the sake of finding midpoint
		int low = 0;
		int high = al.size();
		while (high >= low) { // run as long as there's something to look at
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
	public static int binSearch(ArrayList al, int target) {
		// call the recursive method with low value of 0 and high value of size()
		if (al.size() == 0)
			return -1;
		return binSearchRecursive(al, target, 0, al.size() - 1);
		// return binSearchIterative(al, target);
	}// end binSearch()

	public static int binSearchRecursive(ArrayList al, int target, int low, int high) {
		// base case, if we get to a point where there's nothing in between high and
		// low, we must admit defeat and return -1
		if (high < low)
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

		int smallIndex;
		System.out.println("Testing findSmallest");
		ArrayList<Integer> slist = prestoArrayListo(20, 0, 200);
		smallIndex = findSmallest(slist, 0, slist.size());
		System.out.println(slist);
		System.out.printf("Smallest is at slist[%d] and is %d\n", smallIndex, slist.get(smallIndex));
		System.out.println("Testing sortArrayList:\n");
		sortArrayList(slist);
		System.out.print(slist);
	}// end main

}// end class
