public class HWUTIL {

    public static void sleep(int n) {
        try {
            Thread.sleep(n);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void clear() {
        System.out.println("\033\143");
    }

}
