import java.util.ArrayDeque;
import java.util.Queue;

public class QueueFirstFive {

	public static Queue<Integer> n_queue = new ArrayDeque<Integer>();

	public static void main(String[] args) {
		
		for (int i = 101; i <= 110; i++) {
			n_queue.add(i);
		}
		
		System.out.println("Queue => " + n_queue);
		
		int total = n_queue.size();
		for (int count = 0; count < total; count++) {
			int value = n_queue.poll();
			if (count < 5) {
				System.out.println(value);
			}
			n_queue.add(value);
		}
		
		System.out.println("Queue => " + n_queue);

	}

}