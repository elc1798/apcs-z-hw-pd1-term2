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
        int[] ARY = new int[a.length / 2];
        for (int i = 0; i < ARY.length; i++) {
            ARY[i] = a[i];
        }
        return ARY;
    }

    public static int[] secondHalf(int[] a) {
        int START = a.length / 2;
        int[] ARY = new int[a.length - START];

        for (int i = START; i < a.length; i++) {
            ARY[i - START] = a[i];
        }
        return ARY;
    }

    public static int[] mergeSort(int[] a) {
        return merge(firstHalf(a) , secondHalf(a) , false);
    }

    public static void main(String[] args) {
        Random r = new Random();
        int[] test = new int[30];
        for (int i = 0; i < 30; i++) {
            test[i] = r.nextInt(100) - 50;
        }
        System.out.println("Original: " + Arrays.toString(test));
        long time = System.nanoTime();
        int[] sorted = mergeSort(test);
        time = System.nanoTime() - time;
        System.out.println("Sorted: " + Arrays.toString(sorted));
        System.out.println("Duration: " + time + " nanoseconds");
    }

}