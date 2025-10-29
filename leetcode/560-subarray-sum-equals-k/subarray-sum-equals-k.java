class Solution {
    public int subarraySum(int[] nums, int k) {
        int ans=0;
        Map<Integer,Integer> hm=new HashMap<>();
        hm.put(0,1);
        int[] pSum=new int[nums.length];
        pSum[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            pSum[i]=pSum[i-1]+nums[i];
        }
        for(int ep=0;ep<nums.length;ep++){
            int diff=pSum[ep]-k;
            ans+=hm.getOrDefault(diff,0);
            hm.put(pSum[ep],hm.getOrDefault(pSum[ep],0)+1);
        }
        return ans;
    }
}