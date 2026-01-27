class Solution {
    public int minPathSum(int[][] grid) {
      int[][] dp=new int[grid.length][grid[0].length];
      for(int[] arr:dp){
        Arrays.fill(arr,-1);
      }
      return minPathFinder(grid,dp,grid.length-1,grid[0].length-1); 
    }
    public int minPathFinder(int[][] grid,int[][] dp,int i, int j){
      if(i<0 || j<0){
        return Integer.MAX_VALUE;
      }  
      if(i==0 && j==0){
        return grid[i][j];
      }
      if(dp[i][j]!=-1){return dp[i][j];}
      int x=minPathFinder(grid,dp,i,j-1);
      int y=minPathFinder(grid,dp,i-1,j);
      dp[i][j]=Math.min(x,y)+grid[i][j];
      return Math.min(x,y)+grid[i][j];
    }
}