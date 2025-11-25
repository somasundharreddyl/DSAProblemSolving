class Solution {
    public int majorityElement(int[] nums) {
        int freq=0,ans=-1;
        for(int i=0;i<nums.length;i++){
           if(freq==0){
            freq++;
            ans=nums[i];
            continue;
           }
           if(ans==nums[i]){
            freq++;
           }else{
            freq--;
           }
        }
        return ans;
    }
}