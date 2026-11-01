import java.util.ArrayList;
import java.util.Scanner;

public class TrainSearch {

    private static class SearchResult {
        Train train;
        String departure;
        String arrival;

        SearchResult(Train train, String departure, String arrival) {
            this.train = train;
            this.departure = departure;
            this.arrival = arrival;
        }
    }

    private ArrayList<Train> trainList;

    public TrainSearch(ArrayList<Train> trainList) {
        this.trainList = trainList;
    }

    public void run(Scanner input) {
        System.out.print(" Origin Station      : ");
        String origin = input.nextLine().trim();
        System.out.print(" Destination Station : ");
        String destination = input.nextLine().trim();

        if (origin.isEmpty() || destination.isEmpty()) {
            System.out.println(" Please enter both origin and destination.");
            return;
        }
        if (origin.equalsIgnoreCase(destination)) {
            System.out.println(" Origin and destination must be different.");
            return;
        }

        ArrayList<SearchResult> results = searchTrains(origin, destination);

        if (results.isEmpty()) {
            System.out.println("\n No train found from " + origin + " to " + destination);
        } else {
            insertionSortByDeparture(results);
            System.out.println();
            System.out.printf(" %-7s %-17s %-11s %-9s %s%n", "Train", "Type", "Departure", "Arrival", "Route");
            for (SearchResult r : results) {
                System.out.printf(" %-7d %-17s %-11s %-9s %s%n", r.train.trainNo, r.train.type,
                        r.departure, r.arrival, r.train.getRouteName());
            }
        }
        System.out.println("\n (Linear Search checked " + trainList.size() + " trains, found "
                + results.size() + ")");
    }

    private ArrayList<SearchResult> searchTrains(String origin, String destination) {
        ArrayList<SearchResult> results = new ArrayList<SearchResult>();

        for (int i = 0; i < trainList.size(); i++) {
            Train train = trainList.get(i);
            int originIndex = train.route.indexOf(origin);
            if (originIndex == -1) continue;
            int destIndex = train.route.indexOf(destination);
            if (destIndex > originIndex) {
                String departure = train.route.getNode(originIndex).time;
                String arrival = train.route.getNode(destIndex).time;
                results.add(new SearchResult(train, departure, arrival));
            }
        }
        return results;
    }

    private void insertionSortByDeparture(ArrayList<SearchResult> results) {
        for (int i = 1; i < results.size(); i++) {
            SearchResult key = results.get(i);
            int keyTime = toMinutes(key.departure);
            int j = i - 1;
            while (j >= 0 && toMinutes(results.get(j).departure) > keyTime) {
                results.set(j + 1, results.get(j));
                j--;
            }
            results.set(j + 1, key);
        }
    }

    private int toMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
}
