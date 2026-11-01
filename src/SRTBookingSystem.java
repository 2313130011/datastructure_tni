import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class SRTBookingSystem {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random(2569);

        ArrayList<Train> trainList = TrainData.loadTrains();
        BookingBST bookings = new BookingBST();
        BookingCodeGenerator codeGenerator = new BookingCodeGenerator(bookings, random);
        TrainData.loadExistingBookings(trainList, bookings, codeGenerator, random);

        TrainSearch feature1 = new TrainSearch(trainList);
        SeatBooking feature2 = new SeatBooking(trainList, bookings, codeGenerator);
        BookingLookup feature3 = new BookingLookup(bookings);
        CancelBooking feature4 = new CancelBooking(bookings, feature2);

        while (true) {
            printMenu();
            System.out.print(" Choose an option: ");
            if (!input.hasNextLine()) break;
            String option = input.nextLine().trim();
            System.out.println();

            if (option.equals("1")) {
                feature1.run(input);
            } else if (option.equals("2")) {
                feature2.run(input);
            } else if (option.equals("3")) {
                feature3.run(input);
            } else if (option.equals("4")) {
                feature4.run(input);
            } else if (option.equals("0")) {
                System.out.println(" Thank you for using SRT Ticket Booking System.");
                break;
            } else {
                System.out.println(" Invalid option, please try again.");
            }

            System.out.print("\n Press Enter to continue...");
            if (!input.hasNextLine()) break;
            input.nextLine();
        }
        input.close();
    }

    private static void printMenu() {
        System.out.println();
        System.out.println(" ======================================");
        System.out.println("    SRT Ticket Booking System (Demo)");
        System.out.println(" ======================================");
        System.out.println(" [1] Searching for trains");
        System.out.println(" [2] Booking seat");
        System.out.println(" [3] Check the booking by booking-code");
        System.out.println(" [4] Cancel booking (auto waiting list)");
        System.out.println(" [0] Exit");
    }
}
