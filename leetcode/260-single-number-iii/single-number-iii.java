class Solution {
    public int[] singleNumber(int[] nums) {

        int val1=-1,val2=-1;
        int val=nums[0];
        int index=-1;
        for(int i=1;i<nums.length;i++){
            val=val^nums[i];
        }
        for(int i=0;i<32;i++){
            if((val&(1<<i))!=0){
               index=i;
               break;
            }
        }
        for(int i=0;i<nums.length;i++){
            if((nums[i] & (1<<index))!=0){
               if(val1==-1){
                val1=nums[i];
               }else{
                val1=val1^nums[i];
               }
            }else{
               if(val2==-1){
                val2=nums[i];
               }else{
                val2=val2^nums[i];
               }
            }
        }
           return new int[]{val1,val2};
    }
}