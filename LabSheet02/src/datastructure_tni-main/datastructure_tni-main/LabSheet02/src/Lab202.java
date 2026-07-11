import java.util.ArrayList;

public class Lab202 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        int[] initial_numbers = {10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
        
        for (int num : initial_numbers) {
            numbers.add(num);
        }
        
        int numToAdd = 20;
        numbers.add(numToAdd);
        
        int lastDigit = 7;
        int secondLastDigit = 6;
        int thirdLastDigit = 5;
        int currentDay = 11;
        
        int numToInsert = 99;
        numbers.add(lastDigit, numToInsert);
        
        numbers.remove(secondLastDigit);
        
        numbers.set(thirdLastDigit, currentDay);
        
        System.out.println("All elements = " + numbers);
    }
} 