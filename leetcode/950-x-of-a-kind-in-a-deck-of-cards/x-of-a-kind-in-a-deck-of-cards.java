class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<deck.length;i++){
          map.put(deck[i],map.getOrDefault(deck[i],0)+1);
        }
        int ans=0;
        for(int n:map.keySet()){
           ans=gcd(map.get(n),ans);
        }
        if(ans!=1){
            return true;
        }else{
            return false;
        }
    }
    public int gcd(int a, int b){
        if(a==0){return b;}
        return gcd(b%a,a);
    }
}