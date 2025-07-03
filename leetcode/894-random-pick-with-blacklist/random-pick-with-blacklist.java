class Solution {

    Map<Integer,Integer> hm;
    Random r;
    int valid;
    public Solution(int n, int[] blacklist) {
     r=new Random();
     hm=new HashMap<>();
     valid=n-blacklist.length;
     for(int i=0;i<blacklist.length;i++){
        hm.put(blacklist[i],-1);
     }
     int val=n-1;
     for(int i=0;i<blacklist.length;i++){
        if(blacklist[i]<valid){
            while(hm.containsKey(val)){
               val--;
            }
            hm.put(blacklist[i],val);
            val--;
        }
     }

    }
    
    public int pick() {
      int n= r.nextInt(0,valid);
      if(hm.containsKey(n)){
        return hm.get(n);
      }
      return n;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */