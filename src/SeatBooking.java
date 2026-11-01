import java.util.ArrayList;
import java.util.Scanner;

public class SeatBooking {
    private Train[] trainsByNo;
    private BookingBST bookings;
    private BookingCodeGenerator codeGenerator;
    private int lastSearchSteps;

    public SeatBooking(ArrayList<Train> trainList, BookingBST bookings, BookingCodeGenerator codeGenerator) {
        this.bookings = bookings;
        this.codeGenerator = codeGenerator;

        trainsByNo = new Train[trainList.size()];
        for (int i = 0; i < trainList.size(); i++) {
            trainsByNo[i] = trainList.get(i);
        }
        quickSort(0, trainsByNo.length - 1);
    }

    public void run(Scanner input) {
        System.out.print(" Enter Train No.    : ");
        int trainNo = readInt(input);
        if (trainNo == -1) {
            System.out.println(" Invalid train number.");
            return;
        }
        Train train = findTrain(trainNo);
        if (train == null) {
            System.out.println(" Train No." + trainNo + " not found.");
            System.out.println(" (Binary Search used " + lastSearchSteps + " steps)");
            return;
        }
        System.out.println(" -> Train " + train.trainNo + " " + train.type + " (" + train.getRouteName()
                + ")  [Binary Search used " + lastSearchSteps + " steps]");

        System.out.print(" Enter Carriage No. (1-" + train.carriages.length + ") : ");
        int carriageNo = readInt(input);
        Carriage carriage = train.getCarriage(carriageNo);
        if (carriage == null) {
            System.out.println(" Carriage No. not found.");
            return;
        }

        System.out.println();
        carriage.printSeatMap();

        if (carriage.isFull()) {
            joinWaitingList(input, train, carriage);
            return;
        }

        int[] pos;
        while (true) {
            System.out.print(" Enter Seat No. (e.g. 02B, blank = cancel) : ");
            String seatInput = input.nextLine().trim();
            if (seatInput.isEmpty()) {
                System.out.println(" Booking cancelled.");
                return;
            }
            pos = carriage.parseSeat(seatInput);
            if (pos == null) {
                System.out.println(" Invalid seat. Please try again.");
            } else if (!carriage.isAvailable(pos[0], pos[1])) {
                System.out.println(" Seat " + Carriage.seatLabel(pos[0], pos[1])
                        + " is already booked. Please choose another seat.");
            } else {
                break;
            }
        }

        System.out.print(" Passenger Name : ");
        String name = input.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println(" Passenger name is required. Booking cancelled.");
            return;
        }

        Booking booking = createBooking(name, train, carriage, pos[0], pos[1]);
        System.out.println(" Booking Success!! booking-code: " + booking.getBookingCode());
    }

    public Booking createBooking(String name, Train train, Carriage carriage, int row, int col) {
        int code = codeGenerator.nextCode();
        Booking booking = new Booking(code, name, train, carriage.carriageNo, Carriage.seatLabel(row, col));
        carriage.book(row, col, booking.getBookingCode());
        bookings.insert(booking);
        return booking;
    }

    private void joinWaitingList(Scanner input, Train train, Carriage carriage) {
        System.out.println(" Carriage " + carriage.carriageNo + " is FULL.");
        System.out.println(" Current waiting list: " + carriage.waitingList.traversal());
        System.out.print(" Join the waiting list? (y/n) : ");
        String answer = input.nextLine().trim();
        if (!answer.equalsIgnoreCase("y")) {
            System.out.println(" OK, please choose another carriage or train.");
            return;
        }
        System.out.print(" Passenger Name : ");
        String name = input.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println(" Passenger name is required.");
            return;
        }
        carriage.waitingList.enqueue(name);
        System.out.println(" " + name + " added to waiting list of Train " + train.trainNo
                + " Carriage " + carriage.carriageNo + " (queue no. " + carriage.waitingList.size() + ")");
        System.out.println(" You will get a seat automatically when someone cancels.");
    }

    public Train findTrain(int trainNo) {
        int low = 0;
        int high = trainsByNo.length - 1;
        lastSearchSteps = 0;
        while (low <= high) {
            lastSearchSteps++;
            int mid = (low + high) / 2;
            if (trainsByNo[mid].trainNo == trainNo) {
                return trainsByNo[mid];
            } else if (trainNo < trainsByNo[mid].trainNo) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return null;
    }

    private void quickSort(int low, int high) {
        if (low < high) {
            int p = partition(low, high);
            quickSort(low, p);
            quickSort(p + 1, high);
        }
    }

    private int partition(int low, int high) {
        int pivot = trainsByNo[(low + high) / 2].trainNo;
        int i = low - 1;
        int j = high + 1;
        while (true) {
            do { i++; } while (trainsByNo[i].trainNo < pivot);
            do { j--; } while (trainsByNo[j].trainNo > pivot);
            if (i >= j) return j;
            Train temp = trainsByNo[i];
            trainsByNo[i] = trainsByNo[j];
            trainsByNo[j] = temp;
        }
    }

    private int readInt(Scanner input) {
        String line = input.nextLine().trim();
        try {
            return Integer.parseInt(line);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
