class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
       int dist=startFuel;
       int i=0;
       int ans=0;
       PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
       while(dist<target) {
        while(i<stations.length && stations[i][0]<=dist){
            pq.add(stations[i][1]);
            i++;
        }
         if(pq.size()==0){
            return -1;
         }
         dist+=pq.remove();
         ans++;
       }
       return ans;
    }
}