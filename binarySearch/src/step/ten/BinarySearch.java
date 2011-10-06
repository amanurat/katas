package step.ten;

public class BinarySearch {

	public static final int NO_INDEX = -1;

	public static int findIndex(int key, int[] elements) {
		int low = 0;
		int high = elements.length - 1;
		
		while (low <= high) {
			int mid = low + high >>> 1;
			int midValue = elements[mid];
			if (key == midValue) {
				return mid;
			} else if (key < midValue) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return NO_INDEX;
	}
}
