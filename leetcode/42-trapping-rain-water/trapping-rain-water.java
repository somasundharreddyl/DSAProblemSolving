class Solution {
    public int trap(int[] height) {
       int[] prefMax=new int[height.length];
       int[] suffMax=new int[height.length];
       int units=0;
       prefMax[0]=height[0];
       for(int i=1;i<height.length;i++){
        prefMax[i]=prefMax[i-1]>height[i]?prefMax[i-1]:height[i]; 
       } 
       suffMax[height.length-1]=height[height.length-1];
       for(int i=height.length-2;i>=0;i--){
        suffMax[i]=suffMax[i+1]>height[i]?suffMax[i+1]:height[i];
       }
       for(int i=1;i<height.length-1;i++){
         if(height[i]<prefMax[i-1] && height[i]<suffMax[i+1]){
           int minH=prefMax[i-1]<suffMax[i+1]?prefMax[i-1]:suffMax[i+1];
           units+=(minH-height[i]);
         }
       }
       return units;
    }
}