class Solution {
    public int firstMissingPositive(int[] nums) {
        int i=0;
        while(i<nums.length){
            if(i+1!=nums[i] && nums[i]>=1 && nums[i]<=nums.length && nums[i]!=nums[nums[i]-1]){
                int temp=nums[nums[i]-1];
                nums[nums[i]-1]=nums[i];
                nums[i]=temp;
            }else{
                i++;
            }
        }
        for(int j=0;j<nums.length;j++){
            if(j+1!=nums[j]){
             return j+1;
            }
        }
        return nums.length+1;
    }
}
