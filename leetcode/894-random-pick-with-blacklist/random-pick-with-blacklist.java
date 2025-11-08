class Solution {

    Map<Integer,Integer> hMap;
    int n;
    int[] blacklist;
    int size;
    Random r;

    public Solution(int n, int[] blacklist) {
      this.n=n;
      this.blacklist=blacklist;
      r=new Random();
      hMap=new HashMap<>();
      for(int i=0;i<blacklist.length;i++){
        hMap.put(blacklist[i],-1);
      }
      size=n-blacklist.length;
      int k=n-1;
      for(int i=0;i<blacklist.length;i++){
        if(blacklist[i]<size){
            while(hMap.containsKey(k)){
                k--;
            }
            hMap.put(blacklist[i],k);
            k--;
        }
      }  
    }
    
    public int pick() {
        int n=r.nextInt(0,size);
        if(hMap.containsKey(n)){
            return hMap.get(n);
        }
        return n;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */