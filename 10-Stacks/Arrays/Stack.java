import java.lang.reflect.Array;

public class Stack<E> {

    private E[] stack;
    private Class<E> classtype;

    public Stack(Class<E> c) {
        classtype = c;
        @SuppressWarnings("unchecked")
        final E[] creator = (E[]) Array.newInstance(c , 0);
        stack = creator;
    }

     public void push(E data) {
        @SuppressWarnings("unchecked")
        final E[] ebp = (E[]) Array.newInstance(classtype , stack.length + 1);
        System.arraycopy(stack , 0 , ebp , 1 , stack.length);
        ebp[0] = data;
        stack = ebp;
    }

    public E pop() {
        if (stack.length == 0) {
            return null;
        } else {
            @SuppressWarnings("unchecked")
            final E[] ebp = (E[]) Array.newInstance(classtype , stack.length - 1);
            System.arraycopy(stack , 1 , ebp , 0 , stack.length - 1);
            E retVal = stack[0];
            stack = ebp;
            return retVal;
        }
    }

    public boolean empty() {
        return stack.length == 0;
    }

    public E top() {
        return stack[0];
    }

}
