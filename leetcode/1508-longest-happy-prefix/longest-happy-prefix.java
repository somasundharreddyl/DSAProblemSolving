class Solution {
    public String longestPrefix(String s) {
        int[] lps=new int[s.length()];
        char[] chArr=s.toCharArray();
        for(int i=1;i<chArr.length;i++){
            int idx=i;
            while(idx-1>=0){
                if(chArr[i]==chArr[lps[idx-1]]){
                    lps[i]=lps[idx-1]+1;
                    break;
                }
                idx=lps[idx-1];
            }
        }
        return s.substring(0,lps[lps.length-1]);
    }
}