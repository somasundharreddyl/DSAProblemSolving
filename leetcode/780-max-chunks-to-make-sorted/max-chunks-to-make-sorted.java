class Solution {
    public int maxChunksToSorted(int[] arr) {
        int chunks=0,maxIdx=-1;
        for(int i=0;i<arr.length;i++){
            if(i==0){
                maxIdx=0;
            }else{
                maxIdx=arr[maxIdx]>arr[i]?maxIdx:i;
            }
            if(i==arr[maxIdx]){
                chunks++;
            }
        }
        return chunks;
    }
}