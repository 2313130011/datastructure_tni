package labshee10;

public class BSTApp1 {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        
        bst.sampleTree1();

        bst.printTree(bst.getRoot(), 0);

        Node minNode = bst.findMinimum();
        if (minNode != null) {
            System.out.println("Minimum Node is " + minNode.data);
        }

        Node maxNode = bst.findMaximum();
        if (maxNode != null) {
            System.out.println("Maximum Node is " + maxNode.data);
        }

        int target = 15;
        boolean result = bst.findSpecificData(target);
        System.out.println("Is " + target + " in BST => " + result);

        int delNode = 60;
        bst.searchDeleteNode(delNode);

        if (bst.getParent() != null) {
            System.out.println("Parent is " + bst.getParent().data);
        }
        if (bst.getDeleteNode() != null) {
            System.out.println("Delete Node is " + bst.getDeleteNode().data);
        }

        bst.deleteByLeftSubtree();
        bst.printTree(bst.getRoot(), 0);
    }
}