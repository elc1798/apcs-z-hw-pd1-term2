public class Heap {

    private static final int START_SIZE = 2;

    private Comparable[] q;
    private int size;

    public Heap() {
        q = new Comparable[START_SIZE];
        q[0] = 0;
        size = 0;
    }

    public void add(Comparable n) {
        if (size == q.length - 1) {
            doubleArraySize();
        }
        int position = ++size;
        for (/* No initializer */ ; position > 1 && n.compareTo(q[getParent(position)]) < 0; position = position / 2) {
            q[position] = q[getParent(position)];
        }
        q[position] = n;
    }

    public Comparable pop() {
        if (size == 0) {
            return null;
        }
        Comparable retVal = q[1];
        q[1] = q[size--];
        percolateDownwards(1);
        return retVal;
    }

    public Comparable[] toArray() {
        return q;
    }

    public boolean empty() {
        return size == 0;
    }

    private void percolateDownwards(int index) {
        Comparable tmp = q[index];
        int child;
        for (/* No initializer */ ; 2 * index <= size ; index = child) {
            child = getLeftChild(index);
            if (child != size && q[child].compareTo(q[child + 1]) > 0) {
                child++;
            }
            if (tmp.compareTo(q[child]) > 0) {
                q[index] = q[child];
            } else {
                break;
            }
        }
        q[index] = tmp;
    }

    private void doubleArraySize() {
        Comparable[] tmp = new Comparable[q.length * 2];
        System.arraycopy(q , 1 , tmp , 1 , size);
        q = tmp;
    }

    private int getLeftChild(int i) {
        return i * 2;
    }

    private int getRightChild(int i) {
        return i * 2 + 1;
    }

    private int getParent(int i) {
        return i / 2;
    }
}
