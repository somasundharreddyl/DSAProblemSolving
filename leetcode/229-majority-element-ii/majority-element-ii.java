class Solution {
    public List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> list=new ArrayList<>();
        if(nums.length==1){
            list.add(nums[0]);
            return list;
        }
        int ans1=nums[0],ans2=-1,freq1=1,freq2=0;
     for(int i=1;i<nums.length;i++){

          if(nums[i]==ans1){
             freq1++;
         }else if(nums[i]==ans2){
             freq2++;
         }
        else if(freq1==0){
             ans1=nums[i];
             freq1++;
             continue;
         }
         else if(freq2==0){
             ans2=nums[i];
             freq2++;
             continue;
         }
        else if(nums[i]!=ans1 && nums[i]!=ans2){
             freq1--;
             freq2--;
         }
         
     }
     int count1=0,count2=0;
     if(freq1>0){
         for(int i=0;i<nums.length;i++){
             if(ans1==nums[i]){
                 count1++;
             }
         }
         if(count1>nums.length/3)
         list.add(ans1);
     }
     if(freq2>0){
         for(int i=0;i<nums.length;i++){
             if(ans2==nums[i]){
                 count2++;
             }
         }
         if(count2>nums.length/3)
         list.add(ans2);
     }  
     return list;
    }
}