public class Node {
    
    private Node daughter;
    private Node parent;
    private int id;
    
    public Node() {
        daughter = null;
        parent = null;
        id = -1;
    }
    
    public Node(Node n , int i) {
        daughter = n;
        id = i;
        parent = null;
    }
    
    public void setDaughter(Node n) {
        daughter = n;
    }
    
    public void setParent(Node n) {
        parent = n;
    }
    
    public void setID(int i) {
        id = i;
    }
    
    public Node getDaughter() {
        return daughter;
    }
    
    public Node getParent() {
        return parent;
    }
    
    public int getID() {
        return id;
    }
    
}
