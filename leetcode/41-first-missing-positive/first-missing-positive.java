class Solution {
    public int firstMissingPositive(int[] nums) {
        int min=1;
        int max=nums.length;
        int n=nums.length;
        for(int i=0;i<n;i++){
            while(nums[i]>=min && nums[i]<=max && nums[i]!=(i+1) && nums[i]!=nums[nums[i]-1]){
                int temp=nums[i]; 
                nums[i]=nums[temp-1];
                nums[temp-1]=temp;
            }
        }
        for(int i=0;i<n;i++){
            if((i+1)!=nums[i]){
                return i+1;
            }
        }
        return max+1;
    }
}