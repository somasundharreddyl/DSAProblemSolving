class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        int count1=0,count2=0;
        if(nums.length==1){
            ans.add(nums[0]);
            return ans;
        }
        if(nums.length==2){
            if(nums[0]==nums[1]){
            ans.add(nums[0]);
            }else{
                ans.add(nums[0]);
                ans.add(nums[1]);
            }
            return ans;
        }
        int val1=nums[0],val2=nums[0],freq1=1,freq2=0;

        for(int i=1;i<nums.length;i++){
          
           if(val1==nums[i]){
                  freq1++;
                  continue;
            }else{
                if(freq1==0 && val2!=nums[i]){
                    val1=nums[i];
                    freq1++;
                    continue;
                }
            }

            if(val2==nums[i]){
                  freq2++;
                  continue;
            }else{
                if(freq2==0){
                    val2=nums[i];
                    freq2++;
                    continue;
                }  
        }
            freq1--;
            freq2--;
        }
        if(val1==val2){
            ans.add(val1);
            return ans;
        }
        for(int i=0;i<nums.length;i++){
            if(val1==nums[i]){
                count1++;
            }
            if(val2==nums[i]){
                count2++;
            }
        }
        if(count1>nums.length/3){
             ans.add(val1);
        }
        if(count2>nums.length/3){
             ans.add(val2);
        }
        return ans;
    }
}