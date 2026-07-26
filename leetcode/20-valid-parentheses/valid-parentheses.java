class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            
                if(s.charAt(i)=='('){
                    stack.push(')');
                    continue;
                }else if(s.charAt(i)=='['){
                    stack.push(']');
                    continue;
                }else if(s.charAt(i)=='{'){
                    stack.push('}');
                    continue;
                }
                
            if(!stack.isEmpty() && s.charAt(i)!=stack.peek()){
               return false;
            }else if(!stack.isEmpty()){
                stack.pop();
            }else{
                return false;
            }

            }
        return stack.size()==0;
    }
}