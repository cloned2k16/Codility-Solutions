package codility.CyclicRotation;

import net.yaoo.CodilityPlayaR;

       class                    Logger
       extends                  CodilityPlayaR                      {
       }

public class                    Solution                            {

    public int[]                brute                               ( int[] A, int K ) {
        if (A==null)            return A;                           // better safe than sorry

        int len     =   A.length;

        if (len == 0)           return A;

            K       =   K % len;                                    // make sure K falls into array

        int
            ror     =   (len-K) % len                               // mirror value to rotate right
        ,   rslt[]  =   new int[len]
        ;

        for (int i=0; i<len; i++) rslt[i]=A[(ror++)%len];
        return rslt;
    }


    public int[]                solution                            ( int[] A, int K ) {
        if (A==null)            return A;                           // better safe than sorry

        int len     =   A.length;
        if (len == 0)           return A;
            K       =   K % len;                                    // make sure K falls into array
        int ror     =   (len-K) % len;                              // mirror value to rotate right

        if (ror<=0)             return A;                           // nothing to do!

        int
            i
        ,   ii
        ,   tmp
        ,   ofs     = 0
        ,   cnt     = len
        ;

        while (0 < cnt) {
            i   = ofs;
            tmp = A[i];                                             // save first
            do {
             ii = (i + ror) % len;                                  // point to new value
             if (ii==ofs) break;                                    // until not entering loop (on even length input array)
             A[i] = A[ii];                                          // move to new place
             i = ii;                                                // swap index
             --cnt;
            }
            while (true);                                           // would be better use ( 0 < cnt ) to keep it safe
            A[i]=tmp;                                               // store first value
            --cnt;
            ofs++;                                                  // jump to next start
        }
        return A;
    }

}
