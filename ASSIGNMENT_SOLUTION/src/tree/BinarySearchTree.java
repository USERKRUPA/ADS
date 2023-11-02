package tree;

public class BinarySearchTree<T extends Comparable<T>>{
	private Node<T> root;

	private static class Node<T extends Comparable<T>> implements Comparable<Node<T>> {
		private T data;
		private Node<T> right;
		private Node<T> left;

		Node(T data) {
			this.data = data;
			this.setLeft(null);
			this.setRight(null);
		}

		void setRight(Node<T> right) {
			this.right = right;
		}

		void setLeft(Node<T> left) {
			this.left = left;
		}

		T getData() {
			return this.data;
		}

		Node<T> getRight() {
			return this.right;
		}

		Node<T> getLeft() {
			return this.left;
		}

		@Override
		public String toString() {
			return data + ", ";
		}

		@Override
		public int compareTo(Node<T> o) {
			return this.getData().compareTo(o.getData());
		}
	}

	public BinarySearchTree() {
		this.root = null;
	}

	public void insert(T value) {
		Node<T> nwNode = new Node<>(value);
		if(root == null)
			root = nwNode;
		else
			insert(root, nwNode);
	}

	private void insert(Node<T> node, Node<T> nwNode) {
		if(nwNode.getData().compareTo(node.getData()) > 0) {
			//move right side
			if(node.getRight() == null)
				node.setRight(nwNode);
			else
				insert(node.getRight(), nwNode);
		}
		else {
			//move left side
			if(node.getLeft() == null)
				node.setLeft(nwNode);
			else
				insert(node.getLeft(), nwNode);
		}
	}
	
	public void inorderTraversal() {
		inorder(root);
		System.out.println();
	}
	
	private void inorder(Node<T> root) {
		if(root == null)
			return;
		inorder(root.getLeft());
		System.out.print(root); // calls to toString()
		inorder(root.getRight());
	}
	
	public void preorderTraversal() {
		preorder(root);
		System.out.println();
	}
	
	private void preorder(Node<T> root2) {
		if(root == null)
			return;
		System.out.print(root); // calls to toString()
		inorder(root.getLeft());
		inorder(root.getRight());
	}

	public void postorderTraversal() {
		postorder(root);
		System.out.println();
	}

	private void postorder(Node<T> root2) {
		if(root == null)
			return;
		inorder(root.getLeft());
		inorder(root.getRight());
		System.out.print(root); // calls to toString()
	}
}
