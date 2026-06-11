class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] arr=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            arr[i]=nums[i];
        }
        Arrays.sort(arr);
        int ele1=-1,ele2=-1;
        int start=0,end=arr.length-1;
        while(start<end){
            int sum=arr[start]+arr[end];
            if(sum==target){
               ele1=arr[start];
               ele2=arr[end];
               break;
            }else if(sum<target){
              start++;
            }else{
                end--;
            } 
        }
        int idx1=-1,idx2=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==ele1 && idx1==-1){
               idx1=i;
            }else if(nums[i]==ele2){
               idx2=i;
            }
        }
        return new int[]{idx1,idx2};
    }
}