public class Edge<T> {
    public final Planet destination;
    public final double weight;

    public Edge(Planet destination, double weight) {
        this.destination = destination;
        this.weight = weight;
    }
}