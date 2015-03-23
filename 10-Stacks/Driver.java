public class Driver {
    public static void main(String[] args) {
        Stack s = new Stack(new Node<Integer>(0));
        for (int i = 1; i <= 10; i++) {
            s.push(i);
        }
        for (int i = 0; i < 11; i++) {
            System.out.println(s.pop());
        }
    }
}
