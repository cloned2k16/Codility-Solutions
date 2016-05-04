package codility.MaxCounters;
 
import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import codility.CodilitySolution;

public class 						TestMaxCounters 					
extends								CodilitySolution				{
	
    int res [];
	@Test
	public final void 				testExample						()	{ 
			
		res = invoke("solution", 5, new int [] {2,4,4,6,1,4,4});
		Logger.log(res);
		assertArrayEquals (new int [] {3,2,2,4,2}, res);
		
	}

}
