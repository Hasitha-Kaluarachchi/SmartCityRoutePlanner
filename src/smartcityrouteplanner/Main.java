package smartcityrouteplanner;

import java.util.*;  // Import Scanner for user input

/*
 * ----------------------------------------------------------
 * MAIN CLASS
 * ----------------------------------------------------------
 * - Displays menu to the user.
 * - Connects Graph and Linked List classes.
 * - Handles user input and validation.
 * ----------------------------------------------------------
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  // for user input
        Graph graph = new Graph();            // create Graph object
        LocationList locations = new LocationList();  // create LinkedList object

        while (true) {
            // Print menu options
            System.out.println("\n=== SMART CITY ROUTE PLANNER ===");
            System.out.println("1. Add a new location");
            System.out.println("2. Remove a location");
            System.out.println("3. Add a road between locations");
            System.out.println("4. Remove a road");
            System.out.println("5. Display all connections");
            System.out.println("6. Display all locations");
            System.out.println("7. BFS Traversal (Queue example)");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            String choice = sc.nextLine();

            switch (choice) {
                case "1":  // Add location
                    System.out.print("Enter location name: ");
                    String loc = sc.nextLine();
                    graph.addLocation(loc);
                    locations.insert(loc);
                    break;

                case "2":  // Remove location
                    System.out.print("Enter location name to remove: ");
                    String locRemove = sc.nextLine();
                    graph.removeLocation(locRemove);
                    break;

                case "3":  // Add road
                    System.out.print("Enter source: ");
                    String src = sc.nextLine();
                    System.out.print("Enter destination: ");
                    String dest = sc.nextLine();
                    graph.addRoad(src, dest);
                    break;

                case "4":  // Remove road
                    System.out.print("Enter source: ");
                    String srcR = sc.nextLine();
                    System.out.print("Enter destination: ");
                    String destR = sc.nextLine();
                    graph.removeRoad(srcR, destR);
                    break;

                case "5":  // Display connections
                    graph.displayConnections();
                    break;

                case "6":  // Display all locations
                    locations.display();
                    break;

                case "7":  // BFS traversal
                    System.out.print("Enter starting location for BFS: ");
                    String start = sc.nextLine();
                    graph.bfsTraversal(start);
                    break;

                case "8":  // Exit program
                    System.out.println("Exiting Smart City Route Planner...");
                    sc.close();
                    return;  // stop program

                default:  // Invalid input
                    System.out.println("Invalid input! Please try again.");
            }
        }
    }
}

