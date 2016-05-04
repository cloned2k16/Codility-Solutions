package codility.TapeEquilibrium;

import static org.junit.Assert.*;

import org.junit.Test;

import codility.CodilitySolution;



public class 					TapeEquilibrium 						
extends							CodilitySolution					{
	

	@Test
	public void 				testEmpty							() 								{
		assertEquals ( 0,invokeI("solution",empty) );
	}		
		
	@Test
	public void 				testSingle							() 								{
		assertEquals ( 0, invokeI("solution",new int [] {5}) );
	}
	
	@Test
	public void 				testExample							() 								{
		assertEquals ( 1, invokeI("solution",new int [] { 3, 1, 2, 4, 3}) );
	}
	
	@Test
	public void 				testBalanced						() 								{
		assertEquals ( 0, invokeI("solution",new int [] { 5,-5,-5, 5}) );
	}
	
	@Test
	public void 				testEampleNegative					() 								{
		assertEquals ( 1, invokeI("solution",new int [] {-3,-1,-2,-4,-3}) );
	}

}
