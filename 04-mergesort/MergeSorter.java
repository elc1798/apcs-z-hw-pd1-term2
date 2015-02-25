import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class MergeSorter {

    public static ArrayList<Integer> merge(ArrayList<Integer> a , ArrayList<Integer> b , boolean mergeBack) {
        if (a.size() <= 1 && b.size() <= 1 && !mergeBack) {
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

    public static ArrayList<Integer> combine(ArrayList<Integer> a , ArrayList<Integer> b) {
        ArrayList<Integer> ARYL = new ArrayList<Integer>();
        while (a.size() + b.size() > 0) {
            if (a.size() > 0 &&  b.size() > 0) {
                if (a.get(0) < b.get(0)) {
                    ARYL.add(a.remove(0));
                } else {
                    ARYL.add(b.remove(0));
                }
            } else if (a.size() == 0) {
                ARYL.add(b.remove(0));
            } else if (b.size() == 0) {
                ARYL.add(a.remove(0));
            }
        }
        return ARYL;
    }

    public static ArrayList<Integer> firstHalf(ArrayList<Integer> a) {
        ArrayList<Integer> ARYL = new ArrayList<Integer>();
        for (int i = 0; i < a.size() / 2; i++) {
            ARYL.add(a.get(i));
        }
        return ARYL;
    }

    public static ArrayList<Integer> secondHalf(ArrayList<Integer> a) {
        ArrayList<Integer> ARYL = new ArrayList<Integer>();
        for (int i = a.size() / 2; i < a.size(); i++) {
            ARYL.add(a.get(i));
        }
        return ARYL;
    }

    public static ArrayList<Integer> mergeSort(ArrayList<Integer> a) {
        return merge(firstHalf(a) , secondHalf(a) , false);
    }

    public static void main(String[] args) {
        Random r = new Random();
        ArrayList<Integer> test = new ArrayList<Integer>();
        for (int i = 0; i < 30; i++) {
            test.add(r.nextInt(100) - 50);
        }
        System.out.println("Original: " + test.toString());
        long time = System.currentTimeMillis();
        ArrayList<Integer> sorted = mergeSort(test);
        time = System.currentTimeMillis() - time;
        System.out.println("Sorted: " + sorted.toString());
        System.out.println("Duration: " + time + " milliseconds");
    }

}
