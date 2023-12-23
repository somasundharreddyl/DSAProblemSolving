class Solution {
    public int maxSubArray(int[] nums) {
        int sum=0,ans=Integer.MIN_VALUE;
      for(int i=0;i<nums.length;i++){
           if(sum>=0){
          sum+=nums[i];
           }else{
          sum=nums[i];
           }

           ans=ans>sum?ans:sum;
      }
      return ans;
    }
}