/**
 *
 * Binary Search Tree Implementation
 * This implementation prioritizes from left branches to right branches via a
 * compareTo() method.
 *
 */

public class BST<E> {

    private Node<E> ROOT;

    public BST() {
        ROOT = null;
    }

    public BST(E data) {
        ROOT = new Node(data);
    }

    public void insert(Node relativeRoot , E value) throws Exception {
        if (relativeRoot.isFork()) {
            throw new BSTNodeFullException();
        } else if (relativeRoot.isLeaf()) {
            Node<E> tmp = new Node<E>(value);
            tmp.setParent(relativeRoot);
            relativeRoot.setLeft(tmp);
        } else if (relativeRoot.isElbow()) {
            Node<E> tmp = new Node<E>(value);
            tmp.setParent(relativeRoot);
            relativeRoot.setRight(tmp);
        } else {
            throw new BSTInvalidNodeStateException();
        }
    }

    public void search(Node relativeRoot , E value) throws Exception {

    }
}
