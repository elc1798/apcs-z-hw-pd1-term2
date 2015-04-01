import java.util.Arrays;
import java.util.Comparator;

public class MazeQueue {

    private Node[] q;
    private static final Comparator<Node> nodeComp = new Comparator<Node>() {
        @Override
        public int compare(Node n1 , Node n2) {
            return (int)(1000000.0 * (n1.cost - n2.cost));
        }
    }

    public MazeQueue() {
        q = new Node[0];
    }

    public void add(Node n) {
        for (Node a : q) {
            // Finish later
        }
        Node[] tmp = new Node[q.length + 1];
        System.arraycopy(q , 0 , tmp , 0 , q.length);
        tmp[q.length] = n;
        q = tmp;
        sortAscending();
    }

    public Node pop() {
        Node retVal = q[0];
        Node[] tmp = new Node[q.length - 1];
        System.arraycopy(q , 1 , tmp , 0 , q.length - 1);
        q = tmp;
        sortAscending();
        return retVal;
    }

    public Node peek() {
        return q[0];
    }

    public boolean empty() {
        return q.length == 0;
    }

    private void sortAscending() {
        Arrays.sort(q , nodeComp);
    }
}
