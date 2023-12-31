class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st=new Stack<>();
        int i=0,j=0;
        while(i<pushed.length && j<popped.length){
            if(st.size()==0){
                st.push(pushed[i]);
                i++;
                continue;
            }

            if(st.peek()!=popped[j]){
              st.push(pushed[i]);
                i++;
            }else{
                st.pop();
                j++;
            }
        }
        while(j<popped.length){
        if(st.peek()==popped[j]){
            st.pop();
            j++;
        }
        else{
            return false;
        }
        }
        // if(st.size()==0){
        //     return true;
        // }

         return true;
    }
}