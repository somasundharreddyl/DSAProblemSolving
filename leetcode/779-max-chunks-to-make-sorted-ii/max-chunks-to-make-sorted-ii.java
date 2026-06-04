class Solution {
    public int maxChunksToSorted(int[] arr) {
        int max=Integer.MIN_VALUE;
        int chunks=0;
        int[] prefixMax=new int[arr.length];
        int[] suffixMin=new int[arr.length];
        for(int i=0;i<arr.length;i++){
          if(i==0){
            prefixMax[i]=arr[i];
          }else{
           prefixMax[i]=arr[i]>prefixMax[i-1]?arr[i]:prefixMax[i-1];
          }
        }
        for(int i=arr.length-1;i>=0;i--){
          if(i==arr.length-1){
            suffixMin[i]=arr[i];
          }else{
           suffixMin[i]=arr[i]<suffixMin[i+1]?arr[i]:suffixMin[i+1];
          }
        }
        for(int i=0;i<arr.length-1;i++){
            if(prefixMax[i]<=suffixMin[i+1]){
              chunks++;
            }
        }
        chunks++;
        return chunks;
    }
}