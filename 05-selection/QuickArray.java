import java.util.Arrays;

public class QuickArray {
	private int[] DATA;
	private int[] tmp;
	private int max;
	private int min;

	public QuickArray(int[] _DATA) {
		DATA = new int[_DATA.length];
		tmp = new int[_DATA.length];
		System.arraycopy(_DATA , 0 , DATA , 0 , _DATA.length);
		setMinMax(0 , DATA.length , DATA);
	}

	public void setMinMax(int start , int end , int[] a) {
		max = a[start];
		min = a[start];
		for (int i = start; i < end; i++) {
			if (a[i] < min) {
				min = a[i];
			} else if (a[i] > max) {
				max = a[i];
			}
		}
	}

	public boolean arraysEqualSublist(int[] a , int[] b, int s , int f) {
		for (int i = s; i < f; i++) {
			if (a[i] != b[i]) {
				return false;
			}
		}
		return true;
	}

	public int getNthSmallest(int n) {
		if (n < 0 || n >= DATA.length) {
			return -1;
		}
		int startIndex = 0;
		int endIndex = DATA.length - 1;
		int lower_bound = startIndex;
		int higher_bound = endIndex;

		int[] modified = new int[DATA.length];

		System.arraycopy(DATA , 0 , tmp , 0 , DATA.length);
		System.arraycopy(DATA , 0 , modified , 0 , DATA.length);

		while (endIndex - startIndex > 0) {
			setMinMax(startIndex , endIndex , tmp);
			int pivot = (max + min / 2);
			System.out.printf("%2d , %2d | %2d " , startIndex , endIndex , pivot);
			System.out.println(Arrays.toString(tmp));
			lower_bound = startIndex;
			higher_bound = endIndex;
			for (int i = startIndex; i < endIndex; i++) {
				if (tmp[i] < pivot) {
					modified[lower_bound] = tmp[i];
					lower_bound++;
				} else if (tmp[i] > pivot) {
					modified[higher_bound] = tmp[i];
					higher_bound--;
				}
			}
			if (lower_bound > n) { // The index we want is less the current lower_bound. Therefore our new bounds are startIndex , lower_bound
				// Start Index does not change
				endIndex = lower_bound + 1;
			} else if (higher_bound < n) {
				// The current higher bound of pivot values is lower than the target index. Therefore, the subset
				// [higher_bound , endIndex) contains the index
				startIndex = higher_bound;
			} else { // lower_bound < target index < higher_bound means THE TARGET INDEX IS THE PIVOT VALUE
				return pivot;
			}
			if (arraysEqualSublist(tmp , modified , startIndex , endIndex)) {
				return tmp[n];
			}
			System.arraycopy(modified , 0 , tmp , 0 , modified.length);
		}
		return -1;
	}
}
