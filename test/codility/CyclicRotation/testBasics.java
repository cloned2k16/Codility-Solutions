package codility.CyclicRotation;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import codility.CyclicRotation.Solution;

public class testBasics {

	Solution obj = new Solution();
	int [] empty = new int [] {};
	
	@Test
	public void 		testBrute() {
	  int [] res=obj.brute(empty, 1);
	  assertEquals ( empty,res );
	  
	  res=obj.brute				(new int [] { 1,2,3,4 },2);
	  assertTrue (Arrays.equals	(new int [] { 3,4,1,2 },res ));
	  
	  res=obj.brute				(new int [] { 1,2,3,4,5 },2);
	  assertTrue (Arrays.equals	(new int [] { 4,5,1,2,3 },res ));

	  res=obj.brute				(new int [] { 1,2,3,4 },3);
	  assertTrue (Arrays.equals	(new int [] { 2,3,4,1 },res ));
	  
	  res=obj.brute				(new int [] { 1,2,3,4,5 },3);
	  assertTrue (Arrays.equals	(new int [] { 3,4,5,1,2 },res ));
	}

	@Test
	public void 		testSolution() {
	  int [] res=obj.solution(empty, 1);
	  assertEquals ( empty,res );

	  res=obj.solution			(new int [] { 1,2,3,4 },2);
	  assertTrue (Arrays.equals	(new int [] { 3,4,1,2 },res ));
	  
	  res=obj.solution			(new int [] { 1,2,3,4,5 },2);
	  assertTrue (Arrays.equals	(new int [] { 4,5,1,2,3 },res ));

	  res=obj.solution			(new int [] { 1,2,3,4 },3);
	  assertTrue (Arrays.equals	(new int [] { 2,3,4,1 },res ));
	  
	  res=obj.solution			(new int [] { 1,2,3,4,5 },3);
	  assertTrue (Arrays.equals	(new int [] { 3,4,5,1,2 },res ));
}

}
