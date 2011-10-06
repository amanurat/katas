package step.ten;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinarySearchTest {

	@Test
	public void testElementBeforeStart() {
		assertEquals(BinarySearch.NO_INDEX, BinarySearch.findIndex(0, elements()));
	}	
	
	@Test
	public void testElementAfterEnd() {
		assertEquals(BinarySearch.NO_INDEX, BinarySearch.findIndex(0, elements()));
	}
	
	@Test
	public void testElementAtMiddle() {
		assertEquals(2, BinarySearch.findIndex(3, elements()));
	}
	
	@Test
	public void testNoElements() {
		assertEquals(BinarySearch.NO_INDEX, BinarySearch.findIndex(1, new int[]{}));
	}
	
	@Test
	public void testElementAtStart() {
		assertEquals(0, BinarySearch.findIndex(1, elements()));
	}
	
	@Test
	public void testElementAtEnd() {
		assertEquals(4, BinarySearch.findIndex(5, elements()));
	}

	private int[] elements() {
		return new int[]{1,2,3,4,5};
	}

}
