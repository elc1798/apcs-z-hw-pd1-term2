import java.util.Random;
import java.util.Arrays;

public class MergeSorter {

    public static int[] merge(int[] a , int[] b , boolean mergeBack) {
        if (a.length <= 1 && b.length <= 1 && !mergeBack) {
            return merge(a , b , true);
        } else if (mergeBack) {
            return combine(a , b);
        } else {
            return merge(
                    merge(firstHalf(a) , secondHalf(a) , false) ,
                    merge(firstHalf(b) , secondHalf(b) , false) ,
                    true
                    );
        }
    }

    public static int[] combine(int[] a , int[] b) {
        int[] ARY = new int[a.length + b.length];
        int a_index = 0;
        int b_index = 0;
        for (int i = 0; i < a.length + b.length; i++) {
            if (a_index < a.length && b_index < b.length) {
                if (a[a_index] < b[b_index]) {
                    ARY[i] = a[a_index];
                    a_index++;
                } else {
                    ARY[i] = b[b_index];
                    b_index++;
                }
            } else if (a_index < a.length) {
                ARY[i] = a[a_index];
                a_index++;
            } else if (b_index < b.length) {
                ARY[i] = b[b_index];
                b_index++;
            } else {
                // This segment should never be reached
                System.out.println("Weirdness is occuring in combiner...");
            }
        }
        return ARY;
    }

    public static int[] firstHalf(int[] a) {
        return Arrays.copyOfRange(a , 0 , a.length / 2);
    }

    public static int[] secondHalf(int[] a) {
        return Arrays.copyOfRange(a , a.length / 2 , a.length);
    }

    public static int[] mergeSort(int[] a) {
        return merge(firstHalf(a) , secondHalf(a) , false);
    }

    public static void main(String[] args) {
        Random r = new Random();
        int size = 100000;
        if (args.length > 0) {
            try {
                size = Integer.parseInt(args[0]);
            } catch(Exception e) {}
        }
        int[] test = new int[size];
        for (int i = 0; i < size; i++) {
            test[i] = r.nextInt(100) - 50;
        }
//      System.out.println("Original: " + Arrays.toString(test));
        System.out.println("Elements: " + test.length);
        long time = System.nanoTime();
        int[] sorted = mergeSort(test);
        time = System.nanoTime() - time;
        String strtime = Long.toString(time);
        strtime = strtime.substring(0 , strtime.length() - 6) + "." + strtime.substring(strtime.length() - 6);
//      System.out.println("Sorted: " + Arrays.toString(sorted));
        System.out.println("Duration: " + strtime + " milliseconds");
    }

}
