import java.util.*;

public class UniverseGenerator {

    public static Graph<Planet> generate(int width, int height) {
        Graph<Planet> universe = new Graph<>();

        // --- MILESTONE 1: DUMMY DATA ---
        // These planets verify that your Graph and UI work.
        // Once Earth and Mars appear on screen, YOU CAN DELETE THIS SECTION.

        Planet p1 = new Planet("Earth", 100, 300);
        Planet p2 = new Planet("Mars", 800, 300);

        System.out.println("Adding Earth and Mars to the Graph...");
        universe.addVertex(p1);
        universe.addVertex(p2);
        universe.addEdge(p1, p2, 700);

        // --- MILESTONE 2: PROCEDURAL GENERATION ---
        // TODO: Loop 20 times to create random planets.
        // TODO: Check for collisions (min distance > 80).
        // TODO: Connect each planet to its 3 closest neighbors.

        return universe;
    }
}