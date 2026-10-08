package ss;

import java.util.Scanner;

public class jumpSearch01 {

	public static void main(String[] args) {
		int[] nums = { 96, 87, 18, 6, 31, 11, 56, 36, 76 };

		nums = sorting(nums);
		System.out.print("Elements after sorting: ");
		for (int num : nums) {
			System.out.print(num + " ");
		}

		Scanner input = new Scanner(System.in);
		System.out.print("\nEnter target: ");

		int target = input.nextInt();
		int index = jumpsearch(nums, target);

		if (index != -1) {
			System.out.println("The target (" + target + ") at index " + index);
		} else {

			System.err.println("Cannot found " + target + " in the array");

		}

	}

	public static int[] sorting(int[] nums) {
		Sorting sort = new Sorting(nums);
		sort.bubbleSort();
		return sort.getArray();

	}

	public static int jumpsearch(int[] nums, int target) {
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