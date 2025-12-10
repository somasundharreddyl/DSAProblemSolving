class Solution {
    public int shipWithinDays(int[] weights, int days) {
     int start=0,end=0;
     int ans=0;
     for(int i=0;i<weights.length;i++){
        start=Math.max(weights[i],start);
        end+=weights[i];
     }  
     while(start<=end){
        int mid=start+(end-start)/2;
        int estimationDays=calculateDays(weights,mid);
        if(estimationDays<=days){
            ans=mid;
            end=mid-1;
        }else{
           start=mid+1;
     }
     }
     return ans;
}
public int calculateDays(int[] weights,int weight){
  int weightSum=0;
  int dayCount=1;
  for(int i=0;i<weights.length;i++){
    if(weightSum+weights[i]>weight){
        weightSum=0;
        dayCount++;
    }
        weightSum+=weights[i];
    
  }
  return dayCount;
}
}