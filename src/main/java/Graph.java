import java.util.*;

public class Graph<T> {

    // TODO: Define your Adjacency List here.
    // Hint: Use a Map<T, List<Edge<T>>> 
    // private final Map<...> adjacencyList = ...;

    public void addVertex(T node) {
        // TODO: Add the node to your map if it doesn't exist.
    }

    public void addEdge(T source, T destination, double weight) {
        // TODO: Ensure both vertices exist.
        // TODO: Create an Edge object and add it to the source's list.
        // TODO: Since space is 2-way, add the reverse edge too!
    }

    public List<Edge<T>> getNeighbors(T node) {
        // TODO: Return the list of edges for this node.
        // Safety: Return an empty list if the node isn't found.
        return new ArrayList<>();
    }

    public Set<T> getVertices() {
        // TODO: Return all the keys (nodes) from your map.
        return new HashSet<>();
    }

    public void resetNodes() {
        for (T node : getVertices()) {
            if (node instanceof Planet) {
                ((Planet) node).reset();
            }
        }
    }
}