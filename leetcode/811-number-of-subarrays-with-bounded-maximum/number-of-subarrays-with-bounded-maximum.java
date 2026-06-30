class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int count=0,validStartPoints=0,idx=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>right){
                validStartPoints=0;
                idx=i;
            }else if(nums[i]>=left && nums[i]<=right){
                validStartPoints=i-idx;
                count+=validStartPoints;
            }else{
                count+=validStartPoints;
            }
        }
        return count;
    }
}