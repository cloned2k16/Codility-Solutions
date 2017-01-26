package codility.PermCheck;


import net.yaoo.CodilityPlayaR;

public class                    Solution {
       class                    Logger
       extends                  CodilityPlayaR                      {
       }

       public int               solution(int[] A)                   {
            if (null == A)                                          return 0;
            int     len     =   A.length
            ,       bmp []  =   new int [len]
            ;

            for (int i=0; i < len ; i++) {
                int v = A[i] -1;                                // zero-indexed
                if (0 > v || v >= len)              return 0;   // falling outside range
                if (0!=bmp[v])                      return 0;   // duplicated value
                bmp[v] = 1;                                     // first hit
            }

            return 1;
       }


}
