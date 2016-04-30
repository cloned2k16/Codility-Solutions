var yourself = {
    fibonacci : function(n) {
        if (n<2)        return n;
        var fib=[0,1];
        var i=2;
        for (;i<=n;i++) fib[i]=fib[i-2]+fib[i-1];
        return fib[n];
    }
};