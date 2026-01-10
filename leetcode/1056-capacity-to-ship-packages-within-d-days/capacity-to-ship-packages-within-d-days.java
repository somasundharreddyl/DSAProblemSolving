class Solution {
    public int shipWithinDays(int[] weights, int days) {
       int min=Integer.MIN_VALUE;
       int max=0;
       int ans=-1;
       for(int i=0;i<weights.length;i++){
        max+=weights[i];
        min=min<weights[i]?weights[i]:min;
       }
       while(min<=max){
         int mid=min+(max-min)/2;
        int d=countDays(mid,weights);
        if(d<=days){
          ans=mid;
          max=mid-1;
        }else{
            min=mid+1;
        }
       }
       return ans;
    }
    public int countDays(int mid,int[] weights){
       int sum=0,count=1;
       for(int i=0;i<weights.length;i++){
         if(sum+weights[i]>mid){
            count++;
            sum=0;
         }
         sum+=weights[i];
       }
       return count;
    }
}