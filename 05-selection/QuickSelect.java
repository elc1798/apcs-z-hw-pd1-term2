import java.util.Arrays;

public class QuickSelect {

    /**
     *
     * @param a = Array to process
     * @param k - Kth smallest number in array, domain of [0 , a.length)
     * @param l - Lower bound index to process
     * @param h - Higher bound index to process
     *
     */

    private static int select(int[] a , int k , int l , int h) {
        if (h >= a.length) {
            h = a.length - 1;
        }
        if (k < 0 || k >= a.length) {
            return -1;
        } else if (l >= h) {
            return a[k];
        } else {
            int[] b = new int[a.length];
            int pivotIndex = (int)(l + (h - l) / 2);
            int pivot = a[pivotIndex];
            int lower_bound = l;
            int higher_bound = h;
            for (int i = l; i <= h; i++) {
                if (a[i] < pivot) {
                    b[higher_bound] = a[i];
                    higher_bound--;
                } else if (a[i] > pivot) {
                    b[lower_bound] = a[i];
                    lower_bound++;
                }
            }
            for (int i = Integer.valueOf(lower_bound); i <= higher_bound; i++) {
                b[i] = pivot;
            }
            if (b[k] == pivot) {
                return pivot;
            } else {
                if (lower_bound > k) {
                    return select(b , k , l , lower_bound - 1);
                } else {
                    return select(b , k , lower_bound + 1 , h);
                }
            }
        }
    }

    public static int select(int[] a , int k) {
        return select(a , a.length - k - 1 , 0 , a.length - 1);
    }

}
