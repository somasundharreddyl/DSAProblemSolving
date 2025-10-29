class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer,Integer> hm = new HashMap<>();
        for(List<Integer> l:wall){
            int sum=0;
            for(int i=0;i<l.size()-1;i++){
                sum+=l.get(i);
                hm.put(sum,hm.getOrDefault(sum,0)+1);
            }
        }
        int max=0;
        if(hm.size()>0){
        for(int key:hm.keySet()){
            max=max>hm.get(key)?max:hm.get(key);
        }
        }
        return wall.size()-max;
    }
}

