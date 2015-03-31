public class Node {

    public int r;
    public int c;

    private Node parent;

    public Node(){
        r = -1;
        c = -1;
        parent = null;
    }

    public Node(int x , int y){
        r = x;
        c = y;
        parent = null;
    }

    public void setParent(Node n){
        parent = n;
    }

    public Node getParent(){
        return parent;
    }

}
