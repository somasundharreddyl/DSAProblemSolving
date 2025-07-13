class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int[] parentA=new int[n+1];
        int[] parentB=new int[n+1];
        int count=0,countA=1,countB=1;
        int[] rankA=new int[n+1];
        int[] rankB=new int[n+1];
        for(int i=0;i<=n;i++){
          parentA[i]=parentB[i]=i;
          rankA[i]=rankB[i]=1;
        }
        Arrays.sort(edges,(a,b)->b[0]-a[0]);
        for(int i=0;i<edges.length;i++){
            int category=edges[i][0];
            int x=edges[i][1];
            int y=edges[i][2];
            if(category==3){
               boolean isUnionA=union(parentA,x,y,rankA);
               boolean isUnionB=union(parentB,x,y,rankB);
               if(!isUnionA && !isUnionB){
                count++;
               }
               if(isUnionA){countA++;}
               if(isUnionB){countB++;}
            }else if(category==2){
              boolean isUnionA=union(parentB,x,y,rankB);
              if(!isUnionA){
                 count++;
              }else{
                countA++;
              }
            }else{
              boolean isUnionB=union(parentA,x,y,rankA);
              if(!isUnionB){
                 count++;
              }else{
                countB++;
              }
            }  
        }
        if(countA!=n || countB!=n){
            return -1;
        }
        return count;
    }

    public boolean union(int[] parent,int x,int y,int[] rank){
       int ax=find(parent,x); 
       int by=find(parent,y);
       if(ax==by){
          return false;
       }
        if(rank[ax]>rank[by]){
               parent[by]=ax;
        }else if(rank[ax]<rank[by]){
                parent[ax]=by;
         }else{
                parent[ax]=by;
                rank[by]++;
         }
    return true;
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