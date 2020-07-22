public class TreeNode {
	// fields
	private TreeNode left;
	private TreeNode right;
	private int data;

	public TreeNode(int data) {
		this.data = data;
		left = null;
		right = null;
	}

	public TreeNode() {
		this(0);
	}

	public int getData() {
		return data;
	}

	public TreeNode getLeft() {
		return left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setLeft(TreeNode node) {
		left = node;
	}

	public void setRight(TreeNode node) {
		right = node;
	}

} // end class