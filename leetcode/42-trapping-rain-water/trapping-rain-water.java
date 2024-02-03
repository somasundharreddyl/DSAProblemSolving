class Solution {
    private int[] findPrefMax(int[] height){
      int[] arr=new int[height.length];
      arr[0]=height[0];
      for(int i=1;i<height.length;i++){
          arr[i]=arr[i-1]>height[i]?arr[i-1]:height[i];
      }
      return arr;
    }
    private int[] findSuffMax(int[] height){
     int[] arr=new int[height.length];
       arr[height.length-1]=height[height.length-1]; 
       for(int i=height.length-2;i>=0;i--){
          arr[i]=arr[i+1]>height[i]?arr[i+1]:height[i]; 
       }
       return arr;
    }
    public int trap(int[] height) {
        int[] prefMax=findPrefMax(height);
        int[] suffMax=findSuffMax(height);
       int ans=0;
       for(int i=1;i<height.length-1;i++){
           int units=Math.min(prefMax[i-1],suffMax[i+1])-height[i];
           if(units>0){
          ans+=units;
           }
       }
       return ans;
    }
}