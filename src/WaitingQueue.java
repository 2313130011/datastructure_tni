public class WaitingQueue {
    private QueueNode front;
    private QueueNode rear;
    private int size;

    public WaitingQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    public void enqueue(String passengerName) {
        QueueNode newNode = new QueueNode(passengerName);
        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public String dequeue() {
        if (isEmpty()) return null;
        String name = front.passengerName;
        front = front.next;
        if (front == null) rear = null;
        size--;
        return name;
    }

    public String peek() {
        return isEmpty() ? null : front.passengerName;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int size() {
        return size;
    }

    public String traversal() {
        StringBuilder sb = new StringBuilder("[");
        QueueNode current = front;
        while (current != null) {
            sb.append(current.passengerName);
            if (current.next != null) sb.append(", ");
            current = current.next;
        }
        return sb.append("]").toString();
    }
}
