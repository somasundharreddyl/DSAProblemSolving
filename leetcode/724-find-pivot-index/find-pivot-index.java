class Solution {
    public int pivotIndex(int[] nums) {
        int[] prefixSum=new int[nums.length];
        prefixSum[0]=nums[0];
        for(int i=1;i<nums.length;i++){
        prefixSum[i]=prefixSum[i-1]+nums[i];
        }
        for(int i=0;i<nums.length;i++){
            if(i==0){
                int left=0;
                int right=prefixSum[nums.length-1]-prefixSum[i];
              if(left == right){
                return i;
              }
            }else if(i==nums.length-1){
              int left=prefixSum[nums.length-2];
              int right=0;
              if(left == right){
                return i;
              }
            }else{
              int left=prefixSum[i-1];
              int right=prefixSum[nums.length-1]-prefixSum[i];
              if(left == right){
                return i;
              }
            }
        }
        return -1;
    }
}