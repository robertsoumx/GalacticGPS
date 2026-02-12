public class Edge<T> {
    public final T destination;
    public final double weight;

    public Edge(T destination, double weight) {
        this.destination = destination;
        this.weight = weight;
    }
}