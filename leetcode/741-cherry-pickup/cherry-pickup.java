class Solution {
    public int cherryPickup(int[][] grid) {
        int row1=grid.length,col1=grid[0].length,row2=grid.length;
        int[][][] dp=new int[row1][col1][row2];
        Arrays.stream(dp)
              .forEach(twoD -> Arrays.stream(twoD)
                                      .forEach(oneD -> Arrays.fill(oneD, -1)));
        int ans= cPu(grid,dp,row1-1,col1-1,row2-1);   
        if(ans<0){
            return 0;
        }else{
            return ans;
        }                          
    }

    public int cPu(int[][] grid,int[][][] dp,int row1,int col1,int row2){
        int col2=row1+col1-row2;
        if(row1<0 || row2<0 || col1<0 || col2<0 || grid[row1][col1]==-1 || grid[row2][col2]==-1){
            return Integer.MIN_VALUE;
        }
        if(row1==0&&col1==0&&row2==0&&col2==0){
            return grid[row1][col1];
        }
        if(dp[row1][col1][row2]!=-1){
            return dp[row1][col1][row2];
        }

        int a=cPu(grid,dp,row1-1,col1,row2-1);
        int b=cPu(grid,dp,row1,col1-1,row2);
        int c=cPu(grid,dp,row1-1,col1,row2);
        int d=cPu(grid,dp,row1,col1-1,row2-1);

       int max = Math.max(Math.max(Math.max(a, b), c), d);

       int rem=0;
       if(row1==row2 && col1==col2){
           rem=grid[row1][col1];
       }else{
           rem=grid[row1][col1]+grid[row2][col2];
       }

       dp[row1][col1][row2]=max+rem;
       return max+rem;
    }
}