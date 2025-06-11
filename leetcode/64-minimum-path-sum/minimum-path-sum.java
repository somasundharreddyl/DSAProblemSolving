class Solution {
    public int minPath(int[][] grid,int i, int j, int[][] dp){
        if(i<0 || j<0){
            return Integer.MAX_VALUE;
        }
        if(i==0 && j==0){
            return grid[i][j];
        }
        if(dp[i][j]!=-1){return dp[i][j];}
        int x=minPath(grid,i-1,j,dp);
        int y=minPath(grid,i,j-1,dp);
         dp[i][j]=Math.min(x,y)+grid[i][j];
         return Math.min(x,y)+grid[i][j];
    }
    public int minPathSum(int[][] grid) {
        int[][] dp=new int[grid.length][grid[0].length];
        for(int[] arr:dp){Arrays.fill(arr,-1);}
        return minPath(grid,grid.length-1,grid[0].length-1,dp);
    }
}