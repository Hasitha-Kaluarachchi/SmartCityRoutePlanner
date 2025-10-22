package smartcityrouteplanner;


public class AVLTree {

    // Node class
    static class Node {
        String key;
        Node left, right;
        int height;

        Node(String item) {
            key = item;
            height = 1;
        }
    }

    private Node root;

    // Get height
    private int height(Node n) {
        return (n == null) ? 0 : n.height;
    }

    // Get balance factor
    private int getBalance(Node n) {
        return (n == null) ? 0 : height(n.left) - height(n.right);
    }

    // Rotate right
    private Node rotateRight(Node y) {
        Node x = y.left;
        Node T2 = x.right;
        x.right = y;
        y.left = T2;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }

    // Rotate left
    private Node rotateLeft(Node x) {
        Node y = x.right;
        Node T2 = y.left;
        y.left = x;
        x.right = T2;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        return y;
    }

    // Insert new location into AVL Tree
    public void insert(String key) {
        root = insertRec(root, key);
    }

    private Node insertRec(Node node, String key) {
        if (node == null) return new Node(key);

        if (key.compareTo(node.key) < 0)
            node.left = insertRec(node.left, key);
        else if (key.compareTo(node.key) > 0)
            node.right = insertRec(node.right, key);
        else
            return node; // no duplicates

        node.height = 1 + Math.max(height(node.left), height(node.right));
        int balance = getBalance(node);

        // Balancing cases
        if (balance > 1 && key.compareTo(node.left.key) < 0)
            return rotateRight(node);

        if (balance < -1 && key.compareTo(node.right.key) > 0)
            return rotateLeft(node);

        if (balance > 1 && key.compareTo(node.left.key) > 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        if (balance < -1 && key.compareTo(node.right.key) < 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    // Display locations in alphabetical order
    public void display() {
        System.out.println("\n--- Locations (AVL Tree) ---");
        inorder(root);
    }

    private void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.println("- " + node.key);
            inorder(node.right);
        }
    }
}