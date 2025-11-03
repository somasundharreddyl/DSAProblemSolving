class RandomizedSet {

    Map<Integer,Integer> hm;
    List<Integer> list;
    Random r;

    public RandomizedSet() {
       hm=new HashMap<>();
       list=new ArrayList<>(); 
       r=new Random();
    }
    
    public boolean insert(int val) {
        if(!hm.containsKey(val)){
          list.add(val);
          int idx=list.size()-1;
         hm.put(val,idx);
         return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        if(hm.containsKey(val)){
           int idx1=hm.get(val);
           hm.remove(val);
           int idx2=list.size()-1;
           if(idx1!=idx2){
             int temp=list.get(idx1);
             list.set(idx1,list.get(idx2));
             list.set(idx2,temp);
             hm.put(list.get(idx1),idx1);
           }
           list.remove(idx2);

           return true;
        }
        return false;
    }
    
    public int getRandom() {
        int idx=r.nextInt(0,list.size());
        return list.get(idx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */