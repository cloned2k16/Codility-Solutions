package codility.BinaryGap;

	

	public class Solution {
	    
		public int solution		(int N) 							{ 	// this was aprox. 25% faster than looping the other way around 
	        int mask    =   0x80000000									// with the latest optimization it reach %38 increase in performances
	        ,   gap     =   0
	        ,   currGap =  -1
	        ;
	        
	        if (0==	(N & 0xFFFF0000))   N<<=16;							// drastically reduce loops by just adding this two lines
//            if (0== (N & 0xFF000000))	N<<= 8;							// Although seemingly paradoxical but this further optimization, 
	        															// will produce slower overall performances 
            															// (actually is logical (statistically) :D)
            															// it would only be better to have it, when you use just small numbers as input			
            
	        for (int i = 0; i < 32; i++) {                  			// loop through all bits because it is safer
	                                                        			// than a while loop ..
	            if (0 == (N & mask)) {                             
	              currGap= (currGap>=0)? currGap+1:currGap;				// 0 and already hit 1
	            }    
	            else {
	              gap= (currGap > gap)?  currGap : gap; 				// if current gap > gap use it
	              currGap = 0;                              			// reset currGap
	            }    
	            if (0 == (N & mask-1)) break;               			// we are done!
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
