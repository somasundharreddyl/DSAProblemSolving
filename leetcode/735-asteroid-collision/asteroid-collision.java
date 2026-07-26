class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<asteroids.length;i++){
           if(stack.isEmpty()){
            stack.push(asteroids[i]);
            continue;
           }
           if(stack.peek()>0 && asteroids[i]<0){
           while(stack.peek()>0 && asteroids[i]<0){
             if(stack.peek()==Math.abs(asteroids[i])){
                stack.pop();
                break;
             }else if(stack.peek()>Math.abs(asteroids[i])){
                break;
             }
             if(stack.peek()<Math.abs(asteroids[i])){
                stack.pop();
                if(stack.isEmpty() || stack.peek()<0){
                    stack.push(asteroids[i]);
                    break;
                }
             }else{
                break;
             }

           }
           }else{
               stack.push(asteroids[i]);
           }
        }
        int n=stack.size();
        int[] ans=new int[n];
        for(int i=n-1;i>=0;i--){
            ans[i]=stack.pop();
        }
        return ans;
    }
}