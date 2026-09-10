package sss;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class TraverseBFS {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.createTree1();    // Try to test with createTree2() and createTree3()
		tree.printTree(tree.getRoot(), 0);
		System.out.println();
		System.out.println("Postorder = " + traversal(tree.getRoot()));
	}
	
	
		 public static ArrayList<Integer> traversal(Node node) {
			    ArrayList<Integer> list = new ArrayList<>();

			    if (node != null) {
			        Queue<Node> queue = new ArrayDeque<>();
			        queue.add(node);

			        while (!queue.isEmpty()) {
			            Node current_node = queue.poll();

			            list.add(current_node.data);

			            if (current_node.left != null) {
			                queue.add(current_node.left);
			            }

			            if (current_node.right != null) {
			                queue.add(current_node.right);
			            }
			        }
			    }

			    return list;
			}
}

 