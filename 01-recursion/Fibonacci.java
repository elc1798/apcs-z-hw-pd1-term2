public class Fibonacci {
	
	private static final int INDEX_0 = 0;
	private static final int INDEX_1 = 1;
	
	/*
	 * Assuming:
	 * fib(0) -> 0
	 * fib(1) -> 1 
	 */
	
	public static int fib_helper(int n , int prevprev , int prev) {
		//Count upwards
		if (n == 0) {
			return prevprev;
		} else {
			return fib_helper(n - 1 , prev , prevprev + prev);
		}
	}
	
	public static int fib(int n) {
		return fib_helper(n , 0 , 1);
	}
	
	public static void main(String[] args) {
		System.out.println(fib(0));
		System.out.println(fib(1));
		System.out.println(fib(2));
		System.out.println(fib(3));
		System.out.println(fib(4));
		System.out.println(fib(5));
		System.out.println(fib(6));
		System.out.println(fib(7));
		System.out.println(fib(8));
		System.out.println(fib(9));
	}
}
