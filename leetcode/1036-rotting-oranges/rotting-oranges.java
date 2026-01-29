class Solution {
    public int orangesRotting(int[][] grid) {
        int ans=0;
      Queue<Pair> q=new LinkedList<>();
      for(int i=0;i<grid.length;i++){
        for(int j=0;j<grid[0].length;j++){
            if(grid[i][j]==2){
                q.add(new Pair(i,j,0));
            }
        }
      }
      while(q.size()>0){
        Pair pair=q.remove();
        int i=pair.i;
        int j=pair.j;
        int t=pair.t;
        ans=t;
        if(i-1>=0 && grid[i-1][j]==1){
            grid[i-1][j]=2;
            q.add(new Pair(i-1,j,t+1));
        }
        if(j-1>=0 && grid[i][j-1]==1){
            grid[i][j-1]=2;
            q.add(new Pair(i,j-1,t+1));
        }
        if(i+1<grid.length && grid[i+1][j]==1){
            grid[i+1][j]=2;
            q.add(new Pair(i+1,j,t+1));
        }
        if(j+1<grid[0].length && grid[i][j+1]==1){
            grid[i][j+1]=2;
            q.add(new Pair(i,j+1,t+1));
        }
      } 
     for(int i=0;i<grid.length;i++){
        for(int j=0;j<grid[0].length;j++){
            if(grid[i][j]==1){
                return -1;
            }
        }
      }
      return ans;  
    }
}
class Pair{
    int i;
    int j;
    int t;
    public Pair(int i,int j,int t){
        this.i=i;
        this.j=j;
        this.t=t;
    }
}