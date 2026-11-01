import java.util.Scanner;

public class CancelBooking {
    private BookingBST bookings;
    private SeatBooking seatBooking;

    public CancelBooking(BookingBST bookings, SeatBooking seatBooking) {
        this.bookings = bookings;
        this.seatBooking = seatBooking;
    }

    public void run(Scanner input) {
        System.out.print(" Booking-code to cancel : ");
        String codeInput = input.nextLine().trim();
        int codeNumber = Booking.parseCode(codeInput);
        if (codeNumber == -1) {
            System.out.println(" Invalid booking-code format (example: B1402)");
            return;
        }

        Booking booking = bookings.search(codeNumber);
        if (booking == null) {
            System.out.println(" Booking-code " + codeInput.toUpperCase() + " not found.");
            return;
        }

        System.out.println(" " + booking.getBookingCode() + " : " + booking.passengerName
                + " | Train " + booking.train.trainNo + " | Carriage " + booking.carriageNo
                + " | Seat " + booking.seat);
        System.out.print(" Confirm cancel? (y/n) : ");
        if (!input.nextLine().trim().equalsIgnoreCase("y")) {
            System.out.println(" Cancel aborted.");
            return;
        }

        Carriage carriage = booking.train.getCarriage(booking.carriageNo);
        int[] pos = carriage.parseSeat(booking.seat);
        carriage.release(pos[0], pos[1]);
        bookings.delete(codeNumber);
        System.out.println(" Booking " + booking.getBookingCode() + " cancelled. Seat "
                + booking.seat + " is now available.");

        if (!carriage.waitingList.isEmpty()) {
            String nextPassenger = carriage.waitingList.dequeue();
            Booking newBooking = seatBooking.createBooking(nextPassenger, booking.train, carriage, pos[0], pos[1]);
            System.out.println(" >> Seat " + newBooking.seat + " was given to waiting passenger: "
                    + nextPassenger + " (new booking-code: " + newBooking.getBookingCode() + ")");
            System.out.println(" >> Remaining waiting list: " + carriage.waitingList.traversal());
        }
    }
}
