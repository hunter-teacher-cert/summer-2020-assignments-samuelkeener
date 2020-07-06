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
		if (data.length == numberElements) {
			grow();
			data[data.length - 1] = value;
		} else {
			data[numberElements] = value;
		}
		numberElements++;
	}

	public void add(int index, int value) {
		if (index >= data.length)
			return;
		if (data[data.length - 1] != 0)
			grow();
		for (int i = data.length - 1; i > index; i--) {
			data[i] = data[i - 1];
		}
		data[index] = value;
		numberElements++;
	}

	public void remove(int index) {
		data[index] = 0;
		for (int i = index; i < data.length - 1; i++) {
			data[i] = data[i + 1];
		}
	}

	public int get(int index) {
		return data[index];
	}

	public boolean isEmpty() {
		boolean flag = true;
		for (int i = 0; i < data.length; i++) {
			if (data[i] != 0)
				flag = false;
		}
		return flag;
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
		int[] temp = new int[data.length+1];
		for (int i = 0; i < data.length; i++) {
			temp[i] = data[i];
		}
		data = temp;
	}

} // end class
