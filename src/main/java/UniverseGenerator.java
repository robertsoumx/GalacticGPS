import java.util.*;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class UniverseGenerator {

    public static Graph<Planet> generate(int width, int height) {
        Graph<Planet> universe = new Graph<>();

        // --- MILESTONE 1: DUMMY DATA ---
        // These planets verify that your Graph and UI work.
        // Once Earth and Mars appear on screen, YOU CAN DELETE THIS SECTION.

        //Planet p1 = new Planet("Earth", 100, 300);
        //Planet p2 = new Planet("Mars", 800, 300);

        //System.out.println("Adding Earth and Mars to the Graph...");
        //universe.addVertex(p1);
        //universe.addVertex(p2);
        //universe.addEdge(p1, p2, 700);

        // --- MILESTONE 2: PROCEDURAL GENERATION ---
        ArrayList<Planet> planets = new ArrayList<>();

        // TODO: Loop 20 times to create random planets.
        for(int i = 0; i < 20; i++){
            Planet newPlanet = null;
            int attempt = 0;
            boolean validPosition = false;

            while(!validPosition && attempt < 100){
                String name = "Planet " + (i+1);
                double x = 50 + (Math.random() * (width - 100));
                double y = 50 + (Math.random() * (height - 100));
                validPosition = true;

                newPlanet = new Planet(name, x, y);
                // TODO: Check for collisions (min distance > 80).
                for(Planet planet: planets){
                    double distance = Math.hypot(
                            newPlanet.getX() - planet.getX(), newPlanet.getY() - planet.getY()
                    );
                    //distance from planets = newPlanet - planet
                    if(distance < 80){
                        validPosition = false;
                        break;
                    }
                }
                attempt++;
            }
            if(validPosition){
                planets.add(newPlanet);
                universe.addVertex(newPlanet);
            }
        }

        // TODO: Connect each planet to its 3 closest neighbors.

        Tree tree = new Tree();

        for(Planet planet: planets){
            tree.insert(planet);
        }

        for(Planet currentPlanet: planets){
            List<PlanetDistance> nearestPlanets = tree.nearestNeighborsBFS(currentPlanet, 4);
            //we use parameter 4 because BFS includes itself (1 is the planet itself and the other 3
            //are the 3 closest neighboring planets
            for(int i = 1; i < 4; i++){
                PlanetDistance otherPlanet = nearestPlanets.get(i);
                universe.addEdge(currentPlanet, otherPlanet.planet, otherPlanet.getDistance());
            }
        }

        if(!connectedPlanets(universe,planets)){
            return generate(width, height);
        }
        return universe;
    }

    /// helper method to compare if every planet is connected to each other using a queue
    /// and BFS
    public static boolean connectedPlanets(Graph<Planet> universe, List<Planet> planets){
        Set<Planet> visited = new HashSet<>();
        Queue<Planet> queue = new LinkedList<>();

        Planet start = planets.get(0);
        visited.add(start);
        queue.offer(start);

        while(!queue.isEmpty()){
            Planet current = queue.poll();
            for(Edge<Planet> edge : universe.getNeighbors(current)){
                Planet next = edge.destination;
                if(visited.add(next)){
                    queue.offer(next);
                }
            }
        }
        return visited.size() == planets.size();
    }
}
