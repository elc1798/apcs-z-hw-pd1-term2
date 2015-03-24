public class Driver {
    public static void main(String[] args) {
        Stack s = new Stack(Integer.class);
        for (int i = 1; i <= 10; i++) {
            s.push(i);
        }
        int sum = 0;
        while (!s.empty()) {
            sum += (int)s.top();
            System.out.println(s.pop());
        }
        System.out.println(sum); // Should be 55
    }
}
