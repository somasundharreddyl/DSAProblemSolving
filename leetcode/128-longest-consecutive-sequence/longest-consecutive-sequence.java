class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        Map<Integer,Integer> hMap=new HashMap<>();
        int ans=0;
        for(int i=0;i<nums.length;i++){
            if(!hMap.containsKey(nums[i])){
               int sp=nums[i];
               int ep=nums[i];
               if(hMap.containsKey(nums[i]-1)){
                 sp=sp-hMap.get(nums[i]-1);
               }
               if(hMap.containsKey(nums[i]+1)){
                 ep=ep+hMap.get(nums[i]+1);
               }
               int len=ep-sp+1;
               hMap.put(sp,len);
               hMap.put(ep,len);
               if(sp!=nums[i] && ep!=nums[i]){
                hMap.put(nums[i],1);
               }
               ans=ans>len?ans:len;
            }
        }
        return ans;
    }
}