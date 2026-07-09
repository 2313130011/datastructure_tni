import java.util.ArrayList;

public class Ex07 {

	public static void main(String[] args) {
		
		ArrayList<Integer> nums = new ArrayList<Integer>();
		
		System.out.println("Length =" + nums.size());
		
		nums.add(11);
		nums.add(12);
		nums.add(13);
		nums.add(14);
		nums.add(15);
		
		System.out.println("Length =" + nums.size());
		System.out.println("All elements =" + nums);

		int index_updete = 2;
		int element_updet =20;
		
		nums.set(index_updete, element_updet);
		System.out.println("All elements = " + nums);
		
		int index_delete = 2;
		
		nums.remove(2);
		System.out.println("All elements = " + nums);
		
		int index_elementsdelete = 15;

		nums.remove(Integer.valueOf(20));
		System.out.println("All elements = " + nums);

		nums.clear();
		System.out.println("All elements = " + nums);

		
	}

}
