class Solution {
    public int[] singleNumber(int[] nums) {
        int xorValue=nums[0];
        int setBit=0,unSetBit=0;
        for(int i=1;i<nums.length;i++){
           xorValue=xorValue^nums[i];
        }
        for(int i=0;i<32;i++){
            if((xorValue&(1<<i))!=0){
                for(int j=0;j<nums.length;j++){
                   if((nums[j]&(1<<i))==0){
                    setBit=setBit^nums[j];
                   }else{
                    unSetBit=unSetBit^nums[j];
                   }
                }
              return new int[]{setBit,unSetBit};  
            }
        }
        return new int[]{-1,-1};
    }
}