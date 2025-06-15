class Solution {
    public int maxDistToClosest(int[] seats) {
        int start=-1,end=-1,maxIndex=-1,maxDist=-1;
        for(int i=0;i<seats.length;i++){
            if(i==0 && (seats[i]==0 || seats[i]==1)){
                start=i;
            }else if(seats[i]==1 || (i==seats.length-1 && (seats[i]==0 || seats[i]==1))){
                if((i==seats.length-1 && seats[i]==0) || (start==0 && seats[start]==0)){
                 int dist=(i-start);
                 int index=i; 
                 if(dist>maxDist){
                    maxDist=dist;
                    maxIndex=index;
                 }
                }else{
                 int dist=(i-start)/2;
                 int index=(i+start)/2;
                 if(dist>maxDist){
                    maxDist=dist;
                    maxIndex=index;
                 }
                }
                 start=i;
            }
        }
        return maxDist;
    }
}