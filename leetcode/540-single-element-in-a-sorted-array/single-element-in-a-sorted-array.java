class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int start=0,end=nums.length-1;
        while(start<=end){
           int mid=start+(end-start)/2;
           if((mid!=0 && mid!=nums.length-1 && 
           nums[mid]!=nums[mid+1] && nums[mid]!=nums[mid-1]) || (mid==0 && nums[mid]!=nums[mid+1]) ||
           (mid==nums.length-1 && nums[mid]!=nums[mid-1])){
             return nums[mid];
           }else if((mid!=nums.length-1 && mid%2==0 && nums[mid]!=nums[mid+1]) 
           || (mid!=0 && mid%2==1 && nums[mid]!=nums[mid-1])){
            end=mid-1;
           }else{
            start=mid+1;
           }
        }
        return -1;
    }
}