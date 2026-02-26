import java.util.Objects;

public class Edge<T> {
    public final T destination;
    public final double weight;

    public Edge(T destination, double weight) {
        this.destination = destination;
        this.weight = weight;
    }

    /// AI fix for duplicate connections:
    @Override
    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if(!(o instanceof Edge<?> other)){
            return false;
        }
        return Objects.equals(destination, other.destination);
    }

    @Override
    public int hashCode(){
        return Objects.hash(destination);
    }
}