import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
public class QueueRotate {
	public static Queue<Integer> queue = new ArrayDeque<Integer>();
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		originalQueue();
		System.out.println();
		
		while (true) {
			System.out.print("Press 1 to rotate queue: ");
			int choice = input.nextInt();
			
			if (choice == 1) {
				rotateQueue();
				System.out.println();
			} else {
				System.out.println("Exit");
				break;
			}
		}
		
	}
	
	public static void rotateQueue() {
		int front = queue.poll();
		System.out.println("Calling queue: " + front);
		queue.add(front);
		System.out.println("Queue => " + queue);
	}
	
	public static void originalQueue() {
		for (int i = 101; i <= 107; i++) {
			queue.add(i);
		}
		System.out.println("Queue => " + queue);
	}
}