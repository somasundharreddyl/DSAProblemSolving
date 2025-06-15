class Solution {
    public int nextGreaterElement(int n) {
      char[] arr=(""+n).toCharArray();
      int idx1=-1,idx2=-1;
        for(int i=arr.length-1;i>0;i--){
            if(arr[i]>arr[i-1]){
                idx1=i-1;
                break;
            }
        }

        if(idx1!=-1){
            int num=arr[idx1];
            for(int i=arr.length-1;i>=idx1;i--){
               if(arr[i]>num){
                 idx2=i;
                 break;
               }
            }
            char temp=arr[idx1];
            arr[idx1]=arr[idx2];
            arr[idx2]=temp;

            int start=idx1+1,end=arr.length-1;
            while(start<end){
                char temp1=arr[start];
            arr[start]=arr[end];
            arr[end]=temp1;
              start++;
              end--;
            }
          long l=Long.parseLong(new String(arr));
          if(l>Integer.MAX_VALUE){
            return -1;
          }else{
            return (int)l;
          }
        }else{
            return -1;
        }

    }
}