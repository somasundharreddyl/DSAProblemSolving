class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(st.size()<=0){
                st.push(s.charAt(i));
            }
            else if(st.peek()=='(' && s.charAt(i)==')' || 
            st.peek()=='{' && s.charAt(i)=='}' || st.peek()=='[' && s.charAt(i)==']'){
                st.pop();
            }else{
                st.push(s.charAt(i));
            }
        }
        if(st.size()>0){
            return false;
        }
        return true;
    }
}