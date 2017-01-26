package codility.MaxCounters;

public class                    Solution                            {

    public int[]                solution                            (int N, int[] A)                {
        int res []  = new int [N]
        ,   max     = 0
        ,   len     = A.length
        ;

        for ( int i=0; i <len ; i++) {
            int idx = A[i];
            if (1<= idx && idx <= N) {
                int v = res[idx-1] +1;
                max = v > max ? v : max;
                res[idx-1]=v;
            }
            else if ( idx == N+1) {
                for (int k=0 ; k < N; k++) res[k] = max;
            }
            else { // WTF ?

            }
        }

        return res;
    }
}
