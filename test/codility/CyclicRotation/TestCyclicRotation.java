package codility.CyclicRotation;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import codility.CodilitySolution;

public class 					TestCyclicRotation 						
extends 						CodilitySolution					{

	@Test
	public void 				testEmpty							() {
	  res=invoke("solution",empty, 1);
	  assertArrayEquals ( empty,res );
	}
	
	@Test
	public void 				testRor2							() {
	  res=invoke("solution",new int [] { 1,2,3,4 },2);
	  assertArrayEquals(new int [] { 3,4,1,2 },res );
	  
	  res=invoke("solution",new int [] { 1,2,3,4,5 },2);
	  assertArrayEquals(new int [] { 4,5,1,2,3 },res );
	}
	
	@Test
	public void 				testRor3							() {
	  res=invoke("solution",new int [] { 1,2,3,4 },3);
	  assertArrayEquals(new int [] { 2,3,4,1 },res );
	  
	  res=invoke("solution",new int [] { 1,2,3,4,5 },3);
	  assertArrayEquals(new int [] { 3,4,5,1,2 },res );
	}

}
