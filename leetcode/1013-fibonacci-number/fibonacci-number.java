class Solution {
    
    public int fib(int n) {
      int[] dp=new int[n+1];
      Arrays.fill(dp,-1);
      int ans=fibhelper(n,dp);
      return ans;
}

public int fibhelper(int n,int[] dp){
    if(n==0 || n==1){
        return n;
    }
    if(dp[n]!=-1){return dp[n];}
    int a=fibhelper(n-1,dp);
    int b=fibhelper(n-2,dp);
    dp[n]=a+b;
    return a+b;
}

}