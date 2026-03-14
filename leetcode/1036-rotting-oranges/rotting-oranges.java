class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q=new LinkedList<>();
        int ans=0;
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                }
            }
        }
        while(q.size()>0){
            Pair rem=q.remove();
            int x=rem.x;
            int y=rem.y;
            int time=rem.time;
            ans=time;
            if(y-1>=0 && grid[x][y-1]==1){
                grid[x][y-1]=2;
                q.add(new Pair(x,y-1,time+1));
            }
            if(x-1>=0 && grid[x-1][y]==1){
                grid[x-1][y]=2;
                q.add(new Pair(x-1,y,time+1));
            }
            if(x+1<m && grid[x+1][y]==1){
                grid[x+1][y]=2;
                q.add(new Pair(x+1,y,time+1));
            }
            if(y+1<n && grid[x][y+1]==1){
                grid[x][y+1]=2;
                q.add(new Pair(x,y+1,time+1));
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return ans;
    }
}
class Pair{
    int x;
    int y;
    int time;
    public Pair(int x,int y,int time){
      this.x=x;
      this.y=y;
      this.time=time;
    }
}