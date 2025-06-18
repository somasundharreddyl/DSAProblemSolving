class Solution {
    public int singleNumber(int[] nums) {
        int num=0;
        for(int i=0;i<32;i++){
            int sum=0;
            for(int j=0;j<nums.length;j++){
              if(checkBit(nums,j,i)){
                sum++;
              }
            }
            if(sum%3==1){
                num+=(1<<i);
            }
        }
        return num;
    }
    public boolean checkBit(int[] nums, int index, int k){
        if((nums[index] & (1<<k))!=0){
            return true;
        }
        return false;
    }
}