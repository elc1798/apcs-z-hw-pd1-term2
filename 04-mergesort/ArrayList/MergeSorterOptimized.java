import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class MergeSorterOptimized {

    public static List<Integer> merge(List<Integer> a , List<Integer> b , boolean mergeBack) {
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

    public static List<Integer> combine(List<Integer> a , List<Integer> b) {
        List<Integer> ARYL = new ArrayList<Integer>();

        int a_index = 0;
        int b_index = 0;

        for(int i = 0; i < a.size() + b.size(); i++) {
            if (a_index < a.size() && b_index < b.size()) {
                if (a.get(a_index) < b.get(b_index)) {
                    ARYL.add(a.get(a_index));
                    a_index++;
                } else {
                    ARYL.add(b.get(b_index));
                    b_index++;
                }
            } else {
                if (a_index >= a.size()) {
                    ARYL.add(b.get(b_index));
                    b_index++;
                } else {
                    ARYL.add(a.get(a_index));
                    a_index++;
                }
            }
        }
        return ARYL;
    }

    public static List<Integer> firstHalf(List<Integer> a) {
        return a.subList(0 , a.size() / 2);
    }

    public static List<Integer> secondHalf(List<Integer> a) {
        return a.subList(a.size() / 2 , a.size());
    }

    public static List<Integer> mergeSort(List<Integer> a) {
        return merge(firstHalf(a) , secondHalf(a) , false);
    }

    public static void main(String[] args) {
        Random r = new Random();
        List<Integer> test = new ArrayList<Integer>();
        for (int i = 0; i < 100000; i++) {
            test.add(r.nextInt(100) - 50);
        }
//        System.out.println("Original: " + test.toString());
        long time = System.nanoTime();
        List<Integer> sorted = mergeSort(test);
        time = System.nanoTime() - time;
        String strtime = Long.toString(time);
//        System.out.println("Sorted: " + sorted.toString());
        System.out.println("Duration: " +  strtime.substring(0 , strtime.length() - 6) + "." + strtime.substring(strtime.length() - 6) + " milliseconds");
    }

}
