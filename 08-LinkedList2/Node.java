public class Node {

    private Node daughter;
    private Node parent;

    public Node() {
        daughter = null;
        parent = null;
        associations = new LinkedList[0];
    }

    public void setDaughter(Node n) {
        daughter = n;
    }

    public void setParent(Node n) {
        parent = n;
    }

    public Node getDaughter() {
        return daughter;
    }

    public Node getParent() {
        return parent;
    }

    public Node copy() {
        Node cp = new Node();
        cp.setParent(parent);
        cp.setDaughter(daughter);
        return cp;
    }
}
