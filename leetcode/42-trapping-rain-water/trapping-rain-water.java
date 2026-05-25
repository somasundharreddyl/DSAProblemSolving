class Solution {
    public int trap(int[] height) {
       int n=height.length;
       int[] prefixMaxArr=new int[n];
       int[] suffixMaxArr=new int[n];
       for(int i=0;i<n;i++){
         if(i==0){
          prefixMaxArr[i]=height[i];  
         }else{
          prefixMaxArr[i]=prefixMaxArr[i-1]>height[i]?prefixMaxArr[i-1]:height[i]; 
         }
       }
       for(int i=n-1;i>=0;i--){
        if(i==n-1){
            suffixMaxArr[i]=height[i];
        }else{
            suffixMaxArr[i]=suffixMaxArr[i+1]>height[i]?suffixMaxArr[i+1]:height[i];
        }
       }
       int units=0;
       for(int i=1;i<n-1;i++){
        int minH=Math.min(prefixMaxArr[i-1],suffixMaxArr[i+1]);
        if(minH>height[i]){
        units+=(minH-height[i]);
        }
       } 
       return units;    
    }
}