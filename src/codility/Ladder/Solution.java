package codility.Ladder;

import net.yaoo.CodilityPlayaR;

class                           Logger
extends                         CodilityPlayaR                      {
}

public class                    Solution                            {

    private final static int    []  fib     = new int   [32768];
    private final static int    []  empty   = new int   [] {};

    static {                                                            // build Fibonacci cache
        fib[0]=0;
        fib[1]=1;
        for (int i=2; i<fib.length; i++)  {
            fib [i] = (int)(((long)fib[i-2]+fib[i-1]) % ((long)1<<31));
        }
    }

    public int[]                solution                            (int [] A, int [] B) {
        if (null == A || null == B)                                 return empty;

        int len     = A.length;

        if (len != B.length)                                        return empty;

        int [] res = new int [len];

        for (int i=0; i < len; i++) res[i] = fib[A[i]+1] % (1 << B[i]);

        return res;
    }

}
