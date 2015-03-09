import java.util.Random;
import java.util.Arrays;

public class Driver {

    private static final int DEFAULT_STRESS_TEST_ARRAY_SIZE = 15;
    private static final Random r = new Random();

    public static void main(String[] args) {
        int[] test_1 = new int[]{9 , 1 , 0 , 2 , 5 , 6 , 3 , 8 , 7 , 4};
        int[] test_2 = new int[]{};
        if (args.length > 0) {
            try {
                test_2 = new int[Integer.parseInt(args[0])];
            } catch(Exception e) {}
        } else {
            test_2 = new int[DEFAULT_STRESS_TEST_ARRAY_SIZE];
        }

        for (int i = 0 ; i < test_2.length ; i++) {
            test_2[i] = r.nextInt(test_2.length);
        }

        System.out.println("Basic list test: ");
        for (int i = -1 ; i < test_1.length + 1 ; i++) {
            System.out.println(QuickSelect.select(test_1 , i));
        }

        System.out.println("Stress test: ");
        System.out.println(Arrays.toString(test_2));
        System.out.println("Stress test solution: ");
        int[] test_2_solution = new int[test_2.length];
        System.arraycopy(test_2 , 0 , test_2_solution , 0 , test_2.length);
        Arrays.sort(test_2_solution);
        System.out.println(Arrays.toString(test_2_solution));
        for (int i = 0 ; i < test_2.length ; i++) {
            System.out.println(QuickSelect.select(test_2 , i));
        }
    }

}
