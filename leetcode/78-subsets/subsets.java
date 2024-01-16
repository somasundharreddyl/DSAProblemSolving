class Solution {

     public boolean checkBit(int n, int i){
        if((n&(1<<i)) != 0) return true;
        return false;
    }


    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int totalno = (1<<n);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i<totalno; i++){
            List<Integer> temp = new ArrayList<>();
            for(int j = 0; j<n; j++){
                if(checkBit(i,j)==true){
                    temp.add(nums[j]);
                }
            }
            ans.add(temp);
        }
        return ans;
    }
}