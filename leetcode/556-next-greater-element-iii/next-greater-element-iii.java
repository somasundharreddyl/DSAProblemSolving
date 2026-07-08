class Solution {
    public int nextGreaterElement(int n) {
       String num=n+"";
       int size=num.length();
       char[] ch=num.toCharArray();
       int idx=-1,idx2=-1;
       for(int i=size-2;i>=0;i--){
        if(ch[i]<ch[i+1]){
           idx=i;
           break;
        }
       }
       if(idx==-1){
        return idx;
       }
       for(int i=size-1;i>idx;i--){
         if(ch[i]>ch[idx]){
            idx2=i;
            break;
         }
       }
       char temp=ch[idx];
       ch[idx]=ch[idx2];
       ch[idx2]=temp;
       int start=idx+1,end=size-1;
       while(start<=end){
         char temp1=ch[start];
       ch[start]=ch[end];
       ch[end]=temp1;
       start++;
       end--;
       }
       long ans= Long.parseLong(String.valueOf(ch));
       if(ans>Integer.MAX_VALUE){
        return -1;
       }
       return (int)ans;
    }
}