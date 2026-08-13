import java.util.ArrayDeque;
import java.util.Deque;

public class StackReverse {

	public static void main(String[] args) {
		
		String original = "Hello World";
		
		System.out.println("Original => " + original);
		
		String reverse = reverseCharacter(original);
		System.out.println("Reverse  => " + reverse);

	}

	public static String reverseCharacter(String original) {
		Deque<Character> stack = new ArrayDeque<Character>();
		
		// Push every character of original onto the stack
		for (int i = 0; i < original.length(); i++) {
			stack.push(original.charAt(i));
		}
		
		// Pop each character off the stack (LIFO) to build the reversed text
		StringBuilder result = new StringBuilder();
		while (!stack.isEmpty()) {
			result.append(stack.pop());
		}
		
		return result.toString();
	}

}