class Solution {
    public int maxChunksToSorted(int[] arr) {
        int max=Integer.MIN_VALUE;
        int chunks=0;
        for(int i=0;i<arr.length;i++){
            max=max>arr[i]?max:arr[i];
            if(max==i){
              chunks++;
            }
        }
        return chunks;
    }
}