class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp=new int[word1.length()][word2.length()];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        int p1=word1.length()-1,p2=word2.length()-1;
        return editDistance(word1,word2,p1,p2,dp);
    }
    public int editDistance(String word1, String word2,int p1,int p2,int[][] dp){
        if(p1<0 && p2<0){return 0;}
        if(p1<0 && p2>=0){return p2+1;}
        if(p2<0 && p1>=0){return p1+1;}

        if(dp[p1][p2]!=-1){return dp[p1][p2];}

        if(word1.charAt(p1)!=word2.charAt(p2)){
          int x=editDistance(word1,word2,p1-1,p2-1,dp);
          int y=editDistance(word1,word2,p1-1,p2,dp);
          int z=editDistance(word1,word2,p1,p2-1,dp);
          dp[p1][p2]=Math.min(x,Math.min(y,z))+1;
          return Math.min(x,Math.min(y,z))+1;
        }else{
            dp[p1][p2]=editDistance(word1,word2,p1-1,p2-1,dp);;
            return editDistance(word1,word2,p1-1,p2-1,dp);
        }
    }
}