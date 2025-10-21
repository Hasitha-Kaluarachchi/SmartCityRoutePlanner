package smartcityrouteplanner;

import java.util.*;  // Import useful classes like HashMap, ArrayList, Queue, etc.

/*
 * ----------------------------------------------------------
 * GRAPH CLASS
 * ----------------------------------------------------------
 * - Represents all locations and roads (connections).
 * - Uses an Adjacency List (HashMap).
 * - Includes BFS traversal using Queue.
 * ----------------------------------------------------------
 */
public class Graph {

    // Key = location name, Value = list of connected locations
    private Map<String, List<String>> graph;

    // Constructor: create an empty graph
    public Graph() {
        graph = new HashMap<>();
    }

    // Add a new location (node) to the graph
    public void addLocation(String location) {
        if (!graph.containsKey(location)) {
            graph.put(location, new ArrayList<>());  // empty list for roads
            System.out.println(location + " added successfully.");
        } else {
            System.out.println("Location already exists!");
        }
    }

    // Remove a location and all its connections
    public void removeLocation(String location) {
        if (graph.containsKey(location)) {
            graph.remove(location);  // remove location key
            // also remove it from all other connected lists
            for (String key : graph.keySet()) {
                graph.get(key).remove(location);
            }
            System.out.println(location + " removed successfully.");
        } else {
            System.out.println("Location not found!");
        }
    }

    // Add a road (edge) between two locations
    public void addRoad(String src, String dest) {
        if (graph.containsKey(src) && graph.containsKey(dest)) {
            graph.get(src).add(dest);
            graph.get(dest).add(src);  // because it's a two-way road
            System.out.println("Road added between " + src + " and " + dest);
        } else {
            System.out.println("Both locations must exist first!");
        }
    }

    // Remove a road (edge) between two locations
    public void removeRoad(String src, String dest) {
        if (graph.containsKey(src) && graph.get(src).contains(dest)) {
            graph.get(src).remove(dest);
            graph.get(dest).remove(src);
            System.out.println("Road removed between " + src + " and " + dest);
        } else {
            System.out.println("Road not found!");
        }
    }

    // Show all locations and their connections
    public void displayConnections() {
        System.out.println("\n--- All City Connections ---");
        for (String location : graph.keySet()) {
            System.out.println(location + " --> " + graph.get(location));
        }
    }

    // BFS traversal (uses Queue)
    public void bfsTraversal(String start) {
        if (!graph.containsKey(start)) {
            System.out.println("Starting location not found!");
            return;
        }

        Set<String> visited = new HashSet<>();  // track visited nodes
        Queue<String> queue = new LinkedList<>();  // queue for BFS

        queue.add(start);
        visited.add(start);

        System.out.println("\nBFS Traversal starting from " + start + ":");
        while (!queue.isEmpty()) {
            String current = queue.poll();
            System.out.print(current + " ");

            for (String neighbor : graph.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }
}
