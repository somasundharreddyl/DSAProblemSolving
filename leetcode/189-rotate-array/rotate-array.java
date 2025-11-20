class Solution {
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        int s=0,e=nums.length-1;
        while(s<e){
            int temp=nums[s];
            nums[s]=nums[e];
            nums[e]=temp;
            s++;
            e--;
        }
        s=0;
        e=k-1;
        while(s<e){
            int temp=nums[s];
            nums[s]=nums[e];
            nums[e]=temp;
            s++;
            e--;
        }
        s=k;
        e=nums.length-1;
        while(s<e){
            int temp=nums[s];
            nums[s]=nums[e];
            nums[e]=temp;
            s++;
            e--;
        }
    }
}
