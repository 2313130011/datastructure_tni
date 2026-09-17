package sss;
 


public class TreeApp3 {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.createTree5();

        tree.printTree(tree.getRoot(), 0);
        System.out.println("-----------------------------------");

        tree.delete(25);
        tree.printTree(tree.getRoot(), 0);
        System.out.println("-----------------------------------");

        tree.delete(10);
        tree.printTree(tree.getRoot(), 0);
        System.out.println("-----------------------------------");

        tree.delete(30);
        tree.printTree(tree.getRoot(), 0);
    }
}