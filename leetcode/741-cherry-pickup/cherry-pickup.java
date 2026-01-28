class Solution {
    public int cherryPickup(int[][] grid) {
        int[][][] dp=new int[grid.length][grid[0].length][grid.length];
        for(int[][] arr:dp){
            for(int[] d:arr){
                Arrays.fill(d,-1);
            }
        }
        int ans=maxCherryPickup(grid,grid.length-1,grid[0].length-1,grid.length-1,dp);
        if(ans<0){
            return 0;
        }else{
            return ans;
        }
    }
    public int maxCherryPickup(int[][] grid,int x1,int y1,int x2,int[][][]dp){
         int y2=x1+y1-x2;
         if(x1<0 || x2<0 || y1<0 || y2<0 || grid[x1][y1]==-1 || grid[x2][y2]==-1){
            return Integer.MIN_VALUE;
         }
         if(x1==0 && x2==0 && y1==0 && y2==0){
            return grid[x1][y1];
         }
         if(dp[x1][y1][x2]!=-1){
            return dp[x1][y1][x2];
         }
         int a=maxCherryPickup(grid,x1-1,y1,x2-1,dp);
         int b=maxCherryPickup(grid,x1,y1-1,x2,dp);
         int c=maxCherryPickup(grid,x1-1,y1,x2,dp);
         int d=maxCherryPickup(grid,x1,y1-1,x2-1,dp);
         int contri=0;
         if(x1==x2 && y1==y2){
            contri=grid[x1][y1];
         }else{
            contri=grid[x1][y1]+grid[x2][y2];
         }
         dp[x1][y1][x2]=contri+Math.max(Math.max(a,b),Math.max(c,d));
         return contri+Math.max(Math.max(a,b),Math.max(c,d));
    }
}