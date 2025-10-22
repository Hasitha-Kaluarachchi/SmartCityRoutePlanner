package smartcityrouteplanner;

import java.util.*;

public class Graph {

    // Store locations and their connected roads
    private Map<String, List<String>> graph;

    // Constructor
    public Graph() {
        graph = new HashMap<>();
    }

    // Add a location (only adds if not already present)
    public void addLocation(String location) {
        if (!graph.containsKey(location)) {
            graph.put(location, new ArrayList<>());
            System.out.println(location + " added to the city network.");
        } else {
            System.out.println("Location already exists!");
        }
    }

    // Remove a location and all roads connected to it
    public void removeLocation(String location) {
        if (graph.containsKey(location)) {
            graph.remove(location);
            for (String key : graph.keySet()) {
                graph.get(key).remove(location);
            }
            System.out.println(location + " removed from the city network.");
        } else {
            System.out.println("Location not found!");
        }
    }

    // Add a two-way road between locations
    public void addRoad(String src, String dest) {
        if (graph.containsKey(src) && graph.containsKey(dest)) {
            graph.get(src).add(dest);
            graph.get(dest).add(src);
            System.out.println("Road added between " + src + " and " + dest);
        } else {
            System.out.println("Both locations must exist first!");
        }
    }

    // Remove a road between two locations
    public void removeRoad(String src, String dest) {
        if (graph.containsKey(src) && graph.get(src).contains(dest)) {
            graph.get(src).remove(dest);
            graph.get(dest).remove(src);
            System.out.println("Road removed between " + src + " and " + dest);
        } else {
            System.out.println("Road not found!");
        }
    }

    // Display all roads and connections
    public void displayConnections() {
        System.out.println("\n--- All City Connections ---");
        for (String location : graph.keySet()) {
            System.out.println(location + " --> " + graph.get(location));
        }
    }

    // BFS traversal using Queue (Queue example)
    public void bfsTraversal(String start) {
        if (!graph.containsKey(start)) {
            System.out.println("Starting location not found!");
            return;
        }

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);

        System.out.println("\nBFS Traversal from " + start + ":");
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

