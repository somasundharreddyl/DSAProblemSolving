class Solution {
    public int firstMissingPositive(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            while(nums[i]>=1 && nums[i]<=n && (i+1)!=nums[i] && nums[i]!=nums[nums[i]-1]){
                int num=nums[i];
               int temp=nums[num-1];
               nums[num-1]=nums[i];
               nums[i]=temp;
            }   
        }
        for(int i=0;i<n;i++){
            if(i+1!=nums[i]){
                return i+1;
            }
        }
        return n+1;
    }
}