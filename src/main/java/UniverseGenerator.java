import java.util.*;

public class UniverseGenerator {

    public static Graph<Planet> generate(int width, int height) {
        Graph<Planet> universe = new Graph<>();

        // --- MILESTONE 1: DUMMY DATA ---
        // These planets verify that your Graph and UI work.
        // Once Earth and Mars appear on screen, YOU CAN DELETE THIS SECTION.

        /*Planet p1 = new Planet("Earth", 100, 300);
        Planet p2 = new Planet("Mars", 800, 300);

        System.out.println("Adding Earth and Mars to the Graph...");
        universe.addVertex(p1);
        universe.addVertex(p2);
        universe.addEdge(p1, p2, 700);*/

        // --- MILESTONE 2: PROCEDURAL GENERATION ---
        ArrayList<Planet> planets = new ArrayList<>();

        // TODO: Loop 20 times to create random planets.
        for(int i = 0; i < 20; i++){
            Planet newPlanet = null;
            int attempt = 0;
            boolean validPosition = false;

            while(!validPosition && attempt < 100){
                String name = "Planet" + (i+1);
                double x = (Math.random()*(width - 100));
                double y = (Math.random()*(height - 100));
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
            Tree.insert(planet);
        }

        for(Planet currentPlanet: planets){
            List<PlanetDistance> nearestPlanets = Tree.nearestNeighborsBFS(currentPlanet, 3);
            for(int i = 0; i < 3; i++){
                PlanetDistance otherPlanet = nearestPlanets.get(i);
                universe.addEdge(currentPlanet, otherPlanet.planet, otherPlanet.getDistance());
            }
        }


        return universe;
    }
}
