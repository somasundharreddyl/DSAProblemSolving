class Solution {
    public int trap(int[] height) {
        int[] prefixMax=new int[height.length];
        int[] suffixMax=new int[height.length];
        int ans=0;
        prefixMax[0]=height[0];
        for(int i=1;i<height.length;i++){
          prefixMax[i]=height[i]>prefixMax[i-1]?height[i]:prefixMax[i-1];
        }
        suffixMax[height.length-1]=height[height.length-1];
        for(int i=height.length-2;i>=0;i--){
           suffixMax[i]=height[i]>suffixMax[i+1]?height[i]:suffixMax[i+1];
        }
        for(int i=1;i<height.length-1;i++){
            int min=Math.min(prefixMax[i-1],suffixMax[i+1]);
            if(min>height[i]){
                ans=ans+min-height[i];
            } 
        }
        return ans;
    }
}

//4,4,4,4,4,5
//5,5,5,5,5,5
//2+4+1+2