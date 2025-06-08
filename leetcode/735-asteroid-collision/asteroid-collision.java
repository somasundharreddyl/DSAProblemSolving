class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        int i=0;
        while(i<asteroids.length){
            if(stack.size()==0){
                stack.push(asteroids[i]);
                i++;
                continue;
            }
            if(asteroids[i]<0 && stack.peek()>=0 && (Math.abs(asteroids[i])<stack.peek())){
                 i++;
            }else if(asteroids[i]<0 && stack.peek()>=0 && (Math.abs(asteroids[i])>stack.peek())){
                 stack.pop();
            }else if(asteroids[i]<0 && stack.peek()>=0 && (Math.abs(asteroids[i])==stack.peek())){
                 stack.pop();
                 i++;
            }
            else{
                stack.push(asteroids[i]);
                i++;
            }
        }
        int[] ans=new int[stack.size()];
        int j=ans.length-1;
        while(j>=0){
            ans[j]=stack.pop();
                  j--;
        }
        return ans;
}
}