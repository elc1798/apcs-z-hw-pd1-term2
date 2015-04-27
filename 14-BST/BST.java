public class BST {

    Node ROOT;

    public BST() {
        ROOT = null;
    }

    public Node search(Node n , int i) throws Exception {
        if (n == null || n.getData() == i) {
            return n;
        } else if (n.getData() < i) {
            return search(n.getRight() , i);
        } else if (n.getData() > i) {
            return search(n.getLeft() , i);
        } else {
            throw new BSTInvalidNodeStateException();
        }
    }

    public String firstOccurenceOf(int i) throws Exception {
        Node n = search(ROOT , i);
        if (n == null) {
            return "Value not found";
        } else {
            return n.toString();
        }
    }

    public void insert(int i) throws Exception {
        Node n = new Node(i);
        Node TMP1 = ROOT;
        Node TMP2 = null;

        if (ROOT == null) {
            ROOT = n;
            return;
        }

        while (TMP1 != null) {
            TMP2 = TMP1;
            if (TMP1.getData() == i) {
                return;
            } else if (TMP1.getData() < i) {
                TMP1 = TMP1.getRight();
            } else if (TMP1.getData() > i) {
                TMP1 = TMP1.getLeft();
            } else {
                throw new BSTInvalidNodeStateException();
            }
        }

        if (i > TMP2.getData()) {
            TMP2.setRight(n);
        } else {
            TMP2.setLeft(n);
        }
    }

    public String traverse(Node n) {
        if (ROOT == null) {
            return "NULL";
        } else {
            return BTreeStringBuilder.stringOf(ROOT);
        }
    }

    public String toString() {
        return traverse(ROOT);
    }

}
