class Solution {
    public int leastBricks(List<List<Integer>> wall) {
       // List<List<Integer>> prefixList=new ArrayList<>();
        Map<Integer,Integer> countMap=new HashMap<>();
        for(int i=0;i<wall.size();i++){
          //  List<Integer> list=new ArrayList<>();
            List<Integer> w=wall.get(i);
            int sum=0;
            for(int j=0;j<w.size()-1;j++){
                if(j==0){
                   countMap.put(w.get(j),countMap.getOrDefault(w.get(j),0)+1);
                   sum+=w.get(j);
                }else{
                    countMap.put(w.get(j)+sum,countMap.getOrDefault(w.get(j)+sum,0)+1);
                   sum+=w.get(j);
                }
            }
          // prefixList.add(list); 
        }
        if(countMap.size()<=0){
            return wall.size();
        }
        int max=Integer.MIN_VALUE;
        for(int key:countMap.keySet()){
            max=max>countMap.get(key)?max:countMap.get(key);
        }
        return wall.size()-max;

    }
}