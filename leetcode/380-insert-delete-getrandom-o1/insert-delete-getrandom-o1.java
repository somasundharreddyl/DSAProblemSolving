class RandomizedSet {

    List<Integer> arrList;
    Map<Integer,Integer> hm;
    Random r;
    public RandomizedSet() {
      arrList=new ArrayList<>();
      r=new Random();
      hm=new HashMap<>();  
    }
    
    public boolean insert(int val) {
        if(!hm.containsKey(val)){
           arrList.add(val);
           hm.put(val,arrList.size()-1);
           return true;
        }else{
            return false;
        }
    }
    
    public boolean remove(int val) {
         if (hm.containsKey(val) == false) { 
            return false; 
        } 
 
        int idx = hm.get(val); 
          hm.remove(val); 
        if (idx == arrList.size()-1) { 
            arrList.remove(arrList.size()-1); 
            return true; 
        } 
        int idx2 = arrList.size()-1; 
        int temp = arrList.get(idx2); 
        swap(idx,idx2); 
        arrList.remove(arrList.size()-1); 
         
        hm.put(temp,idx); 
        return true; 
    }
    
    public int getRandom() {
        int idx=r.nextInt(0,arrList.size());
        return arrList.get(idx);
    }

     public void swap(int i,int j){ 
        int a = arrList.get(i); 
        int b = arrList.get(j); 
        arrList.set(i,b); 
        arrList.set(j,a); 
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */