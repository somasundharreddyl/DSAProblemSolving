class Solution {
    public int maxDistToClosest(int[] seats) {
        int maxDist=1;    //2
        int occupyIdx=-1; //1
        for(int i=0;i<seats.length;i++){
            if(occupyIdx==-1 ){
                occupyIdx=i;
                continue;
            }
            if(seats[i]==1){
                if(occupyIdx==0 && seats[occupyIdx]==0){
                  int dist=(i-occupyIdx);
                  maxDist=maxDist>dist?maxDist:dist;  
                }else{
                  int dist=(i-occupyIdx)/2;
                maxDist=maxDist>dist?maxDist:dist; 
                }
                occupyIdx=i;
            }
            if(i==seats.length-1 && seats[i]==0){
                int dist=(i-occupyIdx);
                maxDist=maxDist>dist?maxDist:dist;
            }
        }
        return maxDist;
    }
}