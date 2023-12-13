class Solution {

    public int totalways(int[][] dp,int i,int j){

        if(i<0 || j<0){
            return 0;
        }
        if(i==0&&j==0){
            return 1;
        }
        if(dp[i][j]!=-1){return dp[i][j];}
    
    int a=totalways(dp,i-1,j);
    int b=totalways(dp,i,j-1);

    dp[i][j]=a+b;
    return a+b;

    }

    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
         for(int i=0;i<m;i++){
             Arrays.fill(dp[i],-1);
         }
        int ans=totalways(dp,m-1,n-1);
        return ans;
    }
}