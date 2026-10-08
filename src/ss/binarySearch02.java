package ss;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class binarySearch02 {

	public static void main(String[] args) {
		LinkedList<Integer> nums = random_initial();
		int[] array = new int[nums.size()];
		for (int i = 0; i < nums.size(); i++) {
			array[i] = nums.get(i);
		}
		array = sorting(array);
		System.out.print("Elements after sorting: ");
		for (int num : array) {
			System.out.print(num + " ");
		}
		Scanner input = new Scanner(System.in);
		System.out.print("\nEnter target: ");
		int target = input.nextInt();
		int index = binarySearch(array, target);
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

	public static int[] sorting(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = 0; j < nums.length - 1 - i; j++) {
				if (nums[j] > nums[j + 1]) {
					int temp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = temp;

				}

			}

		}

		return nums;

	}

	public static int binarySearch(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (target < nums[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return -1;

	}

}