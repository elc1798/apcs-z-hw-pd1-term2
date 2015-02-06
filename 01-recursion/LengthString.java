public class LengthString {
	public static int len(String s) {
		if (s.equals("")) {
			return 0;
		} else {
			return 1 + len(s.substring(1));
		}
	}
	
	public static void main(String[] args) {
		System.out.println(len("ASDF"));
	}
}