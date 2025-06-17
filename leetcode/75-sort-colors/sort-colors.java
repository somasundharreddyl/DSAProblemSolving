class Solution {
    public void sortColors(int[] nums) {
      int i=0,p=0,j=nums.length-1;
        while(p<=j){
            if(nums[p]==0){
               swap(nums,i,p); 
                p++;
                i++;
            }else if(nums[p]==1){
                p++;
            }else{
                swap(nums,j,p);
                j--;
            }
        }
    }
    public void swap(int[] arr, int p1, int p2){
        int temp=arr[p1];
        arr[p1]=arr[p2];
        arr[p2]=temp;
    }
}