class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        int total=1<<nums.length;
        for(int i=0;i<total;i++){
            List<Integer> list=new ArrayList<>();
            for(int j=0;j<nums.length;j++){
                if(checkBit(i,j)){
                    list.add(nums[j]);
                }
            }
            ans.add(list);
        }
        return ans;
    }

    public boolean checkBit(int n, int j){
        if((n&(1<<j))!=0){
            return true;
        }
        return false;
    }
}