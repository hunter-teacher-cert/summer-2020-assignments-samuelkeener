import java.util.ArrayList;

public class MergeSort {

	private static int level = 0;

	public static void main(String[] args) {
		ArrayList<Integer> slist2 = prestoArrayListo(20, 0, 200);
		// ArrayList<Integer> slist3 = prestoArrayListo(5, 0, 200);
		// ArrayList<Integer> slist4 = prestoArrayListo(50, 0, 200);
		long start = System.currentTimeMillis();
		slist2 = mergeSortWithOutput(slist2);
		long elapsed = System.currentTimeMillis() - start;
		// slist3 = mergeSort(slist3);
		// slist4 = mergeSort(slist4);
		System.out.println(elapsed);
		// System.out.println(slist3);
		// System.out.println(slist4);
	} // end main

	public static ArrayList<Integer> insertionSort(ArrayList<Integer> al) {
		ArrayList<Integer> merge = new ArrayList<Integer>();
		merge.add(al.get(0));
		for (int i = 1; i < al.size(); i++) {
			merge = merge(merge, slice(al, i, i + 1));
		}
		return merge;
	}

	public static void mergeSortReplace(ArrayList<Integer> al) {
		// calls the split method, which will return the sorted list as a new ArrayList
		ArrayList<Integer> merge = mergeSort(al);
		// replace current list with new sorted list.
		al.clear();
		while (merge.size() > 0) {
			al.add(merge.remove(0));
		}
	}

	// takes two *sorted* ArrayLists of Integers and merges them together into a
	// sorted list
	public static ArrayList<Integer> merge(ArrayList<Integer> al1, ArrayList<Integer> al2) {
		// create new list to store sorted values and index variables
		ArrayList<Integer> merge = new ArrayList<Integer>();
		int index1 = 0;
		int index2 = 0;

		// while there are elements in both lists, compare first element of each and add
		// lower one to next available index of merge
		while (al1.size() > index1 && al2.size() > index2) {
			if ((int) al1.get(index1) < (int) al2.get(index2)) {
				merge.add(al1.get(index1)); // adds from al1
				index1++; // moves index in al1, index in al2 stays the same
			} else { // this handles cases of elements being equal, too
				merge.add(al2.get(index2)); // adds from al2
				index2++; // moves index in al2, index in al1 stays the same
			}
		}

		// once one of the lists is empty, add all remaining elements in other list to
		// merge
		while (al1.size() > index1) { // will skip if al1 is empty
			merge.add(al1.get(index1));
			index1++;
		}
		while (al2.size() > index2) { // will skip if al2 is empty
			merge.add(al2.get(index2));
			index2++;
		}

		// return the sorted ArrayList
		return merge;
	} // merge

	// takes an Integer ArrayList and returns a sorted version of the ArrayList,
	// while leaving original list untouched
	public static ArrayList<Integer> mergeSort(ArrayList<Integer> al) {
		// base case: once list is size 1, we no longer split it, just return it
		if (al.size() == 1) {
			return al;
		}
		// create two new empty lists
		ArrayList<Integer> split1 = new ArrayList<Integer>();
		ArrayList<Integer> split2 = new ArrayList<Integer>();
		int mid = al.size() / 2;

		// Store the first and second halves of al in separate ArrayLists
		split1 = slice(al, 0, mid);
		split2 = slice(al, mid, al.size());

		// Sort the two lists.
		split1 = mergeSort(split1);
		split2 = mergeSort(split2);
		/**
		 * Think about it: by the time we get to this next line, split1 and split2 are
		 * SORTED LISTS, no matter how large they are! How do we know? Because we
		 * MERGESORTED them... duh!
		 **/
		return merge(split1, split2);
	} // mergeSort

	// returns a new ArrayList consisting of the elements of al [lo,hi)
	public static ArrayList<Integer> slice(ArrayList<Integer> al, int lo, int hi) {
		ArrayList<Integer> sub = new ArrayList<Integer>(); // new ArrayList to store values
		for (; lo < hi; lo++) {
			sub.add(al.get(lo));
		} // copies elements from al to sub
		return sub;
	}// slice

