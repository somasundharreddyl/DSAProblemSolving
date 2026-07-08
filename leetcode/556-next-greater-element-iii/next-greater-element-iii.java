class Solution {
    public int nextGreaterElement(int n) {
        char[] ch = (n+"").toCharArray();
       int index=-1;
       int minValIndex=0;
        for(int i=ch.length-2; i>=0; i--){
            if(ch[i]<ch[i+1]){
              index=i;
              break;   
            }
        }
        if(index==-1){
            return -1;
        }
        for(int i=ch.length-1;i>index;i--){
               if(ch[index]<ch[i]){
                   minValIndex=i;
                   break;
               }
        }
        char temp=ch[index];
        ch[index]=ch[minValIndex];
        ch[minValIndex]=temp;

        int low=index+1,high=ch.length-1;
        while(low<high){
           char temp1=ch[low];
        ch[low]=ch[high];
        ch[high]=temp1; 
        low++;
        high--;
        }
        long ans= Long.parseLong(new String(ch));
        if(ans>Integer.MAX_VALUE){
            return -1;
        }else{
            return (int)ans;
        }
    }
}