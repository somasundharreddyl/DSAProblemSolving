class Solution {
     class Group{
        int i;
        int j;
        int time;
    }
    public int orangesRotting(int[][] grid) {
       Queue<Group> q=new LinkedList<>();
       for(int i=0;i<grid.length;i++) {
           for(int j=0;j<grid[0].length;j++){
               if(grid[i][j]==2){
               Group group=new Group();
               group.i=i;
               group.j=j;
               group.time=0;
               q.add(group);
               }
           }
       }
        int ans=0;
       while(q.size()>0){
           Group g=q.remove();
           int i=g.i;
           int j=g.j;
           int time=g.time;
           ans=time;

           if(i-1>=0 && grid[i-1][j]==1){
               grid[i-1][j]=2;
               Group group=new Group();
               group.i=i-1;
               group.j=j;
               group.time=time+1;
               q.add(group);
           }

            if(i+1<grid.length && grid[i+1][j]==1){
               grid[i+1][j]=2;
               Group group=new Group();
               group.i=i+1;
               group.j=j;
               group.time=time+1;
               q.add(group);
           }

            if(j-1>=0 && grid[i][j-1]==1){
               grid[i][j-1]=2;
               Group group=new Group();
               group.i=i;
               group.j=j-1;
               group.time=time+1;
               q.add(group);
           }

            if(j+1<grid[0].length && grid[i][j+1]==1){
               grid[i][j+1]=2;
               Group group=new Group();
               group.i=i;
               group.j=j+1;
               group.time=time+1;
               q.add(group);
           }
       }

       for(int i=0;i<grid.length;i++) {
           for(int j=0;j<grid[0].length;j++){
               if(grid[i][j]==1){
               return -1;
               }
           }
       }
      return ans;  
    }
}