	// return ArrayList of random ints on range [lo,lo+hi)
	public static ArrayList<Integer> prestoArrayListo(int numItems, int lo, int hi) {
		ArrayList<Integer> retArr = new ArrayList<Integer>();

		for (int i = 0; i < numItems; i++) {
			// System.out.println(i); //diagnostic under-the-hood view
			// retArr.add( Math.random() ); // [0,1)
			// retArr.add( (int)Math.random() ); // 0
			// retArr.add( (int)(hi * Math.random()) ); // [0,hi)
			retArr.add(lo + (int) (hi * Math.random())); // [lo,lo+hi)
		}
		return retArr;
	}// end prestoArrayListo()

	// takes two *sorted* ArrayLists of Integers and merges them together into a
	// sorted list. NOW WITH HELPFUL OUTPUT! FUN!
	public static ArrayList<Integer> mergeWithOutput(ArrayList<Integer> al1, ArrayList<Integer> al2) {
		System.out.println("Merging back up to Level " + level + ": " + al1 + " and " + al2);
		// create new list to store sorted values and index variables
		ArrayList<Integer> merge = new ArrayList<Integer>();
		int index1 = 0;
		int index2 = 0;

		// while there are elements in both lists, compare first element of each and add
		// lower one to next available index of merge
		while (al1.size() > index1 && al2.size() > index2) {
			if ((int) al1.get(index1) < (int) al2.get(index2)) {
				merge.add(al1.get(index1)); // adds from al1
				index1++; // moves index in al1, index in al2 stays the same
			} else { // this handles cases of elements being equal, too
				merge.add(al2.get(index2)); // adds from al2
				index2++; // moves index in al2, index in al1 stays the same
			}
		}

		// once one of the lists is empty, add all remaining elements in other list to
		// merge
		while (al1.size() > index1) { // will skip if al1 is empty
			merge.add(al1.get(index1));
			index1++;
		}
		while (al2.size() > index2) { // will skip if al2 is empty
			merge.add(al2.get(index2));
			index2++;
		}
		System.out.println("Level " + level + ": " + merge);

		// return the sorted Arraylist
		return merge;
	} // mergeWithOutput

	// takes an int ArrayList and returns a sorted version of the Arraylist, while
	// leaving original list untouched. NOW WITH HELPFUL OUTPUT! FUN!
	public static ArrayList<Integer> mergeSortWithOutput(ArrayList<Integer> al) {
		if (al.size() == 1) {
			return al;
		}
		System.out.println("\nLevel " + level + ": " + al);
		level++;
		System.out.println("Splitting down to level " + level);
		// create two new empty lists
		ArrayList<Integer> split1 = new ArrayList<Integer>();
		ArrayList<Integer> split2 = new ArrayList<Integer>();
		int mid = al.size() / 2;
		// Store the first and second halves of al in separate lists
		split1 = slice(al, 0, mid);
		split2 = slice(al, mid, al.size());
		System.out.print("split1 = " + (split1.size() == 1 ? "***" : "") + split1);
		System.out.println(", split2 = " + (split2.size() == 1 ? "***" : "") + split2);
		// if either list has more than 1 element, send it back to be split again
		// if a list has exactly 1 element, it does not recur
		// this method will keep recurring until both lists have 1 element
		split1 = mergeSortWithOutput(split1);
		split2 = mergeSortWithOutput(split2);
		// by the time it reaches this statement, split1 and split2 are sorted
		level--;
		return mergeWithOutput(split1, split2);
	} // mergeSortWithOutput

	public static void mergeSortReplaceWithOutput(ArrayList<Integer> al) {
		// calls the split method, which will return the sorted list as a new ArrayList
		ArrayList<Integer> merge = mergeSortWithOutput(al);
		// replace current list with new sorted list.
		al.clear();
		while (merge.size() > 0) {
			al.add(merge.remove(0));
		}
	} // mergeSortReplaceWithOutput
} // end class