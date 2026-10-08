package ss;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class linearSearch02 {

	public static void main(String[] args) {
		LinkedList<Integer> nums = random_initial();
		System.out.print("Elements : ");
		for (int num : nums) {
			System.out.print(num + " ");

		}
		int[] array = new int[nums.size()];
		for (int i = 0; i < nums.size(); i++) {
			array[i] = nums.get(i);

		}

		Scanner input = new Scanner(System.in);
		System.out.print("\nEnter target: ");
		int target = input.nextInt();
		int index = linearSearch(array, target);

		if (index != -1) {

			System.out.println("The target (" + target + ") at index " + index);

		} else {

			System.err.println("Cannot found " + target + " in this linked list");

		}
	}

	public static LinkedList<Integer> random_initial() {
		Random rnd = new Random();
		LinkedList<Integer> nums = new LinkedList<Integer>();

		for (int i = 0; i < 10; i++) {
			nums.add(rnd.nextInt(100) + 1);

		}
		return nums;

	}

	public static int linearSearch(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			if (target == nums[i]) {

				return i;

			} 

		}

		return -1;

	}

}