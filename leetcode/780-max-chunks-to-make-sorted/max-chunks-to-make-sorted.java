class Solution {
    public int maxChunksToSorted(int[] arr) {
        int max=Integer.MIN_VALUE;
        int count=0;
        for(int i=0;i<arr.length;i++){
            max=max>arr[i]?max:arr[i];
            if(i==max){
                count++;
            }
        }
        return count;
    }
}