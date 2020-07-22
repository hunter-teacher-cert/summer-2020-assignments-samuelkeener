public class TreeNodeDriver {
	// Main method to drive
	public static void main(String[] args) {
		Tree t = new Tree();
		t.insert(10);
		t.insert(5);
		t.insert(20);
		t.insert(3);
		t.insert(7);
		t.insert(8);
		t.insert(25);
		t.preorderTraverse();
		t.postorderTraverse();
		t.inorderTraverse();
		t.delete(10);
		t.preorderTraverse();
		t.delete(8);
		t.preorderTraverse();
	} // end main
} // end class