class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        int[] ans=new int[2];
        int[] parent=new int[n+1];
        int[] rank=new int[n+1];
        for(int i=0;i<=n;i++){
          parent[i]=i;
          rank[i]=1;
        }
        for(int i=0;i<n;i++){
            int u=edges[i][0];
            int v=edges[i][1];
          boolean isUnited=union(parent,rank,u,v);
          if(!isUnited){
            ans[0]=u;
            ans[1]=v;
          }
        }
        return ans;
    }
    public boolean union(int[] parent,int[] rank,int u,int v){
        u=findParent(parent,u);
        v=findParent(parent,v);
        if(u==v){
            return false;
        }
        if(rank[u]>rank[v]){
            parent[v]=u;
        }else if(rank[u]<rank[v]){
            parent[u]=v;
        }else{
            parent[v]=u;
            rank[u]++;
        }
        return true;
    }

    public int findParent(int[] parent, int k){
       if(parent[k]==k){
        return k;
       }
       int temp=findParent(parent,parent[k]);
       parent[k]=temp;
       return temp;
    }
}