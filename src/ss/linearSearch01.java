package ss;

import java.util.Scanner;

public class linearSearch01 {

	public static void main(String[] args) {
		int[] nums = {96, 87, 18, 6, 31, 11, 56, 36, 76};

		System.out.print("Elements : ");
		for (int num : nums) {
			System.out.print(num + " ");
		}

		Scanner input = new Scanner(System.in);
		System.out.print("\nEnter target: ");
		int target = input.nextInt();

		int index = linearSearch(nums, target);

		if (index != -1) {
			System.out.println("The target (" + target + ") at index " + index);
		} else {
			System.err.println("Cannot found " + target + " in this array");
		}
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