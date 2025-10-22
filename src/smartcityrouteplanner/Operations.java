package smartcityrouteplanner;

import java.util.Scanner;


public class Operations {

    public void manage(Graph graph, AVLTree tree, Scanner sc, String choice) {
        switch (choice) {
            case "1":  // Add location
                System.out.print("Enter location name: ");
                String loc = sc.nextLine();
                graph.addLocation(loc);
                tree.insert(loc); // also store in AVL Tree
                break;

            case "2":  // Remove location
                System.out.print("Enter location name to remove: ");
                String locRemove = sc.nextLine();
                graph.removeLocation(locRemove);
                break;

            case "3":  // Add road
                System.out.print("Enter source location: ");
                String src = sc.nextLine();
                System.out.print("Enter destination location: ");
                String dest = sc.nextLine();
                graph.addRoad(src, dest);
                break;

            case "4":  // Remove road
                System.out.print("Enter source location: ");
                String srcR = sc.nextLine();
                System.out.print("Enter destination location: ");
                String destR = sc.nextLine();
                graph.removeRoad(srcR, destR);
                break;
        }
    }
}