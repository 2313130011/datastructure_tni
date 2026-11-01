import java.util.ArrayList;
import java.util.Random;

public class TrainData {
    public static final int CARRIAGES_PER_TRAIN = 3;
    public static final int ROWS = 8;
    public static final int COLS = 4;

    private static final String[] PASSENGER_NAMES = {
        "Somchai", "Somsri", "Malee", "Anan", "Kittipong", "Nattaya", "Wichai",
        "Pimchanok", "Thanawat", "Siriporn", "Arthit", "Kanokwan", "John", "Emma", "Leon"
    };

    public static ArrayList<Train> loadTrains() {
        ArrayList<Train> list = new ArrayList<Train>();

        list.add(createTrain(7, "Special Express", new String[][] {
            {"Bangkok", "08:30"}, {"Ayutthaya", "09:35"}, {"Lop Buri", "10:25"},
            {"Nakhon Sawan", "11:45"}, {"Phitsanulok", "13:25"}, {"Uttaradit", "14:40"},
            {"Lampang", "17:30"}, {"Lamphun", "18:55"}, {"Chiang Mai", "19:30"}}));
        list.add(createTrain(9, "Special Express", new String[][] {
            {"Bangkok", "18:40"}, {"Ayutthaya", "19:45"}, {"Lop Buri", "20:35"},
            {"Nakhon Sawan", "22:00"}, {"Phitsanulok", "23:45"}, {"Uttaradit", "01:05"},
            {"Lampang", "04:40"}, {"Lamphun", "06:35"}, {"Chiang Mai", "07:15"}}));
        list.add(createTrain(13, "Express", new String[][] {
            {"Bangkok", "20:05"}, {"Ayutthaya", "21:15"}, {"Lop Buri", "22:10"},
            {"Nakhon Sawan", "23:40"}, {"Phitsanulok", "01:35"}, {"Uttaradit", "03:00"},
            {"Lampang", "06:20"}, {"Lamphun", "08:00"}, {"Chiang Mai", "08:40"}}));
        list.add(createTrain(109, "Rapid", new String[][] {
            {"Bangkok", "14:15"}, {"Ayutthaya", "15:35"}, {"Lop Buri", "16:40"},
            {"Nakhon Sawan", "18:25"}, {"Phitsanulok", "20:30"}, {"Uttaradit", "22:10"},
            {"Lampang", "01:45"}, {"Lamphun", "03:25"}, {"Chiang Mai", "04:05"}}));
        list.add(createTrain(8, "Special Express", new String[][] {
            {"Chiang Mai", "08:50"}, {"Lamphun", "09:10"}, {"Lampang", "10:30"},
            {"Uttaradit", "13:20"}, {"Phitsanulok", "14:35"}, {"Nakhon Sawan", "16:15"},
            {"Lop Buri", "17:40"}, {"Ayutthaya", "18:40"}, {"Bangkok", "20:05"}}));
        list.add(createTrain(14, "Express", new String[][] {
            {"Chiang Mai", "17:00"}, {"Lamphun", "17:20"}, {"Lampang", "18:50"},
            {"Uttaradit", "22:15"}, {"Phitsanulok", "23:50"}, {"Nakhon Sawan", "01:50"},
            {"Lop Buri", "03:30"}, {"Ayutthaya", "04:40"}, {"Bangkok", "06:15"}}));

        list.add(createTrain(21, "Special Express", new String[][] {
            {"Bangkok", "05:50"}, {"Ayutthaya", "06:50"}, {"Saraburi", "07:25"},
            {"Nakhon Ratchasima", "09:15"}, {"Buri Ram", "11:00"}, {"Surin", "11:40"},
            {"Si Sa Ket", "13:00"}, {"Ubon Ratchathani", "14:15"}}));
        list.add(createTrain(23, "Express", new String[][] {
            {"Bangkok", "21:00"}, {"Ayutthaya", "22:10"}, {"Saraburi", "22:50"},
            {"Nakhon Ratchasima", "01:05"}, {"Buri Ram", "03:00"}, {"Surin", "03:50"},
            {"Si Sa Ket", "05:30"}, {"Ubon Ratchathani", "07:55"}}));
        list.add(createTrain(25, "Special Express", new String[][] {
            {"Bangkok", "20:25"}, {"Ayutthaya", "21:30"}, {"Saraburi", "22:10"},
            {"Kaeng Khoi", "22:30"}, {"Bua Yai", "01:15"}, {"Khon Kaen", "02:45"},
            {"Udon Thani", "04:50"}, {"Nong Khai", "06:25"}}));

        list.add(createTrain(31, "Special Express", new String[][] {
            {"Bangkok", "15:10"}, {"Nakhon Pathom", "16:10"}, {"Ratchaburi", "17:00"},
            {"Hua Hin", "18:30"}, {"Prachuap Khiri Khan", "19:40"}, {"Chumphon", "22:30"},
            {"Surat Thani", "01:10"}, {"Thung Song", "03:20"}, {"Hat Yai", "06:30"}}));
        list.add(createTrain(37, "Express", new String[][] {
            {"Bangkok", "13:00"}, {"Nakhon Pathom", "14:05"}, {"Ratchaburi", "15:00"},
            {"Hua Hin", "16:35"}, {"Prachuap Khiri Khan", "17:55"}, {"Chumphon", "21:05"},
            {"Surat Thani", "23:55"}, {"Thung Song", "02:15"}, {"Hat Yai", "05:40"},
            {"Su-ngai Kolok", "09:45"}}));

        return list;
    }

    private static Train createTrain(int trainNo, String type, String[][] stops) {
        Train train = new Train(trainNo, type, CARRIAGES_PER_TRAIN, ROWS, COLS);
        for (String[] stop : stops) {
            train.route.append(stop[0], stop[1]);
        }
        return train;
    }

    public static void loadExistingBookings(ArrayList<Train> trains, BookingBST bookings,
                                            BookingCodeGenerator generator, Random random) {
        for (Train train : trains) {
            for (Carriage carriage : train.carriages) {
                boolean fillAll = (train.trainNo == 9 && carriage.carriageNo == 2);
                for (int r = 0; r < carriage.getRows(); r++) {
                    for (int c = 0; c < carriage.getCols(); c++) {
                        if (fillAll || random.nextInt(100) < 35) {
                            int code = generator.nextCode();
                            String name = PASSENGER_NAMES[random.nextInt(PASSENGER_NAMES.length)];
                            String seat = Carriage.seatLabel(r, c);
                            Booking booking = new Booking(code, name, train, carriage.carriageNo, seat);
                            carriage.book(r, c, booking.getBookingCode());
                            bookings.insert(booking);
                        }
                    }
                }
            }
        }
    }
}
