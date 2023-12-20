class Solution {
    public int trap(int[] height) {
       int[] prefixMax=prefixMax(height);
       int[] suffixMax=suffixMax(height);
       int total=0;
       for(int i=1;i<height.length-1;i++){
           int min=prefixMax[i]<=suffixMax[i]?prefixMax[i]:suffixMax[i];
           if(min-height[i]>0){
               total+=(min-height[i]);
           }
       }
       return total;
    }

    public int[] prefixMax(int[] height){
        int[] ans=new int[height.length];
        ans[0]=height[0];
         for(int i=1;i<height.length;i++){
             ans[i]=ans[i-1]>=height[i]?ans[i-1]:height[i];
         }
         return ans;
    }
     public int[] suffixMax(int[] height){
         int[] ans=new int[height.length]; 
         ans[height.length-1]=height[height.length-1];
         for(int i=height.length-2;i>=0;i--){
         ans[i]=ans[i+1]>=height[i]?ans[i+1]:height[i];
         }  
         return ans; 
    }
}