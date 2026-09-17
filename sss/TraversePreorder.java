package sss;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class TraversePreorder {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.createTree1();    // Try to test with createTree2() and createTree3()

        tree.printTree(tree.getRoot(), 0);

        System.out.println();
        System.out.println("Preorder = " + traversal(tree.getRoot()));
    }

    public static ArrayList<Integer> traversal(Node node) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Deque<Node> stack = new ArrayDeque<Node>();

        if (node == null) {
            return list;
        }

        stack.push(node);

        while (!stack.isEmpty()) {
            Node current_node = stack.pop();

            list.add(current_node.data);
            if (current_node.right != null) {
                stack.push(current_node.right);
            }
            if (current_node.left != null) {
                stack.push(current_node.left);
            }
        }

        return list;
    }
}
