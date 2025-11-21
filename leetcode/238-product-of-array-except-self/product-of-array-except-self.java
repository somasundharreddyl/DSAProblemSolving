class Solution {
    public int[] productExceptSelf(int[] nums) {
       int[] prefixProd=new int[nums.length];
       prefixProd[0]=nums[0];
       for(int i=1;i<nums.length;i++){
         prefixProd[i]=prefixProd[i-1]*nums[i];
       } 
       int suffixProd=1;
       for(int i=nums.length-1;i>=1;i--){
          prefixProd[i]=prefixProd[i-1]*suffixProd;
          suffixProd*=nums[i];
       }
       prefixProd[0]=suffixProd;
       return prefixProd;
    }
}