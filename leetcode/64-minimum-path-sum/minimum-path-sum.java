class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return shortPath(grid,dp,m-1,n-1);
    }

    public int shortPath(int[][] grid,int[][] dp,int i,int j){
        if(i<0 || j<0){return Integer.MAX_VALUE;}
        if(i==0 && j==0){return grid[i][j];}
        if(dp[i][j]!=-1){return dp[i][j];}

        int a=shortPath(grid,dp,i-1,j);
        int b=shortPath(grid,dp,i,j-1);

        int min=a>b?b:a;
        
        dp[i][j]=min+grid[i][j];
        return min+grid[i][j];
    }
}