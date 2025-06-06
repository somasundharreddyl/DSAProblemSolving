class Solution {
    public int search(int[] nums, int target) {
        int low=0,high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(target==nums[mid]){
                return mid;
            }
            else if(nums[mid]<=nums[high]){
             if(nums[mid]<=target && nums[high]>=target){
               low=mid+1;
             } else{
                 high=mid-1;
             }
            }else{
              if(target<=nums[mid]&&target>=nums[low]){
              high=mid-1;
              }else{
                  low=mid+1;
              }
            }
        }
        return -1;
    }
}