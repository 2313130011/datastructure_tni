package ss;

import java.util.Scanner;

public class binarySearch01 {

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
		int index = binarySearch(nums, target);
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