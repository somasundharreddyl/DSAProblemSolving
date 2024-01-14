class Solution {
    public int maxChunksToSorted(int[] arr) {
        int maxNum=Integer.MIN_VALUE,count=0;
      for(int i=0;i<arr.length;i++){
      maxNum=maxNum>arr[i]?maxNum:arr[i];
     if(maxNum==i){count++;}
      }
      return count;
    }
}