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
        double distance = Double.MAX_VALUE;
        Planet neighbor = null;
        while (!queue.isEmpty()) {
            Planet current = queue.poll();
            // TODO: Stop if we reached the 'end'.
            if (current.getName().equals(end.getName())) {
                break;
            }
            // TODO: Skip if already 'visited'.
            if (current.visited) {
                current = queue.poll();
            }
            // TODO: Iterate over graph.getNeighbors(current)
            // TODO: Calculate new distance (current.min + edge.weight)
            // TODO: If shorter, update neighbor.minDistance & neighbor.previous, then add to queue.
            for (Edge thisEdge : graph.getNeighbors(current)) {
                neighbor = thisEdge.destination;
                distance = Math.hypot(current.getX() - neighbor.getX(), current.getY() - neighbor.getY());
                if (distance < current.minDistance) {
                    neighbor.minDistance = distance;
                    neighbor.previous = current;
                    queue.add(neighbor);
                }
            }

        }

        // --- PART D: RECONSTRUCT PATH ---
        List<Planet> path = new ArrayList<>();
        Planet current = end;
        // TODO: Start at 'end' and follow .previous back to start.
        while (current.previous != null) {
            path.add(current);
            current = current.previous;
        }
        // TODO: Reverse the list before returning.
        List<Planet> returnList = new ArrayList<>();
        for (int i = path.size() - 1; i > -1; i --) {
            returnList.add(path.get(i));
        }
        return returnList;
    }
}