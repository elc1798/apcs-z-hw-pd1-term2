public class CountCharFreq {
	public static int count(String s , char c) {
		if (s.length() == 0) {
			return 0;
		} else if (s.charAt(0) == c) {
			return 1 + count(s.substring(1) , c);
		} else {
			return count(s.substring(1) , c);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(count("asdfssssd" , 's'));
	}
}