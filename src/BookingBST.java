public class BookingBST {
    private BookingNode root;
    private int size;
    private int lastVisitedNodes;

    public BookingBST() {
        root = null;
        size = 0;
    }

    public void insert(Booking booking) {
        BookingNode newNode = new BookingNode(booking);
        if (root == null) {
            root = newNode;
            size++;
            return;
        }
        BookingNode current = root;
        while (true) {
            if (booking.codeNumber < current.data.codeNumber) {
                if (current.left == null) {
                    current.left = newNode;
                    break;
                }
                current = current.left;
            } else if (booking.codeNumber > current.data.codeNumber) {
                if (current.right == null) {
                    current.right = newNode;
                    break;
                }
                current = current.right;
            } else {
                return;
            }
        }
        size++;
    }

    public Booking search(int codeNumber) {
        BookingNode current = root;
        lastVisitedNodes = 0;
        while (current != null) {
            lastVisitedNodes++;
            if (codeNumber == current.data.codeNumber) {
                return current.data;
            } else if (codeNumber < current.data.codeNumber) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null;
    }

    public boolean contains(int codeNumber) {
        return search(codeNumber) != null;
    }

    public boolean delete(int codeNumber) {
        BookingNode parent = null;
        BookingNode current = root;
        while (current != null && current.data.codeNumber != codeNumber) {
            parent = current;
            if (codeNumber < current.data.codeNumber) current = current.left;
            else current = current.right;
        }
        if (current == null) return false;

        if (current.left != null && current.right != null) {
            BookingNode minParent = current;
            BookingNode min = current.right;
            while (min.left != null) {
                minParent = min;
                min = min.left;
            }
            current.data = min.data;
            parent = minParent;
            current = min;
        }

        BookingNode child = (current.left != null) ? current.left : current.right;
        if (parent == null) {
            root = child;
        } else if (parent.left == current) {
            parent.left = child;
        } else {
            parent.right = child;
        }
        size--;
        return true;
    }

    public int size() {
        return size;
    }

    public int getLastVisitedNodes() {
        return lastVisitedNodes;
    }

    public int height() {
        return height(root);
    }

    private int height(BookingNode node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }
}
