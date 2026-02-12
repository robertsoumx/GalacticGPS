public class Planet implements Comparable<Planet> {
    private final String name;
    private final double x, y;

    // PATHFINDING STATE (Do not modify)
    public double minDistance = Double.MAX_VALUE;
    public Planet previous = null;
    public boolean visited = false;

    public Planet(String name, double x, double y) {
        this.name = name;
        this.x = x;
        this.y = y;
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

    public String getName() { return name; }
    public double getX() { return x; }
    public double getY() { return y; }
}