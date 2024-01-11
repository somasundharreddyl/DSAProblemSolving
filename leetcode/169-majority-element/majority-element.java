class Solution {
    public int majorityElement(int[] nums) {
        int element=nums[0],freq=1;
        for(int i=1;i<nums.length;i++){
              if(freq==0){
                  element=nums[i];
                  freq++;
              }else if(element==nums[i]){
                  freq++;
              }else if(element!=nums[i]){
                  freq--;
              }
        }
        
            return element;
       
    }
}