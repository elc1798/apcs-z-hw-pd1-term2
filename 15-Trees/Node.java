public class Node<T extends Comparable<T>> {
    private T data;
    private Node<T> left;
    private Node<T> right;

    public Node(T newData){
        data = newData;
    }

    public Node<T> getLeft() {
        return left;
    }

    public Node<T> getRight() {
        return right;
    }

    public T getData() {
        return data;
    }

    public boolean isLeaf() {
        return (left == null) && (right == null);
    }

    public void setLeft(Node<T> newLeft) {
        left = newLeft;
    }

    public void setRight(Node<T> newRight) {
        right = newRight;
    }
}
