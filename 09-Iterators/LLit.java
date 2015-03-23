import java.io.*;
import java.util.*;

public class LLit<E> implements Iterator<E>{

    private Node<E> t;
    private int element;

    public LLit(Node<E> n) {
        t = n;
        element = 0;
    }

    public boolean hasNext() {
        return t != null;
    }

    public E next() {
        E retval = t.getData();
        t = t.getNext();
        element++;
        return retval;
    }

    public void remove() {
        if (element < 0) {
            throw new IllegalStateException();
        }
        try {
            Node<E> toDelete = t;
            t = t.getNext();
            toDelete = null;
        } catch (Exception e) {
            throw new ConcurrentModificationException();
        }
    }
}