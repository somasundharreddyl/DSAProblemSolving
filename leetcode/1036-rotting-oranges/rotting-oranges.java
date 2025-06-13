class Solution {
    class Pair{
        int x;
        int y;
        int time;
        public Pair(int x, int y, int time){
            this.x=x;
            this.y=y;
            this.time=time;
        }
    }
    public int orangesRotting(int[][] grid) {
        int r=grid.length;
        int c=grid[0].length;
        int ans=0;
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==2){
                  Pair p=new Pair(i,j,0);
                  q.add(p);
                }
            }
        }
        while(q.size()>0){
            Pair remove=q.remove();
            int x=remove.x;
            int y=remove.y;
            int time=remove.time;
            ans=time;
            if(x-1>=0 && grid[x-1][y]==1){
                grid[x-1][y]=2;
                Pair pair=new Pair(x-1,y,time+1);
                q.add(pair);
            }
            if(x+1<r && grid[x+1][y]==1){
                grid[x+1][y]=2;
                Pair pair=new Pair(x+1,y,time+1);
                q.add(pair);
            }
            if(y-1>=0 && grid[x][y-1]==1){
                grid[x][y-1]=2;
                Pair pair=new Pair(x,y-1,time+1);
                q.add(pair);
            }
            if(y+1<c && grid[x][y+1]==1){
                grid[x][y+1]=2;
                Pair pair=new Pair(x,y+1,time+1);
                q.add(pair);
            }
        }
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==1){
                  return -1;
                }
            }
        }
        return ans;
    }
}