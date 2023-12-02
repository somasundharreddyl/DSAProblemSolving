class Solution {
    public static void reverse(int[] arr,int left,int right){
      int start=left,end=right;
      while(start<end){
      int temp=arr[start];
      arr[start]=arr[end];
      arr[end]=temp;
      start++;
      end--;
      }
    }
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
}
}