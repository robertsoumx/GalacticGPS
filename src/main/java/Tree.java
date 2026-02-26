import java.util.*;
public class Tree {
    private Node root;

    public void insert(Planet planet){
        root = insert(root, planet, 0);
    }

    private Node insert(Node node, Planet planet, int depth){
        if (node == null){ //base case for recursive method
            return new Node(planet);
        }

        int axis = depth%2;

        if(axis == 0){
            if(planet.getX() < node.planet.getX()){ //compares X when depth is 0
                node.left = insert(node.left, planet, depth + 1);
            }
            else{
                node.right = insert(node.right, planet, depth + 1);
            }
        }else{ //compares Y when depth is 1
            if(planet.getY() < node.planet.getY()){
                node.left = insert(node.left, planet, depth + 1);
            }
            else{
                node.right = insert(node.right, planet, depth + 1);
            }
        }
        return node;
    }

    public List<PlanetDistance> nearestNeighborsBFS(Planet target, int n){
        List<PlanetDistance> allDistances = new ArrayList<>();

        if(root == null){
            return allDistances;
        }

        Queue<Node> queue = new LinkedList<>();

        queue.offer(root);

        //get all distances and add them to the list
        while(!queue.isEmpty()){
            Node node = queue.poll();

            double distance = Math.hypot(
                    target.getX() - node.planet.getX(), target.getY() - node.planet.getY()
            );

            allDistances.add(new PlanetDistance(node.planet, distance));

            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right!= null){
                queue.offer(node.right);
            }
        }

        //AI use: how to sort from queue from least to greatest
        allDistances.sort(Comparator.comparingDouble(PlanetDistance::getDistance));

        //since the list is sorted, return a sub list from index 0 to the entered amount.
        int lim = Math.min(n, allDistances.size()); //we do this in case allDistances.size() < n.
        return allDistances.subList(0, lim);
    }
}
