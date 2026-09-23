package labshee10;

public class BinarySearchTree {

    private Node root;
    private Node parent;
    private Node deleteNode;

    public boolean isEmpty() {
        return root == null;
    }

    public void sampleTree1() {
        int[] nums = {20, 10, 60, 7, 11, 30, 65, 3, 40};

        for (int num : nums) {
            insert(num);
        }
    }

    public void printTree(Node node, int depth) {
        if (node != null) {
            printTree(node.right, depth + 1);
            for (int i = 0; i < depth; i++) {
                System.out.print("    ");
            }
            System.out.println(node.data);
            printTree(node.left, depth + 1);
        }
    }

    public Node getRoot() {
        return root;
    }

    public Node getParent() {
        return parent;
    }

    public Node getDeleteNode() {
        return deleteNode;
    }

    public void insert(int new_data) {
        if (root == null) {
            root = new Node(new_data);
        } else {
            Node current_node = root;
            while (true) {
                if (new_data < current_node.data) {
                    if (current_node.left == null) {
                        current_node.left = new Node(new_data);
                        break;
                    }
                    current_node = current_node.left;
                } else if (new_data > current_node.data) {
                    if (current_node.right == null) {
                        current_node.right = new Node(new_data);
                        break;
                    }
                    current_node = current_node.right;
                }
            }
        }
    }

    public Node findMinimum() {
        return findMinimum(root);
    }

    public Node findMinimum(Node startNode) {
        if (startNode == null) return null;
        Node current = startNode;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    public Node findMaximum() {
        return findMaximum(root);
    }

    public Node findMaximum(Node startNode) {
        if (startNode == null) return null;
        Node current = startNode;
        while (current.right != null) {
            current = current.right;
        }
        return current;
    }

    public boolean findSpecificData(int target) {
        Node current_node = root;
        while (current_node != null) {
            if (target == current_node.data) {
                return true;
            } else if (target < current_node.data) {
                current_node = current_node.left;
            } else {
                current_node = current_node.right;
            }
        }
        return false;
    }

    public void searchDeleteNode(int target) {
        parent = root;
        Node current_node = root;
        while (current_node != null) {
            if (target == current_node.data) {
                deleteNode = current_node;
                break;
            }
            parent = current_node;
            if (target < current_node.data) {
                current_node = current_node.left;
            } else {
                current_node = current_node.right;
            }
        }
    }

    public void delete(int target) {
        searchDeleteNode(target);
        if (deleteNode == null) return;

        if (deleteNode.left == null || deleteNode.right == null) {
            Node child = (deleteNode.left != null) ? deleteNode.left : deleteNode.right;
            if (deleteNode == root) {
                root = child;
            } else if (parent.left == deleteNode) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        }
    }

    public void deleteByLeftSubtree() {
        Node targetNode = deleteNode;
        int maxValue = findMaximum(deleteNode.left).data;
        delete(maxValue);
        targetNode.data = maxValue;
    }

    public void deleteByRightSubtree() {
        Node targetNode = deleteNode;
        int minValue = findMinimum(deleteNode.right).data;
        delete(minValue);
        targetNode.data = minValue;
    }
}