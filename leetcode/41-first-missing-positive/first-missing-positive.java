class Solution {
    public int firstMissingPositive(int[] nums) {
        int i=0;
        while(i<nums.length){
            if((nums[i]>0 && nums[i]<=nums.length) && (nums[i]-1)!=i){
              int idx=nums[i]-1;
              if(nums[i]==nums[idx]){i++;}
              else{
              int temp=nums[i];
              nums[i]=nums[idx];
              nums[idx]=temp;
              }
            }
            else{
                i++;
            }
        }
        for(int j=0;j<nums.length;j++){
            if(nums[j]-1!=j){
                return j+1;
            }
        }
        return nums.length+1;
    }
}