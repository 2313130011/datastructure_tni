public class Carriage {
    public static final char[] COLUMN_LABELS = {'A', 'B', 'C', 'D', 'E', 'F'};

    public int carriageNo;
    private String[][] seats;
    private int bookedCount;
    public WaitingQueue waitingList;

    public Carriage(int carriageNo, int rows, int cols) {
        this.carriageNo = carriageNo;
        this.seats = new String[rows][cols];
        this.bookedCount = 0;
        this.waitingList = new WaitingQueue();
    }

    public int getRows() { return seats.length; }
    public int getCols() { return seats[0].length; }
    public int getTotalSeats() { return getRows() * getCols(); }
    public int getAvailableSeats() { return getTotalSeats() - bookedCount; }
    public boolean isFull() { return bookedCount == getTotalSeats(); }

    public int[] parseSeat(String seatLabel) {
        if (seatLabel == null) return null;
        seatLabel = seatLabel.trim().toUpperCase();
        if (seatLabel.length() < 2) return null;

        char colChar = seatLabel.charAt(seatLabel.length() - 1);
        String rowPart = seatLabel.substring(0, seatLabel.length() - 1);
        int row;
        try {
            row = Integer.parseInt(rowPart) - 1;
        } catch (NumberFormatException e) {
            return null;
        }
        int col = colChar - 'A';
        if (row < 0 || row >= getRows() || col < 0 || col >= getCols()) return null;
        return new int[] {row, col};
    }

    public static String seatLabel(int row, int col) {
        return String.format("%02d%c", row + 1, COLUMN_LABELS[col]);
    }

    public boolean isAvailable(int row, int col) {
        return seats[row][col] == null;
    }

    public void book(int row, int col, String bookingCode) {
        if (seats[row][col] == null) bookedCount++;
        seats[row][col] = bookingCode;
    }

    public void release(int row, int col) {
        if (seats[row][col] != null) bookedCount--;
        seats[row][col] = null;
    }

    public int[] findFirstEmptySeat() {
        for (int r = 0; r < getRows(); r++) {
            for (int c = 0; c < getCols(); c++) {
                if (seats[r][c] == null) return new int[] {r, c};
            }
        }
        return null;
    }

    public void printSeatMap() {
        int cols = getCols();
        int aisle = cols / 2;
        StringBuilder header = new StringBuilder("      ");
        for (int c = 0; c < cols; c++) {
            if (c == aisle) header.append("   ");
            header.append(COLUMN_LABELS[c]).append("   ");
        }
        System.out.println(header);

        for (int r = 0; r < getRows(); r++) {
            StringBuilder line = new StringBuilder(String.format(" %02d   ", r + 1));
            for (int c = 0; c < cols; c++) {
                if (c == aisle) line.append("   ");
                line.append(seats[r][c] == null ? "[ ] " : "[x] ");
            }
            System.out.println(line);
        }
        System.out.println(" [ ] = Empty / [x] = Booked   (available " + getAvailableSeats()
                + "/" + getTotalSeats() + ")");
    }
}
