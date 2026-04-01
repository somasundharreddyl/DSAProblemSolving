class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int[] represents=new int[n];
        int[] alternatives=new int[n];
        List<List<Integer>> graphs=new ArrayList<>();
        for(int i=0;i<n;i++){
            graphs.add(new ArrayList<>());
        }
        for(List<Integer> connection:connections){
            graphs.get(connection.get(0)).add(connection.get(1));
            graphs.get(connection.get(1)).add(connection.get(0));
        }
        int src=0,parent=-1,count=0;
        List<List<Integer>> ans=new ArrayList<>();
        boolean[] isVisited=new boolean[n];
        findCriticalConnections(graphs,represents,alternatives,src,parent,ans,isVisited,count);
        return ans;
    }
    public void findCriticalConnections(List<List<Integer>> graphs,int[] represents,int[] alternatives,
    int src,int parent,List<List<Integer>> ans, boolean[] isVisited,int count){
        represents[src]=count;
        alternatives[src]=count;
        count++;
        
        for(int vt:graphs.get(src)){
            if(vt==parent){
                continue;
            }else if(!isVisited[vt]){
               isVisited[vt]=true;
               findCriticalConnections(graphs,represents,alternatives,vt,src,ans,isVisited,count);
               alternatives[src]=Math.min(alternatives[src],alternatives[vt]);
               if(alternatives[vt]>represents[src]){
                List<Integer> l=new ArrayList<>();
                l.add(src);
                l.add(vt);
                ans.add(l);
               }
            }else{
              alternatives[src]=Math.min(alternatives[src],represents[vt]);
            }
        }
    }
}