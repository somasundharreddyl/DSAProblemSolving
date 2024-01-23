class Solution {

    private int gcd(int a, int b){
        if(a==0){
            return b;
        }
        return gcd(b%a,a);
    }
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<deck.length;i++){
            if(map.containsKey(deck[i])==false){
                map.put(deck[i],1);
            }else{
                int value=map.get(deck[i]);
                map.put(deck[i],value+1);
            }
        }
         int ans=0;
        for(int key:map.keySet()){
            ans=gcd(ans,map.get(key));
        }
        if(ans<=1){
            return false;
        }
        return true;
    }
}