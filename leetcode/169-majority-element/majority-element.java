class Solution {
    public int majorityElement(int[] nums) {
        int freq=0,num=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(freq==0){
                num=nums[i];
                freq++;
                continue;
            }
            if(num==nums[i]){
              freq++;
            }else{
              freq--;  
            }
        }
        return num;
    }
}