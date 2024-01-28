class Solution {

    private static int[] prefixSum(int[] nums){
        int[] ans=new int[nums.length];
        ans[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            ans[i]=ans[i-1]+nums[i];
        }
        return ans;
    }

    public int pivotIndex(int[] nums) {
       int[] prefSum=prefixSum(nums); 
       if(prefSum[nums.length-1]-prefSum[0]==0){
           return 0;
       }
       for(int i=1;i<nums.length-1;i++){
           if(prefSum[i-1]==(prefSum[nums.length-1]-prefSum[i])){
               return i;
           }
       }
       if(prefSum[nums.length-2]==0){
           return nums.length-1; 
       }
       
       return -1;
    }
}
