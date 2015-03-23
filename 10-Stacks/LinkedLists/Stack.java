public class Stack<E> {

    private Node<E> eap;

    public Stack(Node<E> n) {
        eap = n;
    }

    public void push(E data) {
        Node<E> ebp = new Node<E>(data);
        Node<E> eip = eap;
        ebp.setNext(eip);
        eap = ebp;
    }

    public E pop() {
        if (eap == null) {
            return null;
        } else {
            Node<E> eip = eap;
            Node<E> ebp = eap.getNext();
            eap = ebp;
            return eip.getData();
        }
    }

    public boolean empty() {
        return eap == null;
    }

    public E top() {
        return eap.getData();
    }

}
