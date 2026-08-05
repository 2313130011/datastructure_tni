import java.util.Scanner;

import java.util.Stack;
 
 
public class LabStack01 {

    public static void main(String[] args) {

        String tc1 = "SUM([A1+B1]*{C1-D1})";

        String tc2 = "IF((a>0, [b*2]), c)";

        String tc3 = "Hello ((world)";

        String tc4 = "Malee (2613510002)";
 
        System.out.println("Testcase 1 = " + (isBalance(tc1) ? "Balance" : "Not Balance"));

        System.out.println("Testcase 2 = " + (isBalance(tc2) ? "Balance" : "Not Balance"));

        System.out.println("Testcase 3 = " + (isBalance(tc3) ? "Balance" : "Not Balance"));

        System.out.println("Testcase 4 = " + (isBalance(tc4) ? "Balance" : "Not Balance"));

    }
 
    public static boolean isBalance(String message) {

        Stack<Character> stacks = new Stack<>();

        for (int i = 0; i < message.length(); i++) {

            char letter = message.charAt(i);

            if (letter == '(' || letter == '[' || letter == '{') {

                stacks.push(letter);

            } else if (letter == ')' || letter == ']' || letter == '}') {

                if (stacks.isEmpty()) {

                    return false;

                }

                char open = stacks.pop();

                if ((letter == ')' && open != '(')

                        || (letter == ']' && open != '[')

                        || (letter == '}' && open != '{')) {

                    return false;

                }

            }

        }

        return stacks.isEmpty();

    }

}
 