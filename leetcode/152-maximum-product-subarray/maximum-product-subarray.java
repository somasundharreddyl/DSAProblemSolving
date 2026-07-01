class Solution {
    public int maxProduct(int[] nums) {
        int res=nums[0],max=nums[0],min=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]<0){
                int temp=max;
                max=min;
                min=temp;
            }
            max=Math.max(nums[i],nums[i]*max); //4
            min=Math.min(nums[i],nums[i]*min); //-48
            res=Math.max(max,res); //6
        }
        return res;
    }
}