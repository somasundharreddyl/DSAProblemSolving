class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Pair[] pairs=new Pair[envelopes.length];
        for(int i=0;i<envelopes.length;i++){
            pairs[i]=new Pair(envelopes[i][0],envelopes[i][1]);
        }
        Arrays.sort(pairs,new Pair());
        int[] dp=new int[pairs.length];
        dp[0]=pairs[0].y;
        int ans=1;
        for(int i=1;i<pairs.length;i++){
            int l=0,h=ans;
            while(l<h){
                int m=l+(h-l)/2;
                if(dp[m]<pairs[i].y){
                    l=m+1;
                }else{
                    h=m;
                }
            }
            dp[l]=pairs[i].y;
            if(l==ans){ans++;}
        }
        return ans--;
    }
}
class Pair implements Comparator<Pair>{
    int x;
    int y;
    public Pair(int x, int y){
        this.x=x;
        this.y=y;
    }
    public Pair(){
    }
    
    public int compare(Pair p1,Pair p2){
        if(p1.x==p2.x){
            return p2.y-(p1.y);
        }else{
            return p1.x-(p2.x);
        }
    }
}