package smartcityrouteplanner;

/*
 * ----------------------------------------------------------
 * LOCATION LIST CLASS
 * ----------------------------------------------------------
 * - Demonstrates a Linked List data structure.
 * - Stores all location names that the user adds.
 * ----------------------------------------------------------
 */
public class LocationList {
    private Node head;  // Start (first) node of the linked list

    // Inner Node class to represent one location
    private static class Node {
        String data;  // name of the location
        Node next;    // link to next node

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    // Insert new location at the end of the list
    public void insert(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;  // first location
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;  // move to last node
            }
            current.next = newNode;  // attach new node at end
        }
    }

    // Show all locations in linked list form
    public void display() {
        System.out.println("\n--- Locations (Linked List) ---");
        Node current = head;
        if (current == null) {
            System.out.println("No locations added yet.");
            return;
        }
        while (current != null) {
            System.out.println("- " + current.data);
            current = current.next;
        }
    }
}
