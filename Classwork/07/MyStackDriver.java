public class MyStackDriver {
	public static void main(String[] args) {
		LList list = new LList();
		MyStack stack = new MyStack(list);
		/*
		 * System.out.println("Testing empty stack toString()\n" + stack);
		 * System.out.println(); System.out.println("Testing Exceptions:"); try {
		 * stack.pop(); } catch (Exception e) { System.out.println("Empty stack!");
		 * e.printStackTrace(); } try { stack.top(); } catch (Exception e) {
		 * System.out.println("Empty stack!"); e.printStackTrace(); } try { for (int i =
		 * 0; i < 11; i++) stack.push(""); } catch (Exception e) {
		 * System.out.println("Stack overflow!"); e.printStackTrace(); for (int i = 0; i
		 * < 10; i++) stack.pop(); }
		 */
		System.out.println("Testing push, which should add to LList");
		stack.push("Larry");
		stack.push("Curly");
		stack.push("Moe");
		stack.push("Shemp");
		System.out.println(list);
		System.out.println();
		System.out.println("Testing toString()");
		System.out.println(stack);
		stack.pop();
		stack.pop();
		System.out.println("\n After two pops!");
		System.out.println(stack);
		System.out.println();
		stack.push("Groucho");
		stack.push("Zeppo");
		System.out.println(stack);
		System.out.println();
		System.out.println("Testing top() = " + stack.top());
		System.out.println(stack);
		System.out.println("\nTesting reverse:");
		System.out.println(MyStack.reverse("Beginning"));
		System.out.println("\nTesting palindrome:");
		System.out.println(MyStack.isPalindrome("racecar"));
		System.out.println(MyStack.isPalindrome("i am what am i"));
		System.out.println(MyStack.isPalindrome("able was i ere i saw elba"));
		System.out.println("\nTesting ParenCheck");
		System.out.println("5 + (3 + 2) == " + MyStack.parenCheck("5 + (3 + 2) == "));
		System.out.println("5 + (3 + 2)) == " + MyStack.parenCheck("5 + (3 + 2)) == "));
		System.out.println("5 +) (3 + 2)) == " + MyStack.parenCheck("5 +) (3 + 2)) == "));
		System.out.println("\nTesting word palindrome:\n");
		System.out.println(MyStack.isWordPalindrome("i am what am i"));
		System.out.println(MyStack.isWordPalindrome("baby shark doo doo do do do do"));
		System.out.println("\nTesting reverse words:");
		System.out.println("baby shark doo doo do do do do reversed:\n"+MyStack.reverseWords("baby shark doo doo do do do do"));




	}// end main
}// end class