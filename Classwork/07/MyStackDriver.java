public class MyStackDriver {
	public static void main(String[] args) {
		LList list = new LList();
		list.add("Larry");
		list.add("Curly");
		list.add("Moe");
		list.add("Shemp");
		System.out.println(list);
		MyStack stack = new MyStack(list);
		System.out.println();
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
		System.out.println("Testing top() = "+stack.top());
		System.out.println(stack);

	}// end main
}// end class