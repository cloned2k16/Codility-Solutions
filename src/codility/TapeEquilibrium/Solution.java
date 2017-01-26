package codility.TapeEquilibrium;

import net.yaoo.CodilityPlayaR;

public class                    Solution                            {
       class                    Logger
       extends                  CodilityPlayaR                      {
       }

    public int                  solution                            ( int[] A )                     {
        if (null == A) return 0;                                    // better safe than sorry

        int     res
        ,       len     =   A.length
        ,       sum []  = new int [len]
        ,       total   = 0
        ,       total_lo= 0
        ,       total_hi= 0
        ;

        res = Integer.MAX_VALUE;                                    // not found

        switch (len){
            case 0 : return 0;                                      // is undefined but we can easily safely assume 0
            case 1 : return 0;                                      // is undefined and it can be anything 0 ? A[0] ? infinite ?
            default: {
                for (int i=0; i<len; i++) {
                    total+=A[i];
                    sum[i]=total;
                }

                total_hi = total;
                for (int i=0; i<(len-1); i++) {
                    int k=A[i];
                    total_lo    +=k;
                    total_hi    -=k;
                    k       =Math.abs(total_hi-total_lo);
                    //Logger.log("'%d - %d = %d",total_lo,total_hi,k);
                    res = (k < res) ? k : res;

                }
            }
            return res;
        }

    }

}
