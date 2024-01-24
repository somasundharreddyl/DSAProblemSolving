class Solution {
    public int shipWithinDays(int[] weights, int days) {
       int low=Integer.MIN_VALUE, high=0,ans=0; 
       for(int i=0;i<weights.length;i++){
           low=low>weights[i]?low:weights[i];
           high+=weights[i];
       }
       while(low<=high){
           int mid=low+(high-low)/2;
           int count=1,sum=0;
           for(int i=0;i<weights.length;i++){
               if(sum+weights[i]<=mid){
                sum+=weights[i];
               }else{
                 count++;
                 sum=weights[i];
               }
           }
           if(count>days){
              low=mid+1;  
           }
           else{
               high=mid-1;
           }
       }
       return low;
    }
}