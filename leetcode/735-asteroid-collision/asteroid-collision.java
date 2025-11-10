class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<asteroids.length;i++){
          if(stack.size()==0){
            stack.push(asteroids[i]);
            continue;
          }
          if(stack.size()>0 && (stack.peek()>=0 && asteroids[i]<0) ){
            while(stack.size()>0 && (stack.peek()>=0 && asteroids[i]<0)){
             if(Math.abs(asteroids[i])<stack.peek()){
                break;
             }else if(Math.abs(asteroids[i])==stack.peek()){
                stack.pop();
                break;
             }else{
                stack.pop();
                if(stack.size()==0 || stack.peek()<0){
                stack.push(asteroids[i]);
                break;
            }
             }
            }
             
          }else{
          stack.push(asteroids[i]);
          }
        }
        if(stack.size()==0){
            return new int[]{};
        }
        int[] ans=new int[stack.size()];
        for(int i=ans.length-1;i>=0;i--){
            ans[i]=stack.pop();
        }
        return ans;
    }
}