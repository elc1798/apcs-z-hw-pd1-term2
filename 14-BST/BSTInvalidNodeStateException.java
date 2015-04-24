@SuppressWarnings("serial")
public class BSTInvalidNodeStateException extends Exception {

    public BSTInvalidNodeStateException() {
        super("Node state is invalid : Not leaf, fork, or elbow");
    }

}
