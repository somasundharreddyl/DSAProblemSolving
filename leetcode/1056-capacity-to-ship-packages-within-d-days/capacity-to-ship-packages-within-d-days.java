class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max=0,min=Integer.MIN_VALUE,ans=-1;
        for(int i=0;i<weights.length;i++){
            max+=weights[i];
            min=min>weights[i]?min:weights[i];
        }
        while(min<=max){
            int mid=min+(max-min)/2;
            int count=1,sum=0;
            for(int i=0;i<weights.length;i++){
                if(sum+weights[i]>mid){
                 count++;
                 sum=0;
                }
                sum=sum+weights[i];
            }
            if(count<=days){
                ans=mid;
                max=mid-1;         
            }else{
               min=mid+1;    
            }
        }
        return ans;
    }
}