class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //ArrayList<Integer> ans=new ArrayList<>();
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        int[] indegree=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            int x=prerequisites[i][0];
            int y=prerequisites[i][1];
            graph.get(x).add(y);
            indegree[y]++;
        }
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
                //ans.add(i);
            }
        }
        while(q.size()>0){
            int rem=q.remove();
            List<Integer> list=graph.get(rem);
            for(int i=0;i<list.size();i++){
                indegree[list.get(i)]--;
                if(indegree[list.get(i)]==0){
                    q.add(list.get(i));
                   // ans.add(list.get(i));
                }
            }
        }
        for(int n:indegree){
            if(n!=0){
                return false;
            }
        }
        return true;
    }
}