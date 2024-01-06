class Solution {
    public static int[] sumUp(int[] nums){
            int[] ans=new int[nums.length];
            ans[0]=nums[0];
            for(int i=1;i<nums.length;i++){
                ans[i]=ans[i-1]+nums[i];
            }
            return ans;
    }
    public int pivotIndex(int[] nums) {
       int[] arr=sumUp(nums);
       if(arr[arr.length-1]-arr[0]==0){
           return 0;
       }
       for(int i=1;i<arr.length-1;i++){
          if(arr[i-1]==(arr[arr.length-1]-arr[i])){
              return i;
          }
       }
       if(arr[arr.length-2]==0){
           return arr.length-1;
       }
       return -1;
    } 
}