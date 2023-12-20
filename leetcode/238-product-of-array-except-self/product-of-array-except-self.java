class Solution {
    public int[] productExceptSelf(int[] nums) {
       int[] prefixProd=prefProd(nums);
       int[] answer=new int[nums.length];
       int suffix=1;
       for(int i=nums.length-1;i>0;i--){
          prefixProd[i]=prefixProd[i-1]*suffix;
          suffix=suffix*nums[i];
      }
      prefixProd[0]=suffix;
      return prefixProd;
    }
    public int[] prefProd(int[] nums){
        int[] ans=new int[nums.length];
        ans[0]=nums[0];
        for(int i=1;i<nums.length;i++){
         ans[i]=ans[i-1]*nums[i];
        }
        return ans;
    }
}