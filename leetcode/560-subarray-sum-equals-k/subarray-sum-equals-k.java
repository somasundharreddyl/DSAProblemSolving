class Solution {
    public int subarraySum(int[] nums, int k) {
        int ans=0;
        for(int s=0;s<nums.length;s++){
            int count=0;
           for(int e=s;e<nums.length;e++){
            count+=nums[e];
            if(count==k){
              ans++;
            } 
           }
        }
        return ans;
    }
}