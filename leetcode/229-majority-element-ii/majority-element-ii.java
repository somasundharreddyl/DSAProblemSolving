class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int num1=Integer.MIN_VALUE,num2=Integer.MIN_VALUE;
        List<Integer> ans=new ArrayList<>();
        int n=nums.length;
        int freq1=0,freq2=0;
        for(int i=0;i<n;i++){
            if((freq1==0 && num2!=nums[i]) || num1==nums[i]){
                num1=nums[i];
                freq1++;
                continue;
            }
            if(freq2==0 || num2==nums[i]){
                num2=nums[i];
                freq2++;
                continue;
            }
                freq1--;
                freq2--;
        }
        int count1=0,count2=0;
         if(freq1>0){
        for(int i=0;i<n;i++){
            if(nums[i]==num1){
                count1++;
            }
        }
        }
        if(freq2>0){
        for(int i=0;i<n;i++){
            if(nums[i]==num2){
                count2++;
            }
        }
        }
        if(count1>n/3){
          ans.add(num1);
        }
        if(count2>n/3){
            ans.add(num2);
        }
       return ans;
    }
}