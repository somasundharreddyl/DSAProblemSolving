class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer,Integer> hm=new HashMap<>();
        int ans=0;
        for(int i=0;i<nums.length;i++){
            int n=nums[i];
            if(!hm.containsKey(n)){
               int sp=n;
               int ep=n;
               if(hm.containsKey(n-1)){
                sp=sp-hm.get(n-1);
               }
               if(hm.containsKey(n+1)){
                ep=ep+hm.get(n+1);
               }
               int len=ep-sp+1;
               hm.put(sp,len);
               hm.put(ep,len);
               if(n!=sp && n!=ep){
                hm.put(n,1);
               }
               ans=ans>len?ans:len;
            }
        }
        return ans;
    }
}
