package sss;

import java.util.Scanner;

public class TreeApp4 {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.createTree6();
        tree.printTree(tree.getRoot(), 0);

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Node targetNode = search(tree.getRoot(), n);

        if (targetNode == null) {
            System.out.println("Cannot found Node(data=" + n + ")");
            scanner.close();
            return;
        }

        if (targetNode.left != null) {
            System.out.println("Left Child = " + targetNode.left.data);
        } else {
            System.out.println("No Left Child");
        }

        if (targetNode.right != null) {
            System.out.println("Right Child = " + targetNode.right.data);
        } else {
            System.out.println("No Right Child");
        }

        if (targetNode.left == null && targetNode.right == null) {
            System.out.println(n + " is Leaf Node");
        } else {
            System.out.println(n + " is not Leaf Node");
        }

        scanner.close();
    }

    private static Node search(Node root, int target) {
        Node current = root;
        while (current != null) {
            if (target == current.data) {
                return current;
            } else if (target < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null;
    }
}