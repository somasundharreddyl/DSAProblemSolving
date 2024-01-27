class Solution {
    public int findMin(int[] nums) {
        int low=0,high=nums.length-1,minIndex=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==nums[low]&&nums[mid]==nums[high]){
                low++;
                high--;
                if(minIndex==-1 || nums[mid]<nums[minIndex]){
                 minIndex=mid;  
                }
            }else if(nums[mid]<=nums[high]){
                if(minIndex==-1 || nums[mid]<nums[minIndex]){
                 minIndex=mid;
                }
                high=mid-1;
            }else{
                if(minIndex==-1 || nums[low]<nums[minIndex]){
                    minIndex=low;
                }
                low=mid+1;
            }
        }
        return nums[minIndex];
    }
}