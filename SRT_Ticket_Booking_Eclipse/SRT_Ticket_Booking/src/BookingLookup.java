import java.util.Scanner;

public class BookingLookup {
    private BookingBST bookings;

    public BookingLookup(BookingBST bookings) {
        this.bookings = bookings;
    }

    public void run(Scanner input) {
        System.out.print(" Booking-code : ");
        String codeInput = input.nextLine().trim();
        int codeNumber = Booking.parseCode(codeInput);
        if (codeNumber == -1) {
            System.out.println(" Invalid booking-code format (example: B1402)");
            return;
        }

        Booking booking = bookings.search(codeNumber);

        if (booking == null) {
            System.out.println(" Booking-code " + codeInput.toUpperCase() + " not found.");
        } else {
            System.out.println();
            System.out.println(" Passenger Name : " + booking.passengerName);
            System.out.println(" Train No." + booking.train.trainNo + " " + booking.train.type
                    + " (" + booking.train.getRouteName() + ")");
            System.out.println(" Carriage No." + booking.carriageNo + "  Seat " + booking.seat);
            System.out.println(" STATUS : " + booking.status);
        }
        System.out.println("\n (BST Search visited " + bookings.getLastVisitedNodes() + " nodes"
                + " | total bookings = " + bookings.size()
                + " | tree height = " + bookings.height() + ")");
    }
}
