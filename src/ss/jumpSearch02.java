package ss;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class jumpSearch02 {

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

		int index = jumpSearch(array, target);

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

		Sorting sort = new Sorting(nums);

		sort.bubbleSort();

		return sort.getArray();

	}

	public static int jumpSearch(int[] nums, int target) {

		int n = nums.length;

		int step = (int) Math.sqrt(n);

		int prev = 0;

		while (nums[Math.min(step, n) - 1] < target) {

			prev = step;

			step += (int) Math.sqrt(n);

			if (prev >= n) {

				return -1;

			}

		}

		while (nums[prev] < target) {

			prev++;

			if (prev == Math.min(step, n)) {

				return -1;

			}

		}

		if (nums[prev] == target) {

			return prev;

		}

		return -1;

	}

}