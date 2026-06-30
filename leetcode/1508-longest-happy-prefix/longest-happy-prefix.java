class Solution {
    public String longestPrefix(String s) {
        int[] lps=new int[s.length()];
        for(int i=1;i<s.length();i++){
          int idx=i; //1
          while(idx-1>=0){
             if(s.charAt(i)==s.charAt(lps[idx-1])){
              lps[i]=lps[idx-1]+1;
              break;
             }
             idx=lps[idx-1];  
          }
        }
        int max=lps[s.length()-1];
        return s.substring(0,max);
    }
}