class Solution {
    public int maxChunksToSorted(int[] arr) {
        int count=0,max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            max=arr[i]>max?arr[i]:max;
            if(max==i){
                count++;
            }
        }
          return count;
    }
}