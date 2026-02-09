class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        return uniquePaths(m-1,n-1,dp);
    }
    public int uniquePaths(int m,int n,int[][] dp){
        if(m==0 || n==0){return 1;}
        if(dp[m][n]!=-1){return dp[m][n];}
        int x=uniquePaths(m-1,n,dp);
        int y=uniquePaths(m,n-1,dp);
        dp[m][n]=x+y;
        return x+y;
    }
}