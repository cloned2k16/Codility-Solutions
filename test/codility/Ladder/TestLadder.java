package codility.Ladder; 

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import codility.CodilitySolution;

public class 					TestLadder 						
extends							CodilitySolution					
{
	
	@Test
	public void 				testEmpty() 						{
	  res= invoke("solution", empty, empty);
	  assertArrayEquals (empty,res );
	}

	@Test
	public void 				testExample()						{ 
	  res= invoke("solution", new int [] {4,4,5,5,1}, new int[] {3,2,4,3,1}); 
	  assertArrayEquals (     new int [] {5,1,8,0,1} ,res );
	}

}
