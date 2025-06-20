class Solution {
    public int findMin(int[] nums) {
        int low=0,high=nums.length-1,ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(low!=mid && mid!=high && nums[mid]==nums[low] && nums[high]==nums[mid]){
                low++;
                high--;
            }else if(nums[mid]<=nums[high]){
                if(ans==-1 || nums[mid]<nums[ans]){
                    ans=mid;
                }
                high=mid-1;
            }else{
                if(ans==-1 || nums[low]<nums[ans]){
                    ans=low;
                }
                 low=mid+1;
            }
        }
        return nums[ans];
    }
}