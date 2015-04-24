@SuppressWarnings("serial")
public class BSTNodeFullException extends Exception {

    public BSTNodeFullException() {
        super("Node is full: both right and left children are occupied");
    }

}
