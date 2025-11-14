class FreqStack {
    Map<Integer,Integer> countMap;
    Map<Integer,Stack<Integer>> hMap;
    public FreqStack() {
       countMap=new HashMap<>();
       hMap=new HashMap<>(); 
    }
    
    public void push(int val) {
        countMap.put(val,countMap.getOrDefault(val,0)+1);
        int freq=countMap.get(val);
        if(hMap.containsKey(freq)){
          hMap.get(freq).push(val);
        }else{
          Stack<Integer> stack=new Stack<>();
          stack.push(val);
          hMap.put(freq,stack);
        }
    }
    
    public int pop() {
       int size=hMap.size();
      int res=hMap.get(size).pop();
      countMap.put(res,countMap.get(res)-1);
      if(hMap.get(size).size()==0){
        hMap.remove(size);
      } 
      return res;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */