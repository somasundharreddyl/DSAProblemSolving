class Solution {
    public int maxDistToClosest(int[] seats) {
       int dist=Integer.MIN_VALUE,k=-1;
        for(int i=0;i<seats.length;i++){
            if(seats[i]==1){
             if(k==-1){
                 dist=dist>i?dist:i;
             }
             else {
                dist=dist>((i-k)/2)?dist:((i-k)/2); 
             }
             k=i;
            }
        }
     return  dist=dist>(seats.length-1-k)?dist:(seats.length-1-k); 
    }
}