class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int ans=0,validSPI=0,totalPrevSP=0;   //SPI=StartingPointIndex
       for(int i=0;i<nums.length;i++){
           if(nums[i]>right){
             validSPI=i+1;
             totalPrevSP=0;
           }
           else if(nums[i]>=left && nums[i]<=right){
               ans=ans+(i-validSPI+1);
               totalPrevSP=i-validSPI+1;
           }else{
               ans=ans+totalPrevSP;
           }
       } 
       return ans;
    }
}