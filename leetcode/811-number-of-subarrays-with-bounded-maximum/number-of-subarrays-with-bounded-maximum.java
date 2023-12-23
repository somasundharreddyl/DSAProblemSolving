class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int ans=0,previousvalidStartingPoints=0,lgri=0;
        for(int i=0;i<nums.length;i++){
        if(nums[i]>right){
        lgri=i+1;
        previousvalidStartingPoints=0;
        }
        else if(nums[i]>=left && nums[i]<=right){
          ans+=(i-lgri+1);
          previousvalidStartingPoints= i-lgri+1;
        }else{
            ans+=previousvalidStartingPoints;
        }
        }
        return ans;
    }
}