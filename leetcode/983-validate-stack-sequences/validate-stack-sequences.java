class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack=new Stack<>();
        int k=0;
        for(int i=0;i<pushed.length;i++){
            if(stack.isEmpty()){
                stack.push(pushed[i]);
                continue;   
            }

            while(!stack.isEmpty() && popped[k]==stack.peek()){
               stack.pop();
               k++;
            }
            stack.push(pushed[i]);
        }
        while(!stack.isEmpty() && popped[k]==stack.peek()){
               stack.pop();
               k++;
        }
        return stack.isEmpty();
    }
}