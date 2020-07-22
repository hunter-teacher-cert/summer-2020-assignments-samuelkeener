import java.util.*;

public class MyStack {
	/* FIELDS */
	private LList theList;
	// private static final int MAX_STACK = 20;

	/* CONSTRUCTORS */
	public MyStack(LList list) {
		theList = list;
	}

	public MyStack() {
		this(new LList());
	}

	/* METHODS */
	public void push(String data) {
		/*
		 * if (size() == MAX_STACK) throw new
		 * IndexOutOfBoundsException("Maximum stack size reached!");
		 */
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

	// returns Stack of String with first index at bottom
	public static MyStack stringToStack(String s) {
		MyStack string = new MyStack();
		for (int i = 0; i < s.length(); i++) {
			string.push("" + s.charAt(i));
		}
		return string;
	}

	// returns a reversed String of s
	public static String reverse(String s) {
		MyStack string = stringToStack(s);
		String reverse = "";
		while (!(string.isEmpty())) {
			reverse += string.pop();
		}
		return reverse;

	}

	// returns true if String is palindrome
	public static boolean isPalindrome(String s) {
		return s.equals(reverse(s));
	}

	// returns true if Arithmetic String follows bracket rules
	public static boolean parenCheck(String exp) {
		MyStack expression = stringToStack(reverse(exp));
		MyStack delimStack = new MyStack(); //will create a stack of delimiters "(),[],{}"
		while (expression.size() > 0) {
			String check = expression.pop();
			//finds open delimiters
			if (check.equals("(") || check.equals("{") || check.equals("[")) { //puts open delims on top of stack
				delimStack.push(check);
			}
			//Finds close delimiter
			if (check.equals(")") || check.equals("}") || check.equals("]")) {
				//if stack is empty or most recent open is not compatible, returns false
				if (delimStack.isEmpty() || !delimStack.top().equals(reverseDelim(check))) {
					return false;
				} else
					//if top of stack is the counterpart open of a close delim, then pops it off the stack
					delimStack.pop();
			}
		}
		//if delimStack is empty, it means everything went okay! return true!
		return delimStack.isEmpty();
	}

	// reverses the order of a MyStack
	public static void reverseStack(MyStack stack) {
		LList list = new LList();
		while (stack.size() > 0) {
			list.addFront(stack.pop());
		}
		stack.setList(list);
	}

	
	//Takes in a close delimiter and returns the requisite open version
	public static String reverseDelim(String closeDel) {
		if (closeDel.equals(")"))
			return "(";
		else if (closeDel.equals("]"))
			return "[";
		else 
			return "{";		
	}

	public static boolean isWordPalindrome(String s) {
		//Leaving this horribly complex version for posterity...
		/*MyStack words = new MyStack();
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
		return true;*/
		return s.equals(reverseWords(s));
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
			reverse += words.pop() + " "; // adds word then space
		}
		reverse += words.pop(); // adds last word without space
		return reverse;

	}

} // end class