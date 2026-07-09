class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n=arr.length;
        int[] prefixMax=new int[n];
        int[] suffixMin=new int[n];
        for(int i=0;i<n;i++){
            if(i==0){
                prefixMax[i]=arr[i];
            }else{
            prefixMax[i]=prefixMax[i-1]>arr[i]?prefixMax[i-1]:arr[i];
            }
        }
        for(int i=n-1;i>=0;i--){
            if(i==n-1){
                suffixMin[i]=arr[i];
            }else{
                suffixMin[i]=suffixMin[i+1]<arr[i]?suffixMin[i+1]:arr[i];
            }
        }
        int chunks=0;
        for(int i=0;i<arr.length-1;i++){
            if(prefixMax[i]<=suffixMin[i+1]){
                chunks++;
            }
        }
        return chunks+1; 
    }
}