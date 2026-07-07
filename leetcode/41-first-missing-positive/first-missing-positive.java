class Solution {
    public int firstMissingPositive(int[] nums) {
        int n=nums.length;
        int min=1,max=n;
        int i=0;
        while(i<n){
          int k=nums[i];
          if(k==(i+1) || k<min || k>max || nums[i]==nums[k-1]){
            i++;
            continue;
          }
          int temp=nums[k-1];
          nums[k-1]=nums[i];
          nums[i]=temp;
        }
        for(int j=0;j<n;j++){
            if(j+1!=nums[j]){
             return j+1;
            }
        }
        return max+1; 
    }
}