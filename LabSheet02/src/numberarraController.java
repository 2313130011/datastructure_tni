
public class numberarraController {

	private int [] nums;
	
	public numberarraController() {
		this.nums = new int [] { 23, 67, 8, 91, 45, 12, 78};
	}
	
	public void setNums(int [] nums) {
		this.nums = nums;
	}
	
	public int [] getNums() {
		return nums;
	}
	public void display(String message) {
		System.out.println("\nDisplay all elements :");
		boolean first_element = true;
		for (int num : nums ) { 
			System.out.print ((!first_element ? ", " : "")+ num);
			first_element = false;
		}
	}
}
