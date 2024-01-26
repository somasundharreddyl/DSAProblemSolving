class Solution {
    public int findMin(int[] nums) {
        int low=0,high=nums.length-1;
        int minIndex=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]<=nums[high])
            {
              if(minIndex==-1 || nums[minIndex]>nums[mid])
              minIndex=mid;
              high=mid-1;
            }
            else
            {
             if(minIndex==-1 || nums[minIndex]>nums[low])
              minIndex=low;
              low=mid+1;
            }
        }
        return nums[minIndex];
    }
}