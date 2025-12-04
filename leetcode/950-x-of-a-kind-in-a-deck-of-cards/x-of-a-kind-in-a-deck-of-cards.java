class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer,Integer> hMap=new HashMap<>();
        for(int d:deck){
            hMap.put(d,hMap.getOrDefault(d,0)+1);
        }
        int gcd=0;
        for(int key:hMap.keySet()){
          gcd=gcd(gcd,hMap.get(key));
        }
        if(gcd==1){
            return false;
        }
        return true;
    }
    public int gcd(int a, int b){
        if(a==0){
            return b;
        }
        return gcd(b%a,a);
    }
}