import java.util.ArrayList;
import java.util.Arrays;

public class Lab201 {
    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<>(Arrays.asList("Alice", "Emma", "Leon", "John"));

        System.out.println("Length = " + names.size());

        System.out.println("All names in ArrayList = " + names);
    }
}