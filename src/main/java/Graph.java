import java.util.*;

public class Graph<T> {

    // TODO: Define your Adjacency List here.
    private final Map<T, List<Edge<T>>> adjacencyList = new HashMap<>();
    // Hint: Use a Map<T, List<Edge<T>>> 
    // private final Map<...> adjacencyList = ...;

    public void addVertex(T node) {
        // TODO: Add the node to your map if it doesn't exist.
        if(!adjacencyList.containsKey(node)){
            adjacencyList.put(node, new ArrayList<>());
        }
    }

    public void addEdge(T source, Planet destination, double weight) {
        // TODO: Ensure both vertices exist.
        boolean verticesExist = adjacencyList.containsKey(source) && adjacencyList.containsKey(destination);
        if(!verticesExist){
            throw new IllegalArgumentException("Both vertices must exist.");
        }

        // TODO: Create an Edge object and add it to the source's list.
        Edge<T> oneWayEdge = new Edge<>(destination, weight);
        adjacencyList.get(source).add(oneWayEdge);

        // TODO: Since space is 2-way, add the reverse edge too!
        Edge<T> reverseEdge = new Edge<>(source, weight);
        adjacencyList.get(destination).add(reverseEdge);
    }

    public List<Edge<T>> getNeighbors(T node) {
        // TODO: Return the list of edges for this node.
        if(adjacencyList.containsKey(node)){
            return adjacencyList.get(node);
        }
        return new ArrayList<>(); // Safety: Return an empty list if the node isn't found.
    }

    public Set<T> getVertices() {
        // TODO: Return all the keys (nodes) from your map.
        return new HashSet<>(adjacencyList.keySet());
    }

    public void resetNodes() {
        for (T node : getVertices()) {
            if (node instanceof Planet) {
                ((Planet) node).reset();
            }
        }
    }
}