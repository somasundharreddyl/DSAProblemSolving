class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int count=0;
        int lgei=0;
        int validStartingPoints=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>right){
                lgei=i+1;
             validStartingPoints=0;
            }else if(nums[i]>=left && nums[i]<=right){
              validStartingPoints=i-lgei+1;
              count+=i-lgei+1;
            }else{
               count+=validStartingPoints;
            }
        }
        return count;
    }
}