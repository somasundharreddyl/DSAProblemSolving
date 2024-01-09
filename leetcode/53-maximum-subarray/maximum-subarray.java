class Solution {
    public int maxSubArray(int[] nums) {
       int overAllMaxSum=nums[0],maxSum=nums[0];
       for(int i=1;i<nums.length;i++){
         if(maxSum<=0){
             maxSum=nums[i];
         }else{
             maxSum+=nums[i];
         }
         overAllMaxSum=overAllMaxSum>maxSum?overAllMaxSum:maxSum;
       }
       return overAllMaxSum;
    }
}