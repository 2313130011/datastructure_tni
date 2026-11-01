import java.util.Random;

public class BookingCodeGenerator {
    private BookingBST bookings;
    private Random random;

    public BookingCodeGenerator(BookingBST bookings, Random random) {
        this.bookings = bookings;
        this.random = random;
    }

    public int nextCode() {
        int code;
        do {
            code = 1000 + random.nextInt(9000);
        } while (bookings.contains(code));
        return code;
    }
}
