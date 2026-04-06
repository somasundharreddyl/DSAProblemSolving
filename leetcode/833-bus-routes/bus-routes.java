class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        Map<Integer,List<Integer>> busStops=new HashMap<>();
        int ans=-1;
        for(int i=0;i<routes.length;i++){
            for(int j=0;j<routes[i].length;j++){
                if(busStops.containsKey(routes[i][j])){
                   busStops.get(routes[i][j]).add(i);
                }else{
                    List<Integer> val=new ArrayList<>();
                    val.add(i);
                   busStops.put(routes[i][j],val); 
                } 
            }
        }
        Queue<Pair> q=new LinkedList<>();
        Set<Integer> busStopSet=new HashSet<>();
        Set<Integer> busSet=new HashSet<>();
        q.add(new Pair(source,0));
        busStopSet.add(source);
        while(q.size()>0){
            Pair rem=q.remove();
            if(rem.stopNo==target){return rem.busCount;}
            if(busStops.get(rem.stopNo)!=null){
            for(int bus:busStops.get(rem.stopNo)){
                if(!busSet.contains(bus)){
                   busSet.add(bus);
                   for(int stop:routes[bus]){
                    if(!busStopSet.contains(stop)){
                      busStopSet.add(stop);
                      q.add(new Pair(stop,rem.busCount+1));
                    }
                   }   
                }
            }
        }
        }
        return ans;
    }
}
class Pair{
    int stopNo;
    int busCount;
    public Pair(int stopNo,int busCount){
        this.stopNo=stopNo;
        this.busCount=busCount;
    }
}