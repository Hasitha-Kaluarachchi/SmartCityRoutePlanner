package smartcityrouteplanner;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Graph graph = new Graph();     
        AVLTree tree = new AVLTree();  
        Operations ops = new Operations(); 

        while (true) {
            System.out.println("\n=== SMART CITY ROUTE PLANNER ===");
            System.out.println("1. Add a new location");
            System.out.println("2. Remove a location");
            System.out.println("3. Add a road between locations");
            System.out.println("4. Remove a road");
            System.out.println("5. Display all connections");
            System.out.println("6. Display all locations");
            System.out.println("7. BFS Traversal");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                case "2":
                case "3":
                case "4":
                    ops.manage(graph, tree, sc, choice);
                    break;

                case "5":
                    graph.displayConnections();
                    break;

                case "6":
                    tree.display();
                    break;

                case "7":
                    System.out.print("Enter starting location: ");
                    String start = sc.nextLine();
                    graph.bfsTraversal(start);
                    break;

                case "8":
                    System.out.println("Exiting program... Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid input! Please enter 1–8.");
            }
        }
    }
}