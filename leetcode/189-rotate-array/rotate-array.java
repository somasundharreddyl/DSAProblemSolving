class Solution {
    public static void reverse(int[] arr,int first,int last){
           while(first<last){
               int temp=arr[first];
               arr[first]=arr[last];
               arr[last]=temp;
               first++;
               last--;
           }
    }
    public void rotate(int[] nums, int k) {
      k=k%nums.length;
      int start=0,end=nums.length-1;
      reverse(nums,start,end);
      reverse(nums,start,k-1);
      reverse(nums,k,end);
}
}