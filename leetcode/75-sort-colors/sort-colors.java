class Solution {
    public void sortColors(int[] nums) {
        int zeroIdx=0,twoIdx=nums.length-1,idx=0;
        while(idx<=twoIdx){
            if(nums[idx]==0){
                int temp=nums[idx];
                nums[idx]=nums[zeroIdx];
                nums[zeroIdx]=temp;
                idx++;
                zeroIdx++;
            }else if(nums[idx]==2){
                 int temp=nums[idx];
                nums[idx]=nums[twoIdx];
                nums[twoIdx]=temp;
                twoIdx--;
            }else{
                idx++;
            }
        }
    }
}