class Solution {
    public int[] runningSum(int[] nums) {
       int ans[]=new int[nums.length];
       ans[0]=nums[0];
       int sum=nums[0];
       for(int i=1;i<nums.length;i++){
         ans[i]=nums[i]+sum;
         sum=ans[i];
       }
       return ans;
    }
}