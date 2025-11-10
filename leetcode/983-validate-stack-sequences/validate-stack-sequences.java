class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack=new Stack<>();
        int i=0,j=0;
        while(i<pushed.length){
            if(stack.size()==0){
                stack.push(pushed[i]);
                i++;
                continue;
            }
            if(popped[j]==stack.peek()){
              stack.pop();
              j++;
            }else{
                stack.push(pushed[i]);
                i++;
            }
        }

        while(stack.size()>0){
            if(popped[j]==stack.peek()){
              stack.pop();
              j++;
            }else{
                return false;
            }
        }
        return true;
    }
}