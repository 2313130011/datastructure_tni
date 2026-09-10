package sss;

public class TreeApp {
	 
	public static void main(String[] args) {
		System.out.println("------------------------------");
		System.out.println("Binary Tree from createTree1");
		System.out.println("------------------------------");
		
		BinaryTree tree = new BinaryTree();
		tree.createTree2();
		tree.printTree(tree.getRoot(), 0);
 
	}
 
}