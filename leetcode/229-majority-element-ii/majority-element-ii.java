class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        int freq1=0,freq2=0,ans1=Integer.MIN_VALUE,ans2=Integer.MIN_VALUE;  //freq1=0,ans1=2,   freq2=1,ans2=1
        for(int i=0;i<nums.length;i++){
            if((freq1==0 || ans1==nums[i]) && ans2!=nums[i]){
                freq1++;
                ans1=nums[i];
                continue;
            }
            if(freq2==0 || ans2==nums[i]){ //
                freq2++;
                ans2=nums[i];
                continue;
            }
            if(nums[i]!=ans1 && nums[i]!=ans2){
                freq1--;
                freq2--;
            }
        }
        int c1=0,c2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==ans1){
                c1++;
            }
        }
        if(c1>nums.length/3){
            ans.add(ans1);
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]==ans2){
                c2++;
            }
        }
        if(c2>nums.length/3){
            ans.add(ans2);
        }
        return ans;
    }
}