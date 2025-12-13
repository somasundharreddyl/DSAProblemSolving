class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int min=Integer.MIN_VALUE;
        int max=0;
        int ans=0;
        for(int i=0;i<weights.length;i++){
            min=min>weights[i]?min:weights[i];
            max+=weights[i];
        }
        while(min<=max){
            int mid=min+(max-min)/2;
            int countDays=countDays(weights,mid);
            if(countDays<=days){
                ans=mid;
                max=mid-1;
            }else{
                min=mid+1;   
            }
        }
        return ans;
    }
    public int countDays(int[] weights,int k){
        int count=1;
        int sum=0;
        for(int i=0;i<weights.length;i++){
            if(sum+weights[i]>k){
                sum=0;
                count++;
            }
            sum+=weights[i];
        }
        return count;
    }
}