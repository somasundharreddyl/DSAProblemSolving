class Solution {
    public int maxChunksToSorted(int[] arr) {
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        int[] prefixMin=new int[arr.length];
        int count=0;
        for(int i=arr.length-1;i>=0;i--){
            min=min<arr[i]?min:arr[i];
            prefixMin[i]=min;
        }
        
        for(int i=0;i<arr.length-1;i++){
            max=max>arr[i]?max:arr[i];
            if(max<=prefixMin[i+1]){
               count++;
            }
        }
        return count+1;
    }
}

//1,1,3,4,4