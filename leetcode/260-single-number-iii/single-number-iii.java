class Solution {
    private boolean checkSetBit(int n,int i){
        if((n & (1<<i))!=0){
            return true;
        }
        return false;
    }
    public int[] singleNumber(int[] nums) {
        int shiftValue=0,val1=0,val2=0;
        int[] ans=new int[2];
        int xorValue=nums[0];
        for(int i=1;i<nums.length;i++){
            xorValue=xorValue^(nums[i]);
        }

        for(int i=0;i<32;i++){
          if(checkSetBit(xorValue,i)){
            shiftValue=i;
            break;
          }
        }

        for(int i=0;i<nums.length;i++){
          if(checkSetBit(nums[i],shiftValue)){
              val1=val1^(nums[i]);
          }else{
              val2=val2^(nums[i]);
          }
        }
        ans[0]=val1;
        ans[1]=val2;
        return ans;
    }
}