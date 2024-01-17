class Solution {
    public int[] twoSum(int[] nums, int target) {
      int[] arr=new int[nums.length];
      for(int k=0;k<nums.length;k++){
          arr[k]=nums[k];
      }
      Arrays.sort(nums);
      int i=0,j=nums.length-1;
      int[] ans=new int[]{-1,-1};
      while(i<j){
      if(nums[i]+nums[j]==target){
          ans[0]=i;
          ans[1]=j;
          break;
      }else if(nums[i]+nums[j]>target){
          j--;
      }else{
          i++;
      }
      }
      if(ans[0]!=-1 && ans[1]!=-1){
      for(int k=0;k<nums.length;k++){
          if(arr[k]==nums[ans[0]]){
              ans[0]=k;
              break;
          }
      } 
      for(int k=nums.length-1;k>=0;k--){
          if(arr[k]==nums[ans[1]]){
              ans[1]=k;
              break;
          }
      }
      } 
      return ans;
    }
}