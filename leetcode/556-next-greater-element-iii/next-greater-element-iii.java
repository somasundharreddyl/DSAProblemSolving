class Solution {
    public int nextGreaterElement(int n) {
        String num=n+"";
        char[] chArr=num.toCharArray();
        int idx=-1;
        for(int i=chArr.length-1;i>0;i--){
            if(chArr[i]>chArr[i-1]){
                idx=i-1;
                break;
            }
        }
        if(idx==-1){return idx;}
        for(int i=chArr.length-1;i>idx;i--){
           if(chArr[i]>chArr[idx]){
            char temp=chArr[i];
            chArr[i]=chArr[idx];
            chArr[idx]=temp;
            break;
           }
        }
        int start=idx+1,end=num.length()-1;
        while(start<=end){
          char temp=chArr[start];
          chArr[start]=chArr[end];
          chArr[end]=temp;
          start++;
          end--;
        }
        long res=Long.parseLong(String.valueOf(chArr));
        if(res>Integer.MAX_VALUE){
            return -1;
        }
        return (int)res;   
    }
}