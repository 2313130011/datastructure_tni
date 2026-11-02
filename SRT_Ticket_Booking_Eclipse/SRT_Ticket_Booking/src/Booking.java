public class Booking {
    public int codeNumber;
    public String passengerName;
    public Train train;
    public int carriageNo;
    public String seat;
    public String status;

    public Booking(int codeNumber, String passengerName, Train train, int carriageNo, String seat) {
        this.codeNumber = codeNumber;
        this.passengerName = passengerName;
        this.train = train;
        this.carriageNo = carriageNo;
        this.seat = seat;
        this.status = "Booked Success";
    }

    public String getBookingCode() {
        return "B" + codeNumber;
    }

    public static int parseCode(String code) {
        if (code == null) return -1;
        code = code.trim().toUpperCase();
        if (code.startsWith("B")) code = code.substring(1);
        try {
            return Integer.parseInt(code);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
