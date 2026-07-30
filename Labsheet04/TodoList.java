public class TodoList {
	
	public static void main(String[] args) {
		
		DoublyLinkedList todoList = new DoublyLinkedList();
 
	    todoList.insert("Finish Homework");
	    todoList.insert("Laundry");
	    todoList.insert("Group Meeting");
	    System.out.println("To-Do List = " + todoList.traversal());
 
	    todoList.insert(0, "Submit report");
	    System.out.println("To-Do List = " + todoList.traversal());
 
	    todoList.insert(2, "Buy Food");
	    System.out.println("To-Do List = " + todoList.traversal());
 
	    todoList.insert("Go to Gym");
	    System.out.println("To-Do List = " + todoList.traversal());
 
	    todoList.remove();
 
	    todoList.remove(todoList.indexOf("Laundry"));
 
	    todoList.remove(0);
 
	    System.out.println("To-Do List = " + todoList.traversal());
 
	    System.out.println("Backward Traversal = " + todoList.backwardTraversal());
	}