class Solution {
    public int[] prefixMax(int[] arr){
        int[] preMax=new int[arr.length];
        preMax[0]=arr[0];
        for(int i=1;i<arr.length;i++){
         preMax[i]=preMax[i-1]>arr[i]?preMax[i-1]:arr[i]; 
        }
        return preMax;
    }

    public int[] suffixMax(int[] arr){
        int[] suffMax=new int[arr.length];
        suffMax[arr.length-1]=arr[arr.length-1];
        for(int i=arr.length-2;i>=0;i--){
         suffMax[i]=suffMax[i+1]>arr[i]?suffMax[i+1]:arr[i]; 
        }
        return suffMax;
    }
    public int trap(int[] height) {
       int[] suffixmax=suffixMax(height);
       int[] prefixmax=prefixMax(height);
       int units=0;
       for(int i=1;i<height.length-1;i++){
        if(suffixmax[i+1]-height[i]>0 && prefixmax[i-1]-height[i]>0){
         units+=(suffixmax[i+1]-height[i]<prefixmax[i-1]-height[i]?suffixmax[i+1]-height[i]:prefixmax[i-1]-height[i]);
       }
       }
       return units; 
    }
}