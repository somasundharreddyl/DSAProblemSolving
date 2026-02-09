class Solution {
    public int minPathSum(int[][] grid) {
       int[][] dp=new int[grid.length][grid[0].length];
       for(int[] d:dp){
        Arrays.fill(d,-1);
       } 
       return minimumPathFinder(grid,dp,grid.length-1,grid[0].length-1);
    }

    public int minimumPathFinder(int[][] grid,int[][] dp,int i,int j){
        if(i<0 || j<0){return Integer.MAX_VALUE;}
        if(i==0 && j==0){return grid[i][j];}
        if(dp[i][j]!=-1){return dp[i][j];}
        int x=minimumPathFinder(grid,dp,i-1,j);
        int y=minimumPathFinder(grid,dp,i,j-1);
        dp[i][j]=Math.min(x,y)+grid[i][j];
        return Math.min(x,y)+grid[i][j];
    }
}