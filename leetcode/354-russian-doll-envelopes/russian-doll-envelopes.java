class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Dimension[] dim=new Dimension[envelopes.length];
        for(int i=0;i<dim.length;i++){
            Dimension d=new Dimension(envelopes[i][0],envelopes[i][1]);
            dim[i]=d;
        }
        Arrays.sort(dim);
        int[] dp=new int[dim.length];
        int ans=0;
        for(int i=0;i<dim.length;i++){
            int start=0,end=ans;
            while(start<end){
                int mid=start+(end-start)/2;
                if(dp[mid]<dim[i].y){
                  start=mid+1;
                }else{
                  end=mid;
                }
            }
            dp[start]=dim[i].y;
            if(ans==start){
                ans++;
            }
        }
        return ans;
    }
    
}
class Dimension implements Comparable<Dimension>{
    int x;
    int y;
    public Dimension(int x,int y){
        this.x=x;
        this.y=y;
    }
    @Override
    public int compareTo(Dimension d){
      if(this.x==d.x){
        return d.y-this.y;
      }  
      return this.x-d.x;
    }
}