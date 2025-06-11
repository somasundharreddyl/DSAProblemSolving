class Solution {
    public int totalPaths(int m, int n, int[][] dp){
          if(m<0 || n<0){
            return 0;
          }
          if(m==0 && n==0){
            return 1;
          }
          if(dp[m][n]!=-1){return dp[m][n];}
          dp[m][n]=totalPaths(m-1,n,dp)+totalPaths(m,n-1,dp);
          return totalPaths(m-1,n,dp)+totalPaths(m,n-1,dp);

    }
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return totalPaths(m-1,n-1,dp);
    }
}