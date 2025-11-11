class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] lsn=new int[heights.length];
        int[] rsn=new int[heights.length];
        Arrays.fill(lsn,-1);
        Arrays.fill(rsn,-1);
        Stack<Integer> leftStack=new Stack<>();
        Stack<Integer> rightStack=new Stack<>();
        for(int i=0;i<heights.length;i++){
            if(rightStack.size()==0){
               rightStack.push(i); 
               continue;
            }
            while(rightStack.size()>0 && heights[rightStack.peek()]>heights[i]){
                rsn[rightStack.pop()]=i;
            }
            rightStack.push(i);
        }
        for(int i=heights.length-1;i>=0;i--){
            if(leftStack.size()==0){
               leftStack.push(i); 
               continue;
            }
            while(leftStack.size()>0 && heights[leftStack.peek()]>heights[i]){
                lsn[leftStack.pop()]=i;
            }
            leftStack.push(i);
        }
        int ans=0;
        for(int i=0;i<heights.length;i++){
            if(lsn[i]<0 && rsn[i]<0){
               int width=heights.length;
               ans=ans>(heights[i]*width)?ans:(heights[i]*width); 
            }else if(lsn[i]>=0 && rsn[i]>0){
               int width=(rsn[i]-1)-(lsn[i]+1)+1;
               ans=ans>(heights[i]*width)?ans:(heights[i]*width);
            }else if(lsn[i]>=0 && rsn[i]<0){
               int width=(heights.length-1)-(lsn[i]+1)+1;
               ans=ans>(heights[i]*width)?ans:(heights[i]*width);
            }else{
                int width=rsn[i];
               ans=ans>(heights[i]*width)?ans:(heights[i]*width); 
            }
        }
       return ans;
    }
}
//2,1,5
//5,1,2
//-1,-1,1
//