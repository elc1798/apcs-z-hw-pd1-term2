public class Driver {

    public static void main(String[] args) {
        Node<String> fill = new Node<String>("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        Queue qiu = new Queue(fill);
        qiu.enqueue("abcdefghijklmnopqrstuvwxyz");
        qiu.enqueue(new StringBuffer(fill.getData()).reverse().toString());
        qiu.enqueue(new StringBuffer(fill.getData()).reverse().toString().toLowerCase());
        while (!qiu.empty()) {
            System.out.println(qiu.dequeue());
        }
    }

}
