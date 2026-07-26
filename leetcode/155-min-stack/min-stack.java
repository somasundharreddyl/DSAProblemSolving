class MinStack {

    Stack<Long> stack;
    long min;

    public MinStack() {
        stack=new Stack<>();
        min=-1L;
    }
    
    public void push(int value) {
       if(stack.isEmpty()){
        min=value;
       }
       long diff=(long)value-min;
       stack.push(diff);
       if(diff<0){
        min=value;
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
       if(rem<0){
        return (int)(min);
       }
       return (int)(min+rem); 
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