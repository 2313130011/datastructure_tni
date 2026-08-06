package ss;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;

public class LabQueue03 {
    public static void main(String[] args) {
        Queue<Integer> q_number = new ArrayDeque<Integer>(Arrays.asList(10, 20, 30, 40, 50));
        System.out.println("Before reverse => " + q_number);
        reverse(q_number);
        System.out.println("After  reverse => " + q_number);
    }

    public static void reverse(Queue<Integer> queue) {
        Deque<Integer> stack = new ArrayDeque<Integer>();

        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }

        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }
    }
}