package ss;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class LabQueue04 {
    public static Queue<String> q_printer = new ArrayDeque<String>();
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Press 1 Add a file to the queue");
        System.out.println("Press 2 View the file");
        System.out.println("Press 3 Print the file");

        while (true) {
            System.out.print("\nEnter an option: ");
            int option = input.nextInt();
            if (option == 1) {
                addFile();
            } else if (option == 2) {
                viewNextFile();
            } else if (option == 3) {
                printFile();
            } else {
                System.out.println("Exit");
                break;
            }
        }
    }

    public static void addFile() {
        System.out.print("Enter a file name: ");
        String fileName = input.next();
        q_printer.offer(fileName);
        System.out.println("Printer queue => " + q_printer);
    }

    public static void viewNextFile() {
        if (q_printer.isEmpty()) {
            System.out.println("No file in queue");
        } else {
            System.out.println("View: " + q_printer.peek());
            System.out.println("Printer queue => " + q_printer);
        }
    }

    public static void printFile() {
        if (q_printer.isEmpty()) {
            System.out.println("No file in queue");
        } else {
            System.out.println("Printing: " + q_printer.poll());
            if (q_printer.isEmpty()) {
                System.out.println("No file in queue");
            } else {
                System.out.println("Printer queue => " + q_printer);
            }
        }
    }
}
