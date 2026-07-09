
public class Ex03 {

	public static void main(String[] args) {
		
		numberarraController nums = new numberarraController();
		nums.display("Display an initial array: ");
		
		int[] new_nums = new int [nums.getNums().length+1];
		
		for (int i = 0; i< nums.getNums().length; i++) {
			new_nums[i] = nums.getNums()[i];
		}

		nums.setNums(new_nums);
		nums.display("\n\nAfter copy elements: ");
		
		nums.getNums()[nums.getNums().length-1] = 15;
		nums.display("\n\nAfter added the last elements: ");

	}

}
