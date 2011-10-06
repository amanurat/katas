package step.eight;

public class BinarySearch {

	public static int findIndex(int key, int[] elements) {
		int low = 0;
		int high = elements.length - 1;
		
		while (low <= high) {
			int mid = (low + high) / 2;
			if (key == elements[mid]) {
				return mid;
			} else if (key < elements[mid]) {
				high = mid - 1;
			}
		}
		return -1;
	}

}
