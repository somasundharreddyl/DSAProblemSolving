class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        int[] arr=new int[n];
        int[] rank=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=i;
            rank[i]=1;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1){
                    int x=i;
                    int y=j;
                    union(arr,rank,x,y);
                }
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
           if(arr[i]==i){
            count++;
           }
        }
        return count;
    }
    public void union(int[] arr,int[] rank,int x,int y){
          int ax=find(arr,x);
          int by=find(arr,y);
          if(arr[ax]!=arr[by]){
            if(rank[ax]>rank[by]){
               arr[by]=ax;
            }else if(rank[ax]<rank[by]){
                arr[ax]=by;
            }else{
                arr[ax]=by;
                rank[by]++;
            }
          }
    }
    public int find(int[] arr,int idx){
          if(arr[idx]==idx){
            return idx;
          }
          int temp=find(arr,arr[idx]);
          arr[idx]=temp;
          return temp;
    }
}