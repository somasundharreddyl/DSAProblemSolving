class Solution {
    public int maxArea(int[] height) {
        int p1=0,p2=height.length-1;
        int maxAmount=Integer.MIN_VALUE;
        while(p1<p2){
          int amount=Math.min(height[p1],height[p2])*(p2-p1);
          maxAmount=Math.max(amount,maxAmount);
          if(height[p1]<height[p2]){
            p1++;
          }else{
            p2--;
          }
        }
        return maxAmount;
    }
}