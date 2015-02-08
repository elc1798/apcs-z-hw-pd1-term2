public class BunnyEars2 {

    public int bunnyEars2(int bunnies) {
        if (bunnies == 0) {
            return 0;
        } else if (bunnies % 2 == 0) {
            return 3 + bunnyEars2(bunnies - 1);
        } else {
            return 2 + bunnyEars2(bunnies - 1);
        }
    }

    public static void main(String[] args) {
        BunnyEars2 be2 = new BunnyEars2();
        System.out.println(be2.bunnyEars2(0));
        System.out.println(be2.bunnyEars2(1));
        System.out.println(be2.bunnyEars2(2));
        System.out.println(be2.bunnyEars2(3));
    }
}
