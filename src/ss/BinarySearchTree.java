package ss;

class Node {
	int data;
	Node left;
	Node right;
	
	public Node(int new_data) {
		data = new_data;
		left = null;
		right = null;
	}
}

public class BinarySearchTree {
	private Node root;
	
	public Node getRoot() {
		return root;
	}
	
	public void sampleTree() {
		int[] nums = {22, 11, 48, 10, 15, 29, 57, 23, 30};
		
		for (int num : nums) {
			insert(num);
		}
	}
	
	public void insert(int new_data) {
		if (root == null) {
			root = new Node(new_data);
		} else {
			Node current_node = root;
			while (true) {
				if (new_data < current_node.data) {
					if (current_node.left == null) {
						current_node.left = new Node(new_data);
						break;
					}
					current_node = current_node.left;
				}
				else if (new_data > current_node.data) {
					if (current_node.right == null) {
						current_node.right = new Node(new_data);
						break;
					}
					current_node = current_node.right; 
				}
				
			} //end while
		} //end if
	}
	
	public void printTree(Node node, int depth) {
		if (node != null) {
			printTree(node.right, depth + 1);
			System.out.println("    ".repeat(depth) + node.data);
			printTree(node.left, depth + 1);
		}
	}
}

