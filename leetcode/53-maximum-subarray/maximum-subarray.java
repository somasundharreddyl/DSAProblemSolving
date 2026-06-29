class Solution {
    public int maxSubArray(int[] nums) {
        int totalsum=Integer.MIN_VALUE,sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            totalsum=totalsum>sum?totalsum:sum;
            if(sum<0){
                sum=0;
            }
        }
       return totalsum;
    }
}