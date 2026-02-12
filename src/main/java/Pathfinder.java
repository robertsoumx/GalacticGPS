import java.util.*;

public class Pathfinder {

    public static List<Planet> findShortestPath(Graph<Planet> graph, Planet start, Planet end) {
        // 1. Reset State
        graph.resetNodes();

        // 2. Setup Queue
        PriorityQueue<Planet> queue = new PriorityQueue<>();
        start.minDistance = 0;
        queue.add(start);

        // --- PART C: DIJKSTRA'S ALGORITHM ---
        while (!queue.isEmpty()) {
            Planet current = queue.poll();

            // TODO: Stop if we reached the 'end'.
            // TODO: Skip if already 'visited'.

            // TODO: Iterate over graph.getNeighbors(current)
            // TODO: Calculate new distance (current.min + edge.weight)
            // TODO: If shorter, update neighbor.minDistance & neighbor.previous, then add to queue.
        }

        // --- PART D: RECONSTRUCT PATH ---
        List<Planet> path = new ArrayList<>();
        // TODO: Start at 'end' and follow .previous back to start.
        // TODO: Reverse the list before returning.

        return path;
    }
}