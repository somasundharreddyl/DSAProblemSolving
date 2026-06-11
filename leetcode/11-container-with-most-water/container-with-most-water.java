class Solution {
    public int maxArea(int[] height) {
        int start=0,end=height.length-1;
        int maxAmount=Integer.MIN_VALUE;
        while(start<end){
           int amount=(end-start)*(Math.min(height[start],height[end]));
           maxAmount=amount>maxAmount?amount:maxAmount;
           if(height[start]>height[end]){
              end--;
           }else{
              start++;
           }
        }
        return maxAmount;
    }
}