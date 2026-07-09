
public class Ex01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums = {23, 67, 8, 91, 45, 12, 78};
		
		System.out.println("Length = " + nums.length);
		System.out.println("The first element = " + nums[0]);
		System.out.println("The last element = " + nums[nums.length-1]);
		System.out.println("The minddle element = " + nums[nums.length/2]);
		
		System.out.println("\nDisplay all elements :");
		boolean first_element = true;
		for (int num : nums ) { 
			System.out.print ((!first_element ? "," : "")+ num);
			first_element = false;
	}
	}

}
