import java.util.Scanner;

public class SinglyApp {

	public static SinglyLinkedList list1 = new SinglyLinkedList();
	public static SinglyLinkedList list2 = new SinglyLinkedList();
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("Test method 'append()'\n----------------------");
		testAppend();
		
		System.out.println("\nTest method 'get()'\n-------------------");
		testGet();            
		
		System.out.println("\nTest method 'set()'\n-------------------");
		testSet();            
		
		System.out.println("\nTest method 'contains()'\n-----------------------");
		testContains();       
		
		System.out.println("\nTest method 'addAll()'\n---------------------");
		testAddAll();         

	}

	public static void testAppend() {
		for (int i = 101; i <= 105; i++) {
			list1.append(i);
		}
		System.out.println("Current List => " + list1.displayList());
	}

	public static void testGet() {
		int i = 2;
		int j = 7;
		
		Object result1 = list1.get(i);
		System.out.println("Get element index " + i + " = " + (result1 != null ? result1 : "No data"));
		
		Object result2 = list1.get(j);
		System.out.println("Get element index " + j + " = " + (result2 != null ? result2 : "No data"));
	}

	public static void testSet() {
		list1.set(2, 111);
		System.out.println("Current List => " + list1.displayList());
		
		list1.set(7, 222);
		System.out.println("Current List => " + list1.displayList());
	}

	public static void testContains() {
		int find1 = 104;
		int find2 = 222;
		
		if (list1.contains(find1)) {
			System.out.println(find1 + " found!!");
		} else {
			System.out.println(find1 + " not found...");
		}
		
		if (list1.contains(find2)) {
			System.out.println(find2 + " found!!");
		} else {
			System.out.println(find2 + " not found...");
		}
	}

	public static void testAddAll() {
		// Merge list1 (has data) with list2 (empty)
		System.out.println("Elements in list1 => " + list1.displayList());
		System.out.println("Elements in list2 => " + list2.displayList());
		list1.addAll(list2);
		System.out.println("Merge result => " + list1.displayList());
		System.out.println();
		
		// Add 201 to 205 to list2, then merge again
		for (int i = 201; i <= 205; i++) {
			list2.append(i);
		}
		System.out.println("Elements in list1 => " + list1.displayList());
		System.out.println("Elements in list2 => " + list2.displayList());
		list1.addAll(list2);
		System.out.println("Merge result => " + list1.displayList());
		System.out.println();
		
		// Clear list1, then merge again
		list1.clear();
		System.out.println("Elements in list1 => " + list1.displayList());
		System.out.println("Elements in list2 => " + list2.displayList());
		list1.addAll(list2);
		System.out.println("Merge result => " + list1.displayList());
	}

}