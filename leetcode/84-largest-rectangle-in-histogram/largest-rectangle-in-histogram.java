class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea=Integer.MIN_VALUE;
        Stack<Integer> stack1=new Stack<>();
        Stack<Integer> stack2=new Stack<>();
        int[] nextsmallerLeft=new int[heights.length];
        int[] nextSmallerRight=new int[heights.length];
        Arrays.fill(nextsmallerLeft,-1);
        Arrays.fill(nextSmallerRight,-1);
        for(int i=heights.length-1;i>=0;i--){
            if(stack1.isEmpty()){
                stack1.push(i);
                continue;
            }
            while(stack1.size()>0 && heights[i]<heights[stack1.peek()]){
                nextsmallerLeft[stack1.pop()]=i;
            }
            stack1.push(i);
        }

        for(int i=0;i<heights.length;i++){
            if(stack2.isEmpty()){
                stack2.push(i);
                continue;
            }
            while(stack2.size()>0 && heights[i]<heights[stack2.peek()]){
                nextSmallerRight[stack2.pop()]=i;
            }
            stack2.push(i);
        }
         
        for(int i=0;i<heights.length;i++){
          int left=nextsmallerLeft[i]==-1?0:nextsmallerLeft[i]+1;
          int right=nextSmallerRight[i]==-1?heights.length-1:nextSmallerRight[i]-1;
          int area=((right)-(left)+1)*heights[i];
          maxArea=maxArea>area?maxArea:area;
        }
        return maxArea;
    }
}