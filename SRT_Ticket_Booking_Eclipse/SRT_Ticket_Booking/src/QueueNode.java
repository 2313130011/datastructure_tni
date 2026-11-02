public class QueueNode {
    public String passengerName;
    public QueueNode next;

    public QueueNode(String passengerName) {
        this.passengerName = passengerName;
        this.next = null;
    }
}
