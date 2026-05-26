class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int size=nums.length;
        int max=Integer.MIN_VALUE;
        int total=0,validstartingPoints=0,lgei=-1;
        for(int i=0;i<size;i++){
            if(nums[i]>right){
                lgei=i;
                validstartingPoints=0;
            }else if(nums[i]>=left && nums[i]<=right){
                validstartingPoints=i-lgei;
                total+=validstartingPoints;
            }else{
                total+=validstartingPoints;
            }
        }
        return total;
    }
}