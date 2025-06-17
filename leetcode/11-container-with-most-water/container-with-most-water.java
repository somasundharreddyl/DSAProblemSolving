class Solution {
    public int maxArea(int[] height) {
        int start=0,end=height.length-1;
        int ans=Integer.MIN_VALUE;
        while(start<=end){
         if(height[start]<height[end]){
           int store=(end-start)*Math.min(height[start],height[end]);
           ans=ans>store?ans:store;
             start++;
         }else{
           int store=(end-start)*Math.min(height[start],height[end]);
           ans=ans>store?ans:store;
           end--;
         }
        }
        return ans;
    }
}