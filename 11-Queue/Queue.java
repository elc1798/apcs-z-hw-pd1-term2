public class Queue<E> {

    Node<E> head;
    Node<E> tail;

    public Queue(Node<E> n) {
        head = n;
        tail = n;
    }

    public void enqueue(E data) {
        Node<E> tmp = new Node<E>(data);
        tmp.setParent(tail);
        tail.setNext(tmp);
        tail = tmp;
    }

    public E dequeue() {
        if (tail == null) {
            return null;
        } else {
            Node<E> tmp = tail;
            tail = tail.getParent();
            return tmp.getData();
        }
    }

    public boolean empty() {
        return head == null && tail == null;
    }

    public E head() {
        return tail.getData();
    }
}
