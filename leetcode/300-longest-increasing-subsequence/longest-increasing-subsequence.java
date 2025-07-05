class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,1);
        int max=0;
        for(int i=1;i<dp.length;i++){
           int j=i-1;
           while(j>=0){
            if(nums[i]>nums[j]){
            dp[i]=dp[i]>(1+dp[j])?dp[i]:(1+dp[j]);
            }
            j--;
           }
        }
        for(int n:dp){
           max=max>n?max:n;
        }
        return max;
    }
}
//[0,1,0,3,2,3]
//[1,1,1,1,1,1]
//[0,1,2,3,4,5]