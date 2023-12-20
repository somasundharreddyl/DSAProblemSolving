class Solution {
    public int pivotIndex(int[] nums) {
        int[] prefixSum=prefSum(nums);
        for(int i=0;i<nums.length;i++){
            int ls=0,rs=0;
        if(i!=0){
           ls=prefixSum[i-1];
        }
        if(i!=nums.length-1){
           rs=prefixSum[nums.length-1]-prefixSum[i];
        }
        if(ls==rs){
            return i;
        }
        }
        return -1;
    }
    public int[] prefSum(int[] nums){
        int[] ans=new int[nums.length];
        ans[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            ans[i]=nums[i]+ans[i-1];
        }
        return ans;
    } 
}