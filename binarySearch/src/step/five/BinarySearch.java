package step.five;

public class BinarySearch {

	public static int findIndex(int key, int[] elements) {
		int low = 0;
		int high = elements.length - 1;
		
		int mid = (low + high) / 2;
		if (key == elements[mid]) {
			return mid;
		}
		
		return -1;
	}

}
