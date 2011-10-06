package step.eight;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinarySearchTest {

	@Test
	public void testElementBeforeStart() {
		assertEquals(-1, BinarySearch.findIndex(0, new int[]{1,2,3,4,5}));
	}
	
	@Test
	public void testElementAfterEnd() {
		assertEquals(-1, BinarySearch.findIndex(0, new int[]{1,2,3,4,5}));
	}
	
	@Test
	public void testElementAtMiddle() {
		assertEquals(2, BinarySearch.findIndex(3, new int[]{1,2,3,4,5}));
	}
	
	@Test
	public void testNoElements() {
		assertEquals(-1, BinarySearch.findIndex(1, new int[]{}));
	}
	
	@Test
	public void testElementAtStart() {
		assertEquals(0, BinarySearch.findIndex(1, new int[]{1,2,3,4,5}));
	}


}
