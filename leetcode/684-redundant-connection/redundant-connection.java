class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        int[] arr=new int[n+1];
        int[] rank=new int[n+1];
        for(int i=0;i<=n;i++){
          arr[i]=i;
          rank[i]=1;
        }
        for(int i=0;i<n;i++){
          int x=edges[i][0];
          int y=edges[i][1];
         boolean isUnited=union(arr,rank,x,y);
         if(!isUnited){
            return edges[i];
         }
        }
        return new int[2];
    }

    public boolean union(int[] arr,int[] rank,int x,int y){
       int ax=find(arr,x);
       int by=find(arr,y);
        if(ax==by){
            return false;
        }
        if(rank[ax]>rank[by]){
            arr[by]=ax;
        }else if(rank[ax]<rank[by]){
            arr[ax]=by;
        }else{
            arr[ax]=by;
            rank[by]++;
        }
        return true;
    }

    public int find(int[] arr,int v){
      if(v==arr[v]){return v;}
      int temp=find(arr,arr[v]);
      arr[v]=temp;
      return temp;
    }
}