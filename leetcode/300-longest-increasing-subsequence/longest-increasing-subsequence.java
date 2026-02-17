class Solution {
    public int lengthOfLIS(int[] nums) {
       int[] dp=new int[nums.length];
       int ans=0;
       for(int i=0;i<nums.length;i++){
         int start=0,end=ans;
         while(start<end){
           int mid=start+(end-start)/2;
           if(dp[mid]<nums[i]){
            start=mid+1;
           }else{
            end=mid;
           }
         }
         dp[start]=nums[i];
         if(start==ans){ans++;}
       }
       return ans; 
    }
}