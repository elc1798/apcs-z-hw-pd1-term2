public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    public LinkedList() {
        head = null;
        tail = null;
        length = 0;
    }

    public LinkedList(Node n) {
        head = n;
        tail = n;
        length = 1;
    }

    public void append(Node n) {
        Node tmp = tail.copy();
        n.setParent(tmp);
        tmp.setDaughter(n);
        tail = n;
        length++;
    }

    public void prepend(Node n) {
        Node tmp = head.copy();
        n.setDaughter(tmp);
        tmp.setParent(n);
        head = n;
        length++;
    }

    public void rmNode(Node n) {
        n.getParent().setDaughter(n.getDaughter());
        n.getDaughter().setParent(n.getParent());
        n.setParent(null);
        n.setDaughter(null);
        length--;
    }

    public void insert(int index) {

    }
}
