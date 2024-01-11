class Solution {
    public int nextGreaterElement(int n) {

        char[] charArr=(n+"").toCharArray();
        int index=-1,idx2=-1;

        for(int i=charArr.length-2;i>=0;i--){
            if(charArr[i]<charArr[i+1]){
                index=i;
                break;
            }
        }

        if(index==-1){
            return -1;
        }

        for(int i=charArr.length-1;i>=0;i--){
            if(charArr[i]>charArr[index]){
                idx2=i;
                break;
            }
        }

        char temp=charArr[index];
        charArr[index]=charArr[idx2];
        charArr[idx2]=temp;

        int start=index+1,end=charArr.length-1;

        while(start<end){
            char temp1=charArr[start];
        charArr[start]=charArr[end];
        charArr[end]=temp1;
        start++;
        end--;
        }

      long ans = Long.parseLong(new String(charArr));

      if(ans>Integer.MAX_VALUE){
          return -1;
      }else{
          return (int)ans;
      }

    }
}