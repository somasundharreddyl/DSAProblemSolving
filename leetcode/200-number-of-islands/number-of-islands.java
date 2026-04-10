class Solution {
    public int numIslands(char[][] grid) {
        int islands=0;
        int rows=grid.length;
        int cols=grid[0].length;
        int[][] dirs=new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]=='1'){
                    grid[i][j]='0';
                    dfs(i,j,grid,dirs);
                    islands++;
                }
            }
        }
        return islands;
    }
    public void dfs(int i, int j, char[][] grid,int[][] dirs){
        for(int k=0;k<dirs.length;k++){
            int x=i+dirs[k][0];
            int y=j+dirs[k][1];
            if(x>=0 && x<grid.length && y>=0 && y<grid[0].length && grid[x][y]=='1'){
                grid[x][y]='0';
              dfs(x,y,grid,dirs);
            }
        }
    }
}