class Solution {
    public int[] singleNumber(int[] nums) {
        int xorVal=nums[0];
        int n=nums.length;
        for(int i=1;i<n;i++){
            xorVal=xorVal^nums[i];
        }
        int idx=-1;
        for(int i=0;i<32;i++){
          if((xorVal&(1<<i))!=0){
            idx=i;
            break;
          }
        }
        int part0=-1,part1=-1;
        for(int i=0;i<n;i++){
            if((nums[i]&(1<<idx))==0){
                if(part0==-1){
                    part0=nums[i];
                }else{
                part0=part0^nums[i];
                }
            }else{
                if(part1==-1){
                    part1=nums[i];
                }else{
                part1=part1^nums[i];
                }
            }
        }
        return new int[]{part0,part1};
    }
}