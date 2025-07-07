class Solution {
    public int longestPalindromeSubseq(String s) {
        String text1=s;
        String text2="";
        for(int i=s.length()-1;i>=0;i--){
           text2=text2+s.charAt(i);
        }
         int[][] dp=new int[text1.length()][text2.length()];
        int p1=text1.length(),p2=text2.length();
        int max=-1;
        for(int i=0;i<p1;i++){
            for(int j=0;j<p2;j++){
              if(text1.charAt(i)==text2.charAt(j)){
                if(i-1>=0 && j-1>=0){
                 dp[i][j]=1+dp[i-1][j-1];
                }else{
                 dp[i][j]=1;
                }  
              }else if(i-1>=0 && j-1>=0){
                dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
              }else if(i-1>=0){
                dp[i][j]=dp[i-1][j];
              }else if(j-1>=0){
                dp[i][j]=dp[i][j-1];
              }else{
                dp[i][j]=0;
              }
              max=max>dp[i][j]?max:dp[i][j];
            }
        }
        return max;
    }

}