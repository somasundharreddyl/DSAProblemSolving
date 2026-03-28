class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int count=0;
        int[] parentA=new int[n];
        int[] parentB=new int[n];
        int[] rankA=new int[n];
        int[] rankB=new int[n];
        for(int i=0;i<n;i++){
            parentA[i]=i;
            parentB[i]=i;
            rankA[i]=1;
            rankB[i]=1;
        }
       Arrays.sort(edges,(a,b)->b[0]-a[0]);
        for(int i=0;i<edges.length;i++){
            int type=edges[i][0];
            int u=edges[i][1];
            int v=edges[i][2];
            if(type==3){
             boolean isUnionedA=union(parentA,rankA,u-1,v-1);
             boolean isUnionedB=union(parentB,rankB,u-1,v-1);
             if(!isUnionedA && !isUnionedB ){
                count++;
             } 
            }else if(type==2){
             boolean isUnionedB=union(parentB,rankB,u-1,v-1);
             if(!isUnionedB){
                count++;
             }
            }else{
             boolean isUnionedA=union(parentA,rankA,u-1,v-1);
             if(!isUnionedA){
                count++;
             }
            }
        }
        int countA=0,countB=0;
            for(int i=0;i<n;i++){
                if(parentA[i]==i){
                    countA++;
                }
                if(parentB[i]==i){
                    countB++;
                }
            }
        
       if(countA>1 || countB>1){
        return -1;
       }else{
        return count;
       }
    }
    public boolean union(int[] parent,int[] rank, int u, int v){
        u=findParent(u,parent);
        v=findParent(v,parent);
        if(u==v){
            return false;
        }
        if(rank[u]>rank[v]){
            parent[v]=u;
        }else if(rank[u]<rank[v]){
            parent[u]=v;
        }else{
            parent[u]=v;
            rank[v]++;
        }
        return true;
    }

    public int findParent(int k, int[] parent){
       if(k==parent[k]){
        return k;
       }
       int temp=findParent(parent[k],parent);
       parent[k]=temp;
       return temp;
    }
}