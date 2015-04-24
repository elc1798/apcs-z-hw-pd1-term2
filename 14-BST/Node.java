public class Node<E> {

    private E data;

    private Node<E> left , right;
    private Node<E> parent;

    public Node() {
        data = null;

        left = null;
        right = null;
        parent = null;
    }

    public Node(E s) {
        data = s;

        left = null;
        right = null;
        parent = null;
    }

    public void setData(E s) {
        data = s;
    }

    public E getData() {
        return data;
    }

    public void setLeft(Node<E> n) {
        left = n;
    }

    public void setRight(Node<E> n) {
        right = n;
    }

    public Node<E> getLeft() {
        return left;
    }

    public Node<E> getRight() {
        return right;
    }

    public String toString() {
        return ""+data;
    }

    public void setParent(Node<E> n) {
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
