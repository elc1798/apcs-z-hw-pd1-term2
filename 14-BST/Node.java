public class Node<E> {

    private int data;

    private Node left , right;
    private Node parent;

    public Node() {
        data = 0;

        left = null;
        right = null;
        parent = null;
    }

    public Node(int i) {
        data = i;

        left = null;
        right = null;
        parent = null;
    }

    public void setData(int i) {
        data = i;
    }

    public int getData() {
        return data;
    }

    public void setLeft(Node n) {
        left = n;
    }

    public void setRight(Node n) {
        right = n;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public String toString() {
        return ""+data;
    }

    public void setParent(Node n) {
        parent = n;
    }

    public Node<E> getParent() {
        return parent;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    public boolean isFork() {
        return left != null && right != null;
    }

    public boolean isElbow() {
        return !isLeaf() && !isFork();
    }
}
