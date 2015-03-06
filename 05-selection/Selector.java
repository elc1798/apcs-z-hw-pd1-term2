import java.util.Arrays;

public class Selector {

    public static int getPivot(int[] a) {
        int max = a[0];
        for (int i : a) {
            if (i > max) {
                max = i;
            }
        }
        return max / 2;
    }

    public static int[] mildSort(int[] a , int index , int pivot , int startIndex , int endIndex) {
        int[] cpy = new int[a.length];
        System.arraycopy(a , 0 , cpy , 0 , a.length);
        
        int index_low = startIndex;
        int index_high = endIndex - 1;
 
        for (int i = 0; i < endIndex - startIndex; i++) {
            if (a[i] < pivot) {
                cpy[index_low] = a[i];
                index_low++;
            } else if (a[i] > pivot) {
                cpy[index_high] = a[i];
                index_high--;
            }
        }
        while (index_low < index_high) {
            cpy[index_low] = pivot;
            index_low++;
        }
        System.out.println(Arrays.toString(cpy));
        return cpy;
    }

    public static int selector(int[] a , int index , int startIndex , int endIndex) {
        int[] tmp = mildSort(a , index , getPivot(Arrays.copyOfRange(a , startIndex , endIndex)) , startIndex , endIndex);
        if (a.length == 0 || index >= a.length || index < 0) {
            return -1; // Does not exist
        } else if (startIndex + 1 == endIndex) {
            return a[index];
        } else {
            if (index < endIndex / 2) {
                return selector(tmp , index , startIndex , endIndex / 2);
            } else {
                return selector(tmp , index , endIndex / 2 , endIndex);
            }
        }
    }

    public static int getNthSmallest(int[] a , int index) {
        if (index >= a.length) {
            return -1;
        } else {
            return selector(a , index , 0 , a.length);
        }
    }

    public static void main(String[] args) {
        int[] test_1 = new int[]{9 , 2 , 3 , 4 , 5 , 8 , 0 , 7 , 1 , 6};
        int[] test_2 = new int[]{1 , 0 , 0 , 2 , 3 , 1 , 2 , 3 , 5 , 9};

        System.out.println(Selector.getNthSmallest(test_1 , 0) + " | SHOULD BE 0");
        System.out.println(Selector.getNthSmallest(test_1 , 1) + " | SHOULD BE 1");
        System.exit(0);
        System.out.println(Selector.getNthSmallest(test_1 , 4) + " | SHOULD BE 4");
        System.out.println(Selector.getNthSmallest(test_1 , 9) + " | SHOULD BE 9");
        System.out.println(Selector.getNthSmallest(test_1 , 10) + " | SHOULD BE -1");
        System.out.println(Selector.getNthSmallest(test_2 , 0) + " | SHOULD BE 0");
        System.out.println(Selector.getNthSmallest(test_2 , 2) + " | SHOULD BE 1");
        System.out.println(Selector.getNthSmallest(test_2 , 4) + " | SHOULD BE 2");
        System.out.println(Selector.getNthSmallest(test_2 , 9) + " | SHOULD BE 9");
    }
}
