package codility.TapeEquilibrium;

import static org.junit.Assert.*;

import org.junit.Test;



public class SolutionTest {
	
	Solution obj = new Solution();
	int [] empty = new int [] {};

	@Test
	public void testSolution() {
		
		assertEquals ( 0,obj.solution(empty) );
		
		assertEquals ( 0, obj.solution(new int [] {5}) );

		assertEquals ( 1, obj.solution(new int [] { 3, 1, 2, 4, 3}) );
		
		assertEquals ( 0, obj.solution(new int [] { 5,-5,-5, 5}) );
		
		assertEquals ( 1, obj.solution(new int [] {-3,-1,-2,-4,-3}) );
		
		
		
	}

}
