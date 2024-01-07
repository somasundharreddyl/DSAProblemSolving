class Solution {

    public int[] prefixProd(int[] arr){
       int[] ans=new int[arr.length];
       ans[0]=arr[0];
       for(int i=1;i<ans.length;i++){
         ans[i]=ans[i-1]*arr[i];
       }
       return ans;
    }
    public int[] productExceptSelf(int[] nums) {
       int[] arr=prefixProd(nums);
       int suffix=1;
       for(int i=arr.length-1; i>=1; i--){
           arr[i]=arr[i-1]*suffix;
           suffix*=nums[i];
       }
       arr[0]=suffix;
       return arr;
    }
}