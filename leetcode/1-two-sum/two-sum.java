class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] arr=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            arr[i]=nums[i];
        }
        Arrays.sort(arr);
        int i=0,j=arr.length-1;
        int[] ans=new int[]{-1,-1};
        while(i<j){
           if(arr[i]+arr[j]==target){
             ans[0]=i;
             ans[1]=j;
             break;
           }else if(arr[i]+arr[j]>target){
             j--;
           }else{
            i++;
           }
        }
        for(int k=0;k<nums.length;k++){
            if(nums[k]==arr[ans[0]]){
                ans[0]=k;
                break;
            }
        }
        for(int k=0;k<nums.length;k++){
            if(ans[0]!=k && nums[k]==arr[ans[1]]){
                ans[1]=k;
                break;
            }
        }
        return ans;
    }
}