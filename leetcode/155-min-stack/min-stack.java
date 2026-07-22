class MinStack {

    Stack<Long> stack;
    long min;

    public MinStack() {
        stack=new Stack<Long>();
        min=Long.MIN_VALUE;
    }
    
    public void push(int value) {
        if(stack.isEmpty()){
            stack.push(0L);
            min=value;
        }else{
            stack.push(value-min);
            min=min<value?min:value;
        }
    }
    
    public void pop() {
        long rem=stack.pop();
        if(rem<0){
          min=min-rem;
        }
    }
    
    public int top() {
        long rem=stack.peek();
        if(rem>=0){
          return (int)(min+rem);
        }else{
          return (int)(min); 
        }
    }
    
    public int getMin() {
          return (int)min; 
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */