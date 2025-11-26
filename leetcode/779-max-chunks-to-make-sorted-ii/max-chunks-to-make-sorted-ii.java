class Solution {
    public int maxChunksToSorted(int[] arr) {
        int chunks=0;
        int[] suffMinArr=new int[arr.length];
        suffMinArr[arr.length-1]=arr[arr.length-1];
        for(int i=arr.length-2;i>=0;i--){
           suffMinArr[i]=suffMinArr[i+1]<arr[i]?suffMinArr[i+1]:arr[i];
        }
        int maxIdx=-1;
        for(int i=0;i<arr.length-1;i++){
            if(i==0){
                maxIdx=0;
            }else{
                maxIdx=arr[maxIdx]>arr[i]?maxIdx:i;
            }
            if(arr[maxIdx]<=suffMinArr[i+1]){
               chunks++;
            }
        }
        return chunks+1;
    }
}