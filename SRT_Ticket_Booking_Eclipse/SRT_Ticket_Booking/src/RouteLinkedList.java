public class RouteLinkedList {
    private RouteNode head;
    private int size;

    public RouteLinkedList() {
        head = null;
        size = 0;
    }

    public void append(String station, String time) {
        RouteNode newNode = new RouteNode(station, time);
        if (head == null) {
            head = newNode;
        } else {
            RouteNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public int indexOf(String station) {
        RouteNode current = head;
        int index = 0;
        while (current != null) {
            if (current.station.equalsIgnoreCase(station)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    public RouteNode getNode(int position) {
        if (position < 0 || position >= size) return null;
        RouteNode current = head;
        for (int i = 0; i < position; i++) {
            current = current.next;
        }
        return current;
    }

    public String getFirstStation() {
        return head == null ? "-" : head.station;
    }

    public String getLastStation() {
        RouteNode current = head;
        if (current == null) return "-";
        while (current.next != null) {
            current = current.next;
        }
        return current.station;
    }

    public int length() {
        return size;
    }

    public String traversal() {
        StringBuilder sb = new StringBuilder();
        RouteNode current = head;
        while (current != null) {
            sb.append(current.station);
            if (current.next != null) sb.append(" -> ");
            current = current.next;
        }
        return sb.toString();
    }
}
