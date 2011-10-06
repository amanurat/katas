package step.four;

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


}
