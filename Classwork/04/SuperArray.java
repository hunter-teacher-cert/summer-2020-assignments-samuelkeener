public class SuperArray {
	private int[] data;
	private int numberElements;

	// default constructor
	public SuperArray() {
		this(10);
	}

	// regular constructor (set size)
	public SuperArray(int size) {
		data = new int[size];
		numberElements = 0;
	}

	public void add(int value) {
		// is the array full?
		if (data.length == numberElements) {
			grow();
			data[data.length - 1] = value;
		} else {
			// put new value in proper index
			data[numberElements] = value;
		}
		numberElements++;
	}

	public void add(int index, int value) {
		// see if index is out of bounds
		if (index >= data.length)
			return;
		// see if the array is full
		if (data[data.length - 1] != 0)
			grow();
		// move everything after index forward
		for (int i = data.length - 1; i > index; i--) {
			data[i] = data[i - 1];
		}
		// add value
		data[index] = value;
		numberElements++;
	}

	public void remove(int index) {
		// shift everything after index one space to the left
		for (int i = index; i < data.length - 1; i++) {
			data[i] = data[i + 1];
		}
		// change last index to 0
		data[data.length - 1] = 0;
		// reduce number of elements
		numberElements--;
	}

	public int get(int index) {
		return data[index];
	}

	public boolean isEmpty() {
		return numberElements == 0;
	}

	public String toString() {
		String output = "[";
		for (int i = 0; i < data.length - 1; i++) {
			output += data[i] + ", ";
		}
		output += data[data.length - 1] + "]";
		return output;
	}

	public void grow() {
		// creates temp array
		int[] temp = new int[data.length + 1];
		// copies all values from data into temp
		for (int i = 0; i < data.length; i++) {
			temp[i] = data[i];
		}
		// changes reference of data variable to the new temp array permanently
		data = temp;
	}

} // end class
