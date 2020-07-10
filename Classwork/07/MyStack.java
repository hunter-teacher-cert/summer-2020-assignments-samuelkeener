public class MyStack {
	// add your internal data structure here
	private LList theList;

	public MyStack(LList list) {
		theList = list;
	}

	public void push(String data) {
		theList.add(data); // adjusted add method to add to the end always (insert handles indexes)
	}

	public String pop() {
		int length = size();
		String pop = theList.get(length - 1); // stores data value of last element
		theList.remove(length - 1); // removes last element
		return pop;
	}

	public String top() {
		return theList.get(size() - 1);
	}

	public boolean isEmpty() {
		return theList.isEmpty();
	}

	// returns number of items in theList
	public int size() {
		return theList.getLength();
	}

	public String toString() {
		if (size() == 0)
			return "Empty Stack";
		String output = "Top --> ";
		for (int i = size() - 1; i > 0; i--) { // loops backwards from top to bottom
			output += theList.get(i) + "\n\t";
		}
		output += theList.get(0) + " <----Bottom"; //prints the bottom index.
		return output;
	}

} // end class