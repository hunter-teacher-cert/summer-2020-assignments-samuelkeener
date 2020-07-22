import java.util.*;

public class MyStack {
	/* FIELDS */
	private LList theList;
	private static final int MAX_STACK = 20;

	/* CONSTRUCTORS */
	public MyStack(LList list) {
		theList = list;
	}

	public MyStack() {
		this(new LList());
	}

	/* METHODS */
	public void push(String data) {
		if (size() == MAX_STACK)
			throw new IndexOutOfBoundsException("Maximum stack size reached!");
		theList.addFront(data); // adjusted add method to add to the end always (insert handles indexes)
	}

	public String pop() {
		if (isEmpty())
			throw new NoSuchElementException("Empty stack!");
		String pop = theList.get(0); // stores data value of last element
		theList.remove(0); // removes last element
		return pop;
	}

	public String top() {
		if (isEmpty())
			throw new NoSuchElementException("Empty stack!");
		return theList.get(0);
	}

	public boolean isEmpty() {
		return theList.isEmpty();
	}

	// returns number of items in theList
	public int size() {
		return theList.getLength();
	}

	public String toString() {
		if (isEmpty())
			return "Empty Stack";
		String output = "Top --> ";
		for (int i = 0; i < size() - 1; i++) { // loops backwards from top to bottom
			output += theList.get(i) + "\n\t";
		}
		output += theList.get(size() - 1) + " <----Bottom"; // prints the bottom index.
		return output;
	}

	public LList getList() {
		return theList;
	}

	public void setList(LList newList) {
		theList = newList;
	}

	// NEW STATIC METHODS //
	public static String reverse(String s) {
		MyStack string = new MyStack();
		for (int i = 0; i < s.length(); i++) {
			string.push("" + s.charAt(i));
		}
		String reverse = "";
		while (!(string.isEmpty())) {
			reverse += string.pop();
		}
		return reverse;

	}

	public static boolean isPalindrome(String s) {
		String forward = s.substring(0, s.length() / 2);
		System.out.println("Forward = " + forward);
		String backward = reverse(s.substring(s.length() / 2 + 1));
		System.out.println("Backward = " + backward);
		return forward.equals(backward);
	}

	public static boolean parenCheck(String s) {
		String reverse = reverse(s);
		MyStack string = new MyStack();
		for (int i = 0; i < reverse.length(); i++) {
			string.push("" + reverse.charAt(i));
		}
		int openCount = 0;
		int closeCount = 0;
		for (int i = 0; i < s.length(); i++) {
			String check = string.pop();
			if (check.equals("("))
				openCount++;
			if (check.equals(")"))
				closeCount++;
			if (closeCount > openCount)
				return false;
		}
		return openCount == closeCount;
	}
	
	
	public static boolean isWordPalindrome(String s) {
		MyStack words = new MyStack();
		// creates MyStack of words Strings in proper order
		while (s.length() > 0) {
			boolean end = false;
			int index = s.indexOf(" ");
			if (index == -1) {
				index = s.length();
				end = true;
			}
			words.push(s.substring(0, index));
			if (!end)
				s = s.substring(index + 1);
			else
				s = "";
		}
		System.out.println("Words stack:\n" + words);
		int numWords = words.size(); // stores number of words in Stack
		MyStack compare = new MyStack();
		// creates second stack with back half of words in reverse order
		for (int i = 0; i < numWords / 2; i++) {
			compare.push(words.pop());
		}
		if (compare.size() < words.size())
			words.pop(); // pops off the middle word if necessary
		// compares elements in both stacks, popping off the top each time
		System.out.println("The two half stacks:\n" + compare + "\n" + words);
		for (int i = 0; i < numWords / 2; i++) {
			if (!(compare.pop().equals(words.pop()))) // if at any time the words aren't the same, return false
				return false;
		}
		// if we made it through the previous loop without returning false, all elements
		// are equal
		return true;
	}
	
	public static String reverseWords(String s) {
		MyStack words = new MyStack();
		// creates MyStack of words Strings in proper order
		while (s.length() > 0) {
			boolean end = false;
			int index = s.indexOf(" ");
			if (index == -1) {
				index = s.length();
				end = true;
			}
			words.push(s.substring(0, index));
			if (!end)
				s = s.substring(index + 1);
			else
				s = "";
		}
		String reverse = "";
		while (words.size() > 1) {
			reverse+= words.pop() + " "; //adds word then space
		}
		reverse+=words.pop(); //adds last word without space
		return reverse;
		
		
	}

} // end class