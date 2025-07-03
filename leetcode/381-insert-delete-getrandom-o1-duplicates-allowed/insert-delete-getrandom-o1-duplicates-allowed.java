class RandomizedCollection {
    Map<Integer,Set<Integer>> hm;
    List<Integer> list;
    Random r;
    public RandomizedCollection() {
     r=new Random();
     list=new ArrayList<>();
     hm=new HashMap<>();   
    }
    
    public boolean insert(int val) {
        list.add(val);
      if(hm.containsKey(val)){
        hm.get(val).add(list.size()-1);
        return false;
      }
      Set<Integer> s=new HashSet<>();
      s.add(list.size()-1);
      hm.put(val,s);
      return true;  
    }
    
    public boolean remove(int val) {
        if(!hm.containsKey(val)){
            return false;
        }
      Set<Integer> set=hm.get(val);
      int idx=-1;
      for(int n:set){
        idx=n;
        break;
      }
      set.remove(idx);
      if(set.size()==0){
        hm.remove(val);
      }
      if(idx==list.size()-1){
        list.remove(idx);
        return true;
      }
      int idx2=list.size()-1;
      swap(idx,idx2);
      list.remove(idx2);
      hm.get(list.get(idx)).remove(idx2);
      hm.get(list.get(idx)).add(idx);
      return true;
    }
    
    public int getRandom() {
        int idx=r.nextInt(0,list.size());
        return list.get(idx);
    }

    public void swap(int idx1,int idx2){
        int v1=list.get(idx1);
        int v2=list.get(idx2);
        list.set(idx1,v2);
        list.set(idx2,v1);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */