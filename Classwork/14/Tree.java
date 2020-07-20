public class Tree {
	private TreeNode root;

	public Tree() {
		root = null;
	}

	public void seed() {
		TreeNode t;
		t = new TreeNode(10);
		root = t;
	}

	public boolean delete(int key) {
		// find location
		TreeNode current = root;
		TreeNode parent = root;
		while (current != null && current.getData() != key) {
			int currentValue = current.getData();
			if (currentValue < key) {
				parent = current;
				current = current.getRight();
			} else {
				parent = current;
				current = current.getLeft();
			}
		}
		if (current == null) {
			return false;
		}
		// if leaf, point parent to null
		if (numChildren(current) == 0) {
			if (parent.getData() < key) {
				parent.setRight(null);
			} else {
				parent.setLeft(null);
			}
			return true;
		} // end no-children

		// if one child, point parent to child
		else if (numChildren(current) == 1) {
			if (current.getRight() != null) {
				if (parent.getData() < key) {
					parent.setRight(current.getRight());
				} else {
					parent.setLeft(current.getRight());
				}
			} else {
				if (parent.getData() < key) {

					parent.setRight(current.getLeft());
				} else {
					parent.setLeft(current.getLeft());
				}
			}
			return true;

		} // end one-child

		// if two children
		else {
			// find largest value to the left of delete index
			TreeNode delete = current; // saves node to be deleted

			TreeNode delParent = parent; // saves parent of deletion index
			parent = current;
			current = current.getLeft(); // sets current to smaller child of delete
			while (current.getRight() != null) { // always tries to getRight until it can't any more
				parent = current;
				current = current.getRight();
			}

			// attach possible child of largest value to its grandparent
			if (parent == delete) { // only case where we'd set it left
				parent.setLeft(current.getLeft());
			} else {
				parent.setRight(current.getLeft());
			}
			// attach delete's children to their new parent
			current.setLeft(delete.getLeft());
			current.setRight(delete.getRight());
			// attach delete's parent to its new child
			if (delParent.getData() < key) {
				delParent.setRight(current);
			} else {
				delParent.setLeft(current);
			}
			if (delete == root) {
				root = current;
			}
			return true;
		} // end else

	}

	private int numChildren(TreeNode node) {
		int count = 0;
		if (node.getRight() != null)
			count++;
		if (node.getLeft() != null)
			count++;
		return count;
	}

	public boolean search(int key) {
		TreeNode current = root;
		while (current != null) {
			int currentValue = current.getData();
			if (currentValue == key) {
				return true;
			} else if (currentValue < key) {
				current = current.getRight();
			} else {
				current = current.getLeft();
			}
		}
		return false;
	}

	private void preorderTraverse(TreeNode current) {
		if (current == null)
			return;

		System.out.print(current.getData() + ", ");

		preorderTraverse(current.getLeft());
		preorderTraverse(current.getRight());
	}

	private void postorderTraverse(TreeNode current) {
		if (current == null)
			return;

		postorderTraverse(current.getLeft());
		postorderTraverse(current.getRight());
		System.out.print(current.getData() + ", ");
	}

	private void inorderTraverse(TreeNode current) {
		if (current == null)
			return;

		inorderTraverse(current.getLeft());
		System.out.print(current.getData() + ", ");

		inorderTraverse(current.getRight());
	}

	public void preorderTraverse() {
		preorderTraverse(root);
		System.out.println();
	}

	public void postorderTraverse() {
		postorderTraverse(root);
		System.out.println();
	}

	public void inorderTraverse() {
		inorderTraverse(root);
		System.out.println();
	}

	public int insert(int value) {
		TreeNode insert = new TreeNode(value);

		// if the tree is empty, manually insert new node as root
		if (root == null) {
			root = insert;
			return 0;
		}

		TreeNode front = root;
		TreeNode trailer = null;

		while (front != null) {
			int frontValue = front.getData();
			if (frontValue == value) {
				return frontValue;
			} else if (frontValue < value) {
				trailer = front;
				front = front.getRight();
			} else {
				trailer = front;
				front = front.getLeft();
			}
		}

		int trailerValue = trailer.getData();
		if (value < trailerValue) {
			trailer.setLeft(insert);
			return value;
		} else {
			trailer.setRight(insert);
			return value;
		}
	}
}