 
import java.util.LinkedList;
 
public class ShoppingCart {
 
	public static void main(String[] args) {
		
		LinkedList<String> cart = new LinkedList<String>();
		
		cart.add("Wireless Mouse");
		cart.add("Mechanical Keyboard");
		cart.add("USB-C Hub");
		System.out.println(cart);
		
		cart.add(1, "Mouse Pad");
		System.out.println(cart);
		
		cart.remove(cart.size()-1);
		System.out.println(cart);
		
		cart.remove("Mouse pad");
		System.out.println(cart);
 
		cart.remove("Monitor");
		System.out.println(cart);
		
		cart.remove("Phone Holder");
		System.out.println(cart);
		
		System.out.println(cart.getLast());
		
		
		
		
 
	}
 
}
 