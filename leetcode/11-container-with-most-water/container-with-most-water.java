class Solution {
    public int maxArea(int[] height) {
        int i=0,j=height.length-1,currWaterLevel=Integer.MIN_VALUE,overAllWaterLevel=Integer.MIN_VALUE;
        while(i<j){
            int min=height[i]>height[j]?height[j]:height[i];
            currWaterLevel=(j-i)*min;
            overAllWaterLevel=overAllWaterLevel>currWaterLevel?overAllWaterLevel:currWaterLevel;
            if(height[i]>height[j]){
                j--;
            }else{
                i++;
            }
        }
        return overAllWaterLevel;
    }
}