package labsheet;
 
public class NumberLinkedList {
 
	public static void main(String[] args) {
 
		LinkedList numbers = new LinkedList();
 
		numbers.insert(0, 37);
		numbers.insert(0, 7);
		numbers.insert(0, 4);
		numbers.insert(0, 16);
 
		System.out.print("All elements = " + numbers.traversal());
 
		numbers.insert(2, 20);
 
		System.out.print("\nInsert 20 to index 2 = " + numbers.traversal());
 
		numbers.insert(25);
 
		System.out.print("\nAppend 25 into list  = " + numbers.traversal());
 
		numbers.remove(0);
 
		System.out.print("\nDeleted the first element = " + numbers.traversal());
 
		numbers.remove(2);
 
		System.out.print("\nDeleted element index 2   = " + numbers.traversal());
 
		numbers.removeLastElement();
 
		System.out.print("\nDeleted the last element  = " + numbers.traversal());
 
		System.out.print("\n\nLength of elements in List= " + numbers.length());
 
		System.out.print("\nElement in index 1        = " + numbers.get(1));
 
		numbers.set(1, 100);
 
		System.out.print("\nUpdated index 1 to 100    = " + numbers.traversal());
 
		numbers.clear();
 
		System.out.print("\nClear Linked List = " + numbers.traversal());
 
	}
 
}
 