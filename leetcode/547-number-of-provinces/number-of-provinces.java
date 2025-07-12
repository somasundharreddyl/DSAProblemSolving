class Solution {
    public int findCircleNum(int[][] isConnected) {
        int len=isConnected.length;
        int wid=isConnected[0].length;
        int[] arr=new int[len];
        int[] rank=new int[len];
        for(int i=0;i<len;i++){
            arr[i]=i;
            rank[i]=1;
        }
        for(int i=0;i<len;i++){
            for(int j=0;j<wid;j++){
                if(isConnected[i][j]==1){
                    int x=i;
                    int y=j;
                    while(arr[x]!=x){
                        x=arr[x];
                    }
                    while(arr[y]!=y){
                        y=arr[y];
                    }
                     if(rank[x] > rank[y]) { 
                        arr[y] = x; 
                    } else if(rank[x] < rank[y]){ 
                        arr[x] = y; 
                    } else { 
                        arr[x] = y; 
                        rank[y]++; 
                    }
                }
            }
        }
        int count=0;
        for(int i=0;i<len;i++){
            if(arr[i]==i){
                count++;
            }
        }
        return count;
    }
}