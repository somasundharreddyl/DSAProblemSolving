class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
       int n=nums.length;
       int[] ans=new int[n-k+1];
       Deque<Integer> q=new ArrayDeque<>();
       int max=Integer.MIN_VALUE;
       int p=0;
       for(int i=0;i<k;i++){
          max=max>nums[i]?max:nums[i];
          if(q.isEmpty()){
            q.add(nums[i]);
            continue;
          }
          while(!q.isEmpty() && nums[i]>q.peekLast()){
            q.removeLast();
          }
          q.addLast(nums[i]);
       }
       ans[p]=max;
       p++;
       for(int i=k;i<n;i++){
        if(!q.isEmpty() && nums[i-k]==q.peekFirst()){
            q.removeFirst();
        }
        while(!q.isEmpty() && nums[i]>q.peekLast()){
            q.removeLast();
        }
            q.addLast(nums[i]);
            ans[p]=q.peekFirst();
            p++;
       }
     return ans;
    }
}

//q=[3,-1]