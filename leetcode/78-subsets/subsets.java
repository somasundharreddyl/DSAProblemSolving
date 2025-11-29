class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        int total=(1<<nums.length);
        for(int i=0;i<total;i++){
            List<Integer> temp=new ArrayList<>();
            for(int j=0;j<nums.length;j++){
                if(checkBit(i,j)){
                    temp.add(nums[j]);
                }
            }
            ans.add(temp);
        }
        return ans;
    }

    public boolean checkBit(int n,int j){
        if((n&(1<<j))!=0){
           return true;
        }
        return false;
    }
}