class Solution {

    public int fibonacci(int n, int[] dp){
        if(n==0 || n==1){
            return n;
        }
        if(dp[n]!=-1){return dp[n];}
        int x=fibonacci(n-1,dp);
        int y=fibonacci(n-2,dp);
        dp[n]=x+y;
        return x+y;
    }
    public int fib(int n) {
       int[] dp=new int[n+1];
       Arrays.fill(dp,-1);
       return fibonacci(n,dp); 
    }
}