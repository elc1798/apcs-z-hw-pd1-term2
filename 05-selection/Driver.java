public class Driver {
    public static void main(String[] args) {
        int[] test_1 = new int[]{0 , 1 , 4 , 9 , 2 , 8 , 7 , 3 , 6 , 5};
        QuickArray loader = new QuickArray(test_1);
        for (int i = -1 ; i < 11 ; i++) {
            System.out.println(loader.getNthSmallest(i));
        }
    }
}
