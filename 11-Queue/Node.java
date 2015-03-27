public class Node<E>{
    private E data;
    private Node<E> next;
    private Node<E> parent;

    public Node(){
        data = null;
        next = null;
        parent = null;
    }
    public Node(E s){
        data = s;
        next = null;
        parent = null;
    }
    public void setData(E s){
        data = s;
    }
    public E getData(){
        return data;
    }
    public void setNext(Node<E> n){
        next = n;
    }
    public Node<E> getNext(){
        return next;
    }
    public String toString(){
        return ""+data;
    }
    public void setParent(Node<E> n) {
        parent = n;
    }
    public Node<E> getParent() {
        return parent;
    }
}
