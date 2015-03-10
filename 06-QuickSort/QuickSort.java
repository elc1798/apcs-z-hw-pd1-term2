public class QuickSort {

    private static void qsort(int[] a , int l , int h) {

        if (h >= a.length) {
            return;
        }
        if (l < 0) {
            return;
        }

        if (l >= h) {
            return;
        } else {
            int[] b = new int[a.length];
            System.arraycopy(a , 0 , b , 0 , a.length);
            int pivotIndex = (int)(l + ((h - l) / 2));
            int pivot = a[pivotIndex];
            int lower_bound = l;
            int higher_bound = h;
            for (int i = l ; i <= h ; i++) {
                if (a[i] > pivot) {
                    b[higher_bound] = a[i];
                    higher_bound--;
                } else if (a[i] < pivot) {
                    b[lower_bound] = a[i];
                    lower_bound++;
                }
            }
            for (int i = Integer.valueOf(lower_bound); i <= higher_bound; i++) {
                b[i] = pivot;
            }
            System.arraycopy(b , 0 , a , 0 , a.length);
            qsort(a , l , lower_bound - 1);
            qsort(a , lower_bound + 1 , h);
        }
    }

    public static void qsort(int[] a) {
        qsort(a , 0 , a.length - 1);
    }

    public static int[] qsorted(int[] a) {
        int[] b = new int[a.length];
        System.arraycopy(a , 0 , b , 0 , a.length);
        qsort(b , 0 , a.length - 1);
        return b;
    }

}
