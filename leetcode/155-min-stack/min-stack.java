class MinStack {

    Stack<Long> stack;
    long minVal;
    public MinStack() {
        stack=new Stack<>();
        minVal=-1;
    }
    
    public void push(int val) {
        if(stack.size()==0){
          stack.push(0L);
          minVal=val;
        }else{
            long diff=val-minVal;
            stack.push(diff);
            if(diff<0){
              minVal=val;  
            }
        }
    }
    
    public void pop() {
        long val=stack.pop();
        if(val<0){
            minVal=minVal-val;
        }
    }
    
    public int top() {
        long val=stack.peek();
        if(val<0){
        return (int)minVal;
        }
        return (int)(minVal+val);
    }
    
    public int getMin() {
        return (int)minVal;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */