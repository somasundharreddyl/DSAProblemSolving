class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] arr=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            arr[i]=nums[i];
        }
        Arrays.sort(arr);
        int s=0,e=arr.length-1;
        int n1=-1,n2=-1;
        while(s<e){
            if(arr[s]+arr[e]==target){
              n1=arr[s];
              n2=arr[e];
              break;
            }
           else if(arr[s]+arr[e]>target){
                e--;
            }else{
                s++;
            }
        }
       int idx1=Integer.MIN_VALUE,idx2=Integer.MIN_VALUE;
       for(int i=0;i<nums.length;i++){
        if(idx1==Integer.MIN_VALUE && nums[i]==n1){
               idx1=i;
        }
        if(idx2==Integer.MIN_VALUE && nums[i]==n2 && idx1!=i){
            idx2=i;
        }
       }
       return new int[]{idx1,idx2};
    }
}