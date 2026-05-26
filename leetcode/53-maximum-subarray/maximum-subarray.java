class Solution {
    public int maxSubArray(int[] nums) {
        int sum=0,maxSum=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
          sum+=nums[i]; 
          maxSum=maxSum>sum?maxSum:sum; 
          if(sum<0){
            sum=0;
          }
        }
        return maxSum;
    }
}