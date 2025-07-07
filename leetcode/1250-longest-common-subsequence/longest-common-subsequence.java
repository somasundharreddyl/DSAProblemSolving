class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp=new int[text1.length()][text2.length()];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        int p1=text1.length()-1,p2=text2.length()-1;
        return lcs(text1,text2,p1,p2,dp);
    }
    public int lcs(String text1, String text2,int p1, int p2,int[][] dp){
         if(p1<0 || p2<0){
            return 0;
         }

         if(dp[p1][p2]!=-1){return dp[p1][p2];}

         if(text1.charAt(p1)==text2.charAt(p2)){
            dp[p1][p2]=1+lcs(text1,text2,p1-1,p2-1,dp);
            return 1+lcs(text1,text2,p1-1,p2-1,dp);
         }else{
            int x=lcs(text1,text2,p1-1,p2,dp);
            int y=lcs(text1,text2,p1,p2-1,dp);
            dp[p1][p2]=Math.max(x,y);
            return Math.max(x,y);
         }
    }
}