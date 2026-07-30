class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] prefixSum=new int[nums.length];
        Map<Integer,Integer> hMap=new HashMap<>();
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(i==0){
                prefixSum[i]=nums[i];
            }else{
                prefixSum[i]=prefixSum[i-1]+nums[i];
            }
        }
        hMap.put(0,1);
        for(int ep=0;ep<prefixSum.length;ep++){
            int x=prefixSum[ep]-k;
            if(hMap.containsKey(x)){
                count+=hMap.get(x);
            }
            hMap.put(prefixSum[ep],hMap.getOrDefault(prefixSum[ep],0)+1);
        }
        return count;

    }
}

//1,3,6