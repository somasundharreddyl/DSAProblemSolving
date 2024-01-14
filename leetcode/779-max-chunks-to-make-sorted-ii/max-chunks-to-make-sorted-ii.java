class Solution {

    public int[] prefixMax(int[] arr){
      int[] nums=new int[arr.length];
      nums[0]=arr[0];
      for(int i=1;i<nums.length;i++){
          nums[i]=nums[i-1]>arr[i]?nums[i-1]:arr[i];
      }
      return nums;
    }

    public int[] suffixMin(int[] arr){
      int[] nums=new int[arr.length];
      nums[arr.length-1]=arr[arr.length-1];
      for(int i=arr.length-2;i>=0;i--){
          nums[i]=nums[i+1]<arr[i]?nums[i+1]:arr[i];
      }
      return nums;
    }
    
    public int maxChunksToSorted(int[] arr) {
       int[] prefMax=prefixMax(arr);
       int[] suffMin=suffixMin(arr);
       int count=0;
       for(int i=0;i<arr.length-1;i++){
           if(prefMax[i]<=suffMin[i+1]){
               count++;
           }
       }
       return ++count;

    }
}