class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,0);
        dp[0]=nums[0];
        int ans=1;
        for(int i=1;i<nums.length;i++){
           int low=0,high=ans;
           while(low<high){
            int mid=low+(high-low)/2;
            if(nums[i]>dp[mid]){
                low=mid+1;
            }else{
               high=mid; 
            }
           }
           dp[low]=nums[i];
           if(low==ans){ans++;}
        }
        return ans--;
    }
}
//[0,1,0,3,2,3]
//[1,1,1,1,1,1]
//[0,1,2,3,4,5]