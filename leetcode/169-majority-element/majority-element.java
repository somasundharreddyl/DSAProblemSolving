class Solution {
    public int majorityElement(int[] nums) {
        int val=nums[0];
        int freq=1;
        for(int i=1;i<nums.length;i++){
            if(val==nums[i]){
              freq++;
            }else{
                if(freq==0){
                    val=nums[i];
                }else{
                    freq--;
                }
            }
        }
        return val;
    }
}