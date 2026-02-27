import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
public class Planet implements Comparable<Planet> {
    private final String name;
    private DoubleProperty x = new SimpleDoubleProperty();
    private DoubleProperty y = new SimpleDoubleProperty();

    // PATHFINDING STATE (Do not modify)
    public double minDistance = Double.MAX_VALUE;
    public Planet previous = null;
    public boolean visited = false;

    public Planet(String name, double x, double y) {
        this.name = name;
        this.x.set(x);
        this.y.set(y);
    }

    public void reset() {
        minDistance = Double.MAX_VALUE;
        previous = null;
        visited = false;
    }

    @Override
    public int compareTo(Planet other) {
        return Double.compare(this.minDistance, other.minDistance);
    }

    public String getName() {
        return name;
    }
    public double getX() {
        return x.get();
    }
    public double getY() {
        return y.get();
    }
    public void setX(double value) {
        x.set(value);
    }
    public void setY(double value) {
        y.set(value);
    }

    public DoubleProperty xProperty() {
        return x;
    }
    public DoubleProperty yProperty() {
        return y;
    }
}