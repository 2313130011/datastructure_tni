package sss;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
 
public class TreeHeight {
 
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.createTree1();    // Try to test with createTree2() and createTree3()
		tree.printTree(tree.getRoot(), 0);
		System.out.println();
		System.out.println("Height of tree (DFS) = " + heightDFS(tree.getRoot()));
		System.out.println("Height of tree (BFS) = " + heightBFS(tree.getRoot()));
	}
	public static int heightDFS(Node node) {
		Deque<Node> stack_node = new ArrayDeque<Node>(); 
		Deque<Integer> stack_depth = new ArrayDeque<Integer>();
		int maxHeight = 0;
		stack_node.push(node);
		stack_depth.push(1);
		while (!stack_node.isEmpty()) {
			Node current_node = stack_node.pop();
			int depth = stack_depth.pop();
			maxHeight = Math.max(maxHeight, depth);
			if (current_node.left != null) {
				stack_node.push(current_node.left);
				stack_depth.push(depth+1);
			}
			if (current_node.right != null) {
				stack_node.push(current_node.right);
				stack_depth.push(depth+1);
			}
		}
		return maxHeight-1;
	}
	public static int heightBFS(Node node) {
		int height = 0;
		if (node != null) {
			Queue<Node> queue = new ArrayDeque<Node>();
			queue.add(node);
			while (!queue.isEmpty()) {
				height++;
				int levelSize = queue.size();
				for (int i=0; i<levelSize; i++) {
					Node current_node = queue.poll();
					if (current_node.left != null) {
						queue.add(current_node.left);
					}
					if (current_node.right != null) {
						queue.add(current_node.right);
					}
				}
			}
		}
		return height-1;
	}
 
}