package codility.BinaryGap;

	// you can also use imports, for example:
	// import java.util.*;

	// you can write to stdout for debugging purposes, e.g.
	// System.out.println("this is a debug message");

	public class Solution {
	    
		public int solution		(int N) 							{
	        int mask    =   0x80000000
	        ,   gap     =   0
	        ,   currGap =  -1
	        ;
	        
	        for (int i = 0; i < 32; i++) {                  // loop through all bits because it is safer
	                                                        // than a while loop ..
	            int hit = N & mask;
	            if (0 == hit) {                             
	                if (currGap>=0) currGap++;              // 0 and already hit 1
	            }    
	            else {
	              gap = (gap >= currGap) ? gap : currGap;   // if current gap > gap use it
	              currGap = 0;                              // reset currGap
	            }    
	            if (0 == (N & mask-1)) break;               // we are done!
	            mask>>>=1;
	        }    
	        return gap;
	    }
		
		public int solution_org	(int N)								{
			int 	loMask	= 0x00000001
			,		enMask	= 0xFFFFFFFF
			, 		gap		= 0
			,		currGap	= -1
			;
					 
			for (int i = 0; i < 32; i++) {					// loop through all bits because it is safer
															// than a while loop ..
				if (0==(N & enMask)) break; 				// we are done!
				int hit = N & loMask;  
		  		if (0 == hit) {  
		  			if (currGap>=0) currGap++; 				// 0 and already hit 1
		  		}
				else {
				  gap = gap>currGap ? gap : currGap;  		// if current gap > gap use it
				  currGap=0;                          		// reset count 
				}

		  		loMask<<=1;
				enMask<<=1;
			}
				 
			return gap;
		}
	};
