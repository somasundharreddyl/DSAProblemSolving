class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        boolean isvalid=true;
        int i=0;
        while(i<s.length()){
            if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{' || stack.size()==0){
                stack.push(s.charAt(i));
            }else if((s.charAt(i)==')' && stack.peek()=='(') || (s.charAt(i)==']' && stack.peek()=='[') || (s.charAt(i)=='}' && stack.peek()=='{')){
                stack.pop();
            }else{
                stack.push(s.charAt(i));
            }
            i++;
        }
        if(stack.size()==0){
            return isvalid;
        }else{
            return !isvalid;
        }
    }
}