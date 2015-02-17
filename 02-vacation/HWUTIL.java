public class HWUTIL {

	public static void sleep(int n) {
		try {
			Thread.sleep(n);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

    public static void clear() {
        System.out.println("\033\143");
    }

	public static boolean checkKnightsTour(int[][] board) {
		//Board should have no -1
		for (int[] ary : board) {
			for (int i : ary) {
				if (i == -1) { return false; }
			}
		}
		return true;
	}
}
