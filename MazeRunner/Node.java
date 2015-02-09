import java.util.ArrayList;

public class Node {

    private Node parent = null;
    private ArrayList<Node> children = new ArrayList<Node>();
    
    public boolean isFinish = false;
    public boolean isStart = false;

    public Node(Node _parent , ArrayList<Node> _children , boolean _isFinish , boolean _isStart) {
        parent = _parent;
        for (Node n : _children) {
            children.add(n);
        }
        isFinish = _isFinish;
        isStart = _isStart;
    }

    public ArrayList<Node> getChildren() {
        return children;
    }

    public Node getParent() {
        return parent;
    }

    public Node checker() {
        //Call destructor if isFinish is true
        if (parent == null) {
            return null;
        }
        if (!parent.isStart) {
            return parent.checker();
            parent = null;
        } else {
            return this;
        }
    }

    public void destructor() {
        if (parent != null) {
            parent.destructor();
            parent = null;
        }
    }

    public ArrayList<Node> getPath() {

    }
}
