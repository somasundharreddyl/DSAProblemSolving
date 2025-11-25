class Solution {
    public int nextGreaterElement(int n) {

        char[] chArr = (n+"").toCharArray();
        if(chArr.length==0 || chArr.length==1){
            return -1;
        }
        int idx=chArr.length-1;       //1
        for(int i=chArr.length-2;i>=0;i--){
             if(chArr[idx]>chArr[i]){
                int k=idx;  //1
                while(k<chArr.length && chArr[k]>chArr[i]){
                    k++;          
                }
                k--;
                char temp=chArr[i];  
                chArr[i]=chArr[k];  
                chArr[k]=temp;       
                int start=idx,end=chArr.length-1;
                reverseArray(chArr,start,end);
                break;
             }  
             idx--;
           if(i==0){
            return -1;
           }   
        }
         long ans= Long.parseLong(new String(chArr));
         if(ans>Integer.MAX_VALUE){
            return -1;
         }else{
            return (int)ans;
         }
    }
    public void reverseArray(char[] ch,int start,int end){
          while(start<end){
            char temp=ch[start];
            ch[start]=ch[end];
            ch[end]=temp;
            start++;
            end--;
          }
    }

}