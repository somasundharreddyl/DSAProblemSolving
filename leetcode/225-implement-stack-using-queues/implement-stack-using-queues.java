class MyStack {
    Queue<Integer> q1;
    public MyStack() {
       q1=new LinkedList<>(); 
    }
    
    public void push(int x) {
        q1.add(x);
    }
    
    public int pop() {
       int size=q1.size();
       for(int i=0;i<size-1;i++){
        q1.add(q1.remove());
       }
       return q1.remove(); 
    }
    
    public int top() {
        int size=q1.size();
       for(int i=0;i<size-1;i++){
        q1.add(q1.remove());
       }
       int res=q1.remove();
       q1.add(res);
       return res;
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */