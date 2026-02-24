public class Node {
    public Planet planet;
    public Node left, right;
    public Node(Planet planet){
        this.planet = planet;
        this.left = null;
        this.right = null;
    }
}
