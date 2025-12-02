class Solution {
    public int maxArea(int[] height) {
        int start=0,end=height.length-1;
        int maxAmount=0;
        while(start<end){
            if(height[start]>height[end]){
                int amount=(end-start)*(Math.min(height[start],height[end]));
                maxAmount=amount>maxAmount?amount:maxAmount;
                end--;
            }else{
               int amount=(end-start)*(Math.min(height[start],height[end]));
                maxAmount=amount>maxAmount?amount:maxAmount;
                start++;
            }
        }
        return maxAmount;
    }
}