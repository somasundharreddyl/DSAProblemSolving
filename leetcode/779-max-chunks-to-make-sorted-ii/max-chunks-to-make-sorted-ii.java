class Solution {
    public int[] prefix(int[] arr){
     int[] prefix=new int[arr.length];
     prefix[0]=arr[0];
     for(int i=1;i<arr.length;i++){
         prefix[i]=prefix[i-1]>arr[i]?prefix[i-1]:arr[i];
     }
     return prefix;
    }
    public int[] suffix(int[] arr){
        int[] suffix=new int[arr.length];
     suffix[arr.length-1]=arr[arr.length-1];
     for(int i=arr.length-2;i>=0;i--){
         suffix[i]=suffix[i+1]<arr[i]?suffix[i+1]:arr[i];
     }
     return suffix;
    }
    public int maxChunksToSorted(int[] arr) {
        int count=0;
        int[] prefixMaxArr=prefix(arr);
        int[] suffixMinArr=suffix(arr);
        for(int i=0;i<arr.length-1;i++){
            if(prefixMaxArr[i]<=suffixMinArr[i+1]){
               count++;
            }
        }
        count++;
        return count;
    }
}