class Node {
	public int  data;
	public Node next;
	
	public Node(int value) {
		this.data = value;
		this.next = null;
	}
}

public class SinglyLinkedList {
	private Node head;
	private Node tail;
	
	public SinglyLinkedList() {
		head = null;
		tail = null;
	}
	
	public String displayList() {
		boolean first = true;
		String  display = "[";
		for (Node current = head; current != null; current = current.next) {
			display += (!first ? ", " : "") + current.data;
			first = false;
		}
		display += "]";
		return display;
	}
	
	public void clear() {
		head = null;
		tail = null;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void append(int value) {
		Node newNode = new Node(value);
		if (isEmpty()) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
	}
	
	public Object get(int position) {
		int index = 0;
		for (Node current = head; current != null; current = current.next) {
			if (index == position) {
				return current.data;
			}
			index++;
		}
		return null;
	}
	
	public void set(int position, int value) {
		int index = 0;
		for (Node current = head; current != null; current = current.next) {
			if (index == position) {
				current.data = value;
				System.out.println("Updated data success!!");
				return;
			}
			index++;
		}
		System.out.println("Updated data fail...");
	}
	
	public boolean contains(int value) {
		for (Node current = head; current != null; current = current.next) {
			if (current.data == value) {
				return true;
			}
		}
		return false;
	}
	
	public void addAll(SinglyLinkedList otherlist) {
		for (Node current = otherlist.head; current != null; current = current.next) {
			this.append(current.data);
		}
	}
	
}