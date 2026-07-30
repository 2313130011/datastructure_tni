public class Node {
	
	// Attributes in Class Node
	Node previous;
	Object data;
	Node next;
	
	// Constructor
	public Node (Object data) {
		this.previous = null;
		this.data = data;
		this.next = null;
	}
	
	// Method for getting address in specific node
	public String getAddress() {
		return "" + Integer.toHexString(System.identityHashCode(this));
	}
	
	public static String getAddress(Node node) {
		return (node == null) ? "null" : node.getAddress();
	}
	
}