class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        Arrays.sort(nums);
        int max=0,count=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]-nums[i-1]==1){
                count++; //1
            }else if(nums[i]-nums[i-1]==0){
            continue;
            }
            else{
                max=max>count?max:count; //4
                count=1;
            }
        }
        max=max>count?max:count;
        return max;
    }
}
//[0,0,1,2,3,4,5,6,7,8]