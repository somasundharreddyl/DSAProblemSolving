class Solution {
    public int majorityElement(int[] nums) {
        int element=-1;
        int freq=0;
        for(int i=0;i<nums.length;i++){
            if(freq==0){
                element=nums[i];
                freq++;
            }else if(element==nums[i]){
                freq++;
            }else{
                freq--;
            }
        }
        return element;
    }
}