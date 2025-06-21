class FreqStack {

    Map<Integer,Stack<Integer>> stackMap;
    Map<Integer,Integer> freqMap;
    public FreqStack() {
        stackMap=new HashMap<>();
        freqMap=new HashMap<>();
    }
    
    public void push(int val) {
        int freq=freqMap.getOrDefault(val,0)+1;
        freqMap.put(val,freq);
        if(stackMap.containsKey(freq)){
           Stack<Integer> st=stackMap.get(freq);
           st.push(val);
           stackMap.put(freq,st);
        }else{
           Stack<Integer> st=new Stack<>();
           st.push(val);
           stackMap.put(freq,st);  
        }
    }
    
    public int pop() {
        int size=stackMap.size();
        Stack<Integer> st=stackMap.get(size);
        int rem=st.pop();
        freqMap.put(rem,freqMap.get(rem)-1);
        if(st.size()==0){
            stackMap.remove(size);
        }
        return rem;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */