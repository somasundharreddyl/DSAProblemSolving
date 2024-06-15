class Solution {
    public int[] prefixSum(int[] arr){
        for(int i=1;i<arr.length;i++){
            arr[i]=arr[i]+arr[i-1];
        }
        return arr;
    }
    public int pivotIndex(int[] nums) {
        int[] prefixSum=prefixSum(nums);
          int n=nums.length;
        for(int i=0;i<n;i++){
            if((i==0) && (prefixSum[n-1]-prefixSum[i]==0)){
                   return i;
            }else if((i==n-1) && (prefixSum[n-2]==0)){
               return i;
            }
            else if((i!=0) && (i!=n-1) && prefixSum[i-1]==(prefixSum[n-1]-prefixSum[i])){
                return i;
            }   
        }
        return -1;
    }
}