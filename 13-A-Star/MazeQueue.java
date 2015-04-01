import java.util.Arrays;
import java.util.Comparator;

public class MazeQueue {

    private Node[] q;

    public MazeQueue() {
        q = new Node[0];
    }

    public void add(Node n) {
        Node[] tmp = new Node[q.length + 1];
        System.arraycopy(q , 0 , tmp , 0 , q.length);
        tmp[q.length] = n;
        q = tmp;
    }

    public Node pop() {
        Node retVal = q[0];
        Node[] tmp = new Node[q.length - 1];
        System.arraycopy(q , 1 , tmp , 0 , q.length - 1);
        q = tmp;
        return retVal;
    }

    public Node peek() {
        return q[0];
    }

    public boolean empty() {
        return q.length == 0;
    }

    public Node[] toArray() {
        return q;
    }

    public void loadLowestCost() {
        int min = 0;
        for (int i = 0; i < q.length; i++) {
            if (q[i].cost < q[min].cost) {
                min = i;
            }
        }
        Node swapTmp = q[0];
        q[0] = q[min];
        q[min] = swapTmp;
        swapTmp = null;
    }
}
