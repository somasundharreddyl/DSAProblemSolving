class Solution {
    public String longestPrefix(String s) {
       int n=s.length();
        int[] happyPrefixArr=new int[n]; 
        char[] charArr=s.toCharArray();
        for(int i=1;i<n;i++){
          int idx=happyPrefixArr[i-1]; 
          if(charArr[i]==charArr[idx]){ 
            happyPrefixArr[i]=idx+1;
          }else{
            while(idx-1>=0){
             if(charArr[i]==charArr[happyPrefixArr[idx-1]]){
               happyPrefixArr[i]=happyPrefixArr[idx-1]+1;
               break;
             }
             idx=happyPrefixArr[idx-1];
            }
          }
        }
        return s.substring(0,happyPrefixArr[n-1]);
    }
}