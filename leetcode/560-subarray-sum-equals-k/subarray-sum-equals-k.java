class Solution {
    public int subarraySum(int[] nums, int k) {
         int count=0;
        if(nums.length==1 && nums[0]!=k){
             return count;
        }
        Map<Integer,Integer> hm=new HashMap<>();
        int[] pnums=new int[nums.length];
        pnums[0]=nums[0];
        hm.put(0,1);
        for(int i=1;i<nums.length;i++){
        pnums[i]=pnums[i-1]+nums[i];
        }
        for(int i=0;i<pnums.length;i++){
           if(hm.containsKey(pnums[i]-k)){
               count+=hm.get(pnums[i]-k);
            }
            hm.put(pnums[i],hm.getOrDefault(pnums[i],0)+1);
        }
       return count; 
    }
}
//[1,2,3]=>2
//[1,3,6]=>3
//[-1,-2,-1]