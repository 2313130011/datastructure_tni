public class BookingNode {
    public Booking data;
    public BookingNode left, right;

    public BookingNode(Booking data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